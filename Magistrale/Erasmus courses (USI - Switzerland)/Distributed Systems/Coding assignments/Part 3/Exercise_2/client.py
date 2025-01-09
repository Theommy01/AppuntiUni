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
                print("Connection closed by the server")
                break
        except Exception as e:
            print(f"Error receiving message: {e}")
            break


def main():
    host = "127.0.0.1"
    port = 8080

    if len(argv) > 1:
        try:
            requested_id = int(argv[1])  # ID requested as argument
        except ValueError:
            print("Invalid ID provided. It should be an integer.")
            return
    else:
        requested_id = int(input("Choose your client ID: "))

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((host, port))
        print("Connected to the server")

        #Send the handshake with the requested ID
        handshake = FastHandshake(requested_id=requested_id)
        send_message(s, handshake)

        #Receive handshake's response
        response = receive_message(s, FastHandshake)
        if response.error:
            print(
                f"Server rejected the requested ID {requested_id}. Error: {response.error_message}. Using assigned ID {response.assigned_id}")
        else:
            print(f"Assigned ID: {response.assigned_id}")
        id = response.assigned_id

        #Turn on the thread that listens to messages
        listener_thread = Thread(target=listen_for_messages, args=(s,))
        listener_thread.daemon = True
        listener_thread.start()

        while True:
            try:
                data = input("Enter a message (format: <id> <message>): ")
            except:
                data = "end"

            try:
                to, msg = data.split(" ", 1)
                to = int(to)
            except ValueError:
                print("Invalid input format. Use '<id> <message>'.")
                continue

            message = Message(fr=id, to=to, msg=msg)
            send_message(s, message)

            if msg == "end":
                break
        print("Closing connection")


if __name__ == "__main__":
    main()
