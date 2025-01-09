import socket
from sys import argv
from threading import Thread

from template_pb2 import Message, FastHandshake


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

def listen_for_messages(conn):
    while True:
        try:
            msg = receive_message(conn, Message)
            print(f"\nReceived: {msg.msg} from {msg.fr} to {msg.to}")
            if msg.msg == "end":
                print("Connection closed by server")
                break
        except Exception as e:
            print(f"Error receiving message: {e}")
            break

def main():
    host = None
    port = None
    try:
        if len(argv) > 2:
            host = argv[1]
            port = int(argv[2])
        elif len(argv) > 1:
            port = int(argv[1])
        else:
            raise ValueError
    except:
        host = host or "127.0.0.1"
        port = 8080

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((host, port))
        print("Connected to the server")
        # Wait for the server to send the FastHandshake message
        handshake = receive_message(s, FastHandshake)
        if handshake.error:
            print("Server rejected the connection")
            return

        print(f"we are client #{handshake.id}")
        id = handshake.id

        #Thread for received messages
        Thread(target=listen_for_messages, args=(s,), daemon=True).start()

        while True:
            try:
                data = input("Enter a message using the format [id] [message]: ")
            except:
                data = "end"

            #Make the user respect the format [id] [message]
            try:
                to_id, msg_text = data.split(" ", 1)
                to_id = int(to_id)
            except ValueError:
                print("Invalid input format. Use the format [id] [message]:")
                continue

            msg = Message(fr=id, to=to_id, msg=msg_text)
            send_message(s, msg)

            if msg_text == "end":
                break

            if msg.msg == "end":
                break
        print("Closing connection")


if __name__ == "__main__":
    main()
