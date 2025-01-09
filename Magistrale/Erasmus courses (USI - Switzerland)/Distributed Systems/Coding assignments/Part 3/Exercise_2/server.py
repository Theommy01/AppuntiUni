import socket
from sys import argv
from threading import Thread, Lock
from template_pb2 import Message, FastHandshake

CLIENTS = {}
MESSAGE_BUFFER = {}
LAST_ID = 0
ID_LOCK = Lock()

def send_message(conn, m):
    serialized = m.SerializeToString()
    conn.sendall(len(serialized).to_bytes(4, byteorder="big"))
    conn.sendall(serialized)

def receive_message(conn, m):
    msg = m()
    size = int.from_bytes(conn.recv(4), byteorder="big")
    data = conn.recv(size)
    msg.ParseFromString(data)
    return msg

def handle_client(conn: socket.socket, addr):
    global LAST_ID
    with conn:
        handshake = receive_message(conn, FastHandshake)
        requested_id = handshake.requested_id

        #Handle ID requests
        with ID_LOCK:
            if requested_id in CLIENTS:
                assigned_id = LAST_ID
                handshake_response = FastHandshake(assigned_id=assigned_id, error=True,
                                                   error_message=f"ID {requested_id} already in use. Assigned default"
                                                                 f" ID {LAST_ID}")
                LAST_ID += 1
            else:
                assigned_id = requested_id
                handshake_response = FastHandshake(assigned_id=assigned_id, error=False)

            #Send response handshake
            send_message(conn, handshake_response)

            #Store the client with the assigned ID
            CLIENTS[assigned_id] = (conn, addr)
            print(f"Connected by #{assigned_id} {addr}")

            #Send the waiting messages
            if assigned_id in MESSAGE_BUFFER:
                for buffered_msg in MESSAGE_BUFFER[assigned_id]:
                    send_message(conn, buffered_msg)
                del MESSAGE_BUFFER[assigned_id]

        while True:
            msg = receive_message(conn, Message)
            print(f"Received: {msg.msg} from {msg.fr} to {msg.to}")
            if msg.msg == "end":
                break

            if msg.to in CLIENTS:
                send_message(CLIENTS[msg.to][0], msg)
            else:
                #If the received does not exist, store it temporarely
                if msg.to not in MESSAGE_BUFFER:
                    MESSAGE_BUFFER[msg.to] = []
                MESSAGE_BUFFER[msg.to].append(msg)

        print(f"Closing connection to #{assigned_id} {addr}")
        CLIENTS.pop(assigned_id)

def loop_main(port):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind(("0.0.0.0", port))
        print(f"Server started on port {port}")
        s.listen()

        while True:
            try:
                conn, addr = s.accept()
                Thread(target=handle_client, args=(conn, addr)).start()
            except KeyboardInterrupt:
                print("Shutting down server.")
                break

def main():
    try:
        port = int(argv[1])
    except IndexError:
        port = 8080

    loop_main(port)

if __name__ == "__main__":
    main()