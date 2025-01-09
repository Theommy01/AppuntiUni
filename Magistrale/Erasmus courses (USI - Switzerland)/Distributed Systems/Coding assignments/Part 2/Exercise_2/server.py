import socket
from sys import argv
from threading import Thread
import message_pb2  # Import the generated class

clients = {} # Global list to keep track of connected clients and their IDs
used_ids = set()  # Set to track used client IDs


def handle_client(conn, addr):
    global used_ids
    with conn:
        print(f"Connected by {addr}")

        while True:
            # Receive client's ID
            conn.sendall(b"Please enter your ID: ")
            sender_id = int(conn.recv(1024).decode())

            if sender_id in used_ids:
                # If the ID is in use, send an error message back
                conn.sendall(b"Error: ID is already in use. Please choose a different ID.")
            else:
                # Accept the ID
                used_ids.add(sender_id)  # Add to used IDs
                clients[sender_id] = conn  # Map the connection to the ID
                print(f"Client with ID {sender_id} connected.")
                break  # Exit the loop if ID is accepted

        while True:
            data = conn.recv(1024)
            if not data:
                break

            # Deserialize the received message
            received_message = message_pb2.Message()
            received_message.ParseFromString(data)

            print(f"Received from {received_message.fromr} to {received_message.to}: {received_message.msg}")

            # Check if the receiver client's id exists
            if received_message.to in clients:
                # Send him the message
                clients[received_message.to].sendall(data)
            else:
                # Send an error message back
                error_message = message_pb2.Message()
                error_message.fromr = -1  # Indicating an error
                error_message.to = received_message.fromr
                error_message.msg = f"Error: Recipient ID {received_message.to} does not exist."
                conn.sendall(error_message.SerializeToString())

        # Remove the client from the lists if/when they disconnect
        del clients[sender_id]  # Remove from clients
        used_ids.remove(sender_id)  # Remove from used IDs
        print(f"Closing connection to {addr}")


def main():
    try:
        port = int(argv[1])
    except:
        port = 8080

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind(("0.0.0.0", port))
        print(f"Server started on port {port}")
        print("Waiting for clients...")
        s.listen()

        while True:
            try:
                conn, addr = s.accept()
                Thread(target=handle_client, args=(conn, addr)).start()
            except KeyboardInterrupt:
                break


if __name__ == "__main__":
    main()

# How to run the code

#1) Run (server.py) in terminal
#2) Run as many client's terminal as you wish