import socket
from sys import argv
from threading import Thread
from template_pb2 import Message, FastHandshake
from snowflake import derive_id

PEERS = []
my_id = None
connections = {}


def send_message(conn, m):
    if conn is None:
        print("Invalid connection. Cannot send message.")
        return
    try:
        serialized = m.SerializeToString()
        conn.sendall(len(serialized).to_bytes(4, byteorder="big"))
        conn.sendall(serialized)
    except (BrokenPipeError, OSError) as e:
        print(f"Error while sending message: {e}")
        conn.close()


def receive_message(conn, m):
    try:
        size_bytes = conn.recv(4)
        if not size_bytes:
            return None
        size = int.from_bytes(size_bytes, byteorder="big")
        data = conn.recv(size)
        msg = m()
        msg.ParseFromString(data)
        return msg
    except Exception as e:
        print(f"Error while receiving message: {e}")
        return None


def handle_peer_connection(conn: socket.socket, addr):
    global my_id, connections
    peer_addr = None  # Initialize peer_addr here
    try:
        print(f"Connection accepted from {addr}")

        handshake = receive_message(conn, FastHandshake)
        if handshake is None or handshake.error:
            print(f"Handshake failed with peer {addr}")
            return

        peer_id = handshake.id
        peer_addr = f"{addr[0]}:{addr[1]}"
        connections[peer_addr] = conn  # Keep the connection open
        print(f"Connection established with peer #{peer_id} at {peer_addr}")

        while True:
            msg = receive_message(conn, Message)
            if msg is None or msg.msg == "end":
                break
            print(f"Message received: {msg.msg} from {msg.fr} to {msg.to}")

            # Forward the message to other peers if necessary
            if msg.to != my_id:
                msg.to = my_id  # Set the recipient to the current peer ID
                forward_message_to_peer(msg)

    except Exception as e:
        print(f"Error handling peer {addr}: {e}")
    finally:
        if peer_addr in connections:
            del connections[peer_addr]
        conn.close()
        print(f"Connection closed with peer {addr}")


def forward_message_to_peer(msg):
    for peer in PEERS:
        if peer in connections:
            try:
                send_message(connections[peer], msg)
                print(f"Message forwarded to peer {peer}")
            except (BrokenPipeError, OSError) as e:
                print(f"Error forwarding message to peer {peer}: {e}")
                del connections[peer]  # Remove the broken connection
        else:
            print(f"No active connection with peer {peer}")


def start_peer_server(host, port):
    try:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            s.bind((host, port))
            s.listen()
            print(f"Peer started on {host}:{port}")
            while True:
                conn, addr = s.accept()
                Thread(target=handle_peer_connection, args=(conn, addr)).start()
    except Exception as e:
        print(f"Error in peer server: {e}")


def connect_to_peers(peers):
    global connections
    for peer in peers:
        try:
            host, port = peer.split(':')
            port = int(port)

            s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            s.connect((host, port))
            print(f"Connected to peer {peer}")

            # Generate an ID using Snowflake
            my_id = derive_id(77252666718255104)  # Replace with appropriate assigner
            handshake = FastHandshake(id=my_id, error=False)
            send_message(s, handshake)
            connections[peer] = s  # Store the connection with the peer address

            # Start a new thread to handle incoming messages from this peer
            Thread(target=handle_peer_connection, args=(s, (host, port)), daemon=True).start()
        except ValueError as ve:
            print(f"Error in peer format {peer}: {ve}")
        except (ConnectionRefusedError, OSError) as e:
            print(f"Unable to connect to peer {peer}: {e}")


def main():
    global my_id, PEERS

    if len(argv) < 2:
        print("Usage: python e3.py [my ip]:[my port] --desired-id [my id] [peer ip]:[peer port] ...")
        return

    my_addr = argv[1]
    my_host, my_port = my_addr.split(':')
    my_port = int(my_port)

    if "--desired-id" in argv:
        my_id = int(argv[argv.index("--desired-id") + 1])
    else:
        print("Error: specify the desired ID with --desired-id")
        return

    # Collect other peers
    PEERS = argv[argv.index("--desired-id") + 2:]

    # Start the peer server
    Thread(target=start_peer_server, args=(my_host, my_port), daemon=True).start()

    # Connect to other peers
    connect_to_peers(PEERS)

    while True:
        try:
            msg = input("Enter the message: ")
            if msg == "end":
                break
            if msg:  # Check that the message is not empty
                m = Message(fr=my_id, to=my_id, msg=msg)
                forward_message_to_peer(m)

            # Attempt to reconnect to peers without active connections
            reconnect_peers = [peer for peer in PEERS if peer not in connections]
            if reconnect_peers:
                print("Attempting to reconnect to peers...")
                connect_to_peers(reconnect_peers)
        except Exception as e:
            print(f"Error while sending message: {e}")


if __name__ == "__main__":
    main()
