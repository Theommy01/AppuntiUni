import socket
import message_pb2  # Import the generated class
from sys import argv
from threading import Thread


def receive_messages(sock):
    while True:
        data = sock.recv(1024)
        if not data:
            break

        # Deserialize the received message
        received_message = message_pb2.Message()
        received_message.ParseFromString(data)

        if received_message.fromr == -1:
            # To indicate the error message as in server.py (line 48)
            print(f"\nError: {received_message.msg}\n")
        else:
            print(f"\nReceived from {received_message.fromr}: {received_message.msg}\n")

        print("Enter a message (or 'end' to quit): ", end='')


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

        # Prompt user for their ID and send it to the server
        while True:
            sender_id = int(input("Enter your ID: "))
            s.sendall(str(sender_id).encode())  # Send sender ID to the server

            # Wait for server response
            response = s.recv(1024).decode()
            if response.startswith("Error"):
                print(response)  # Print the error message and prompt again
            else:
                # ID accepted, break the loop
                print(f"Connected with ID {sender_id}.")
                break  

        # Start a thread to receive messages
        Thread(target=receive_messages, args=(s,), daemon=True).start()

        while True:
            data = input("Enter a message (or 'end' to quit): ")
            if data == "end":
                break

            # Create a new message object
            message = message_pb2.Message()
            message.fromr = sender_id  # Use the chosen sender ID
            message.to = int(input("Enter recipient ID: "))  # Prompt for receiver ID
            message.msg = data

            # Serialize the message
            serialized_message = message.SerializeToString()

            s.sendall(serialized_message)
            print("Message sent")

        print("Closing connection")


if __name__ == "__main__":
    main()

