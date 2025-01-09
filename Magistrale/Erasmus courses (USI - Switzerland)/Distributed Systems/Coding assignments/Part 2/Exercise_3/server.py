import socket
from sys import argv
from threading import Thread
import handshake_pb2  # Import the generated protobuf classes
import random

# List to keep track of connected clients and their IDs
clients = {}


def handle_client(conn, addr):
    global clients
    with conn:
        print(f"Connected by {addr}")

        # Initialize a handshake response
        handshake_response = handshake_pb2.Handshake()

        # Assign a unique ID to the client, for example by means of a random integer
        client_id = random.randint(1, 1000000)
        handshake_response.id = client_id
        handshake_response.error = False  # By defaulte, no error occurres

        # Send the handshake message to the client
        conn.sendall(handshake_response.SerializeToString())

        # Notify all other clients about new connections
        notification = f"Client {addr} with ID {client_id} has joined the chat."
        broadcast(notification.encode(), conn)

        # Add new clients to the defined dictionary
        clients[conn] = client_id

        while True:
            data = conn.recv(1024)
            if not data:
                break

            # Check if the message is in the format "ID:message"
            try:
                target_id, message = data.decode().split(":", 1)
                target_id = int(target_id.strip())
                message = message.strip()
                send_to_client(target_id, message, client_id)
            except ValueError:
                print(f"Received invalid message format from {addr}: {data.decode()}")

        print(f"Closing connection to {addr}")

        # Remove the client from the list if/when disconnected
        del clients[conn]
        notification = f"Client {addr} with ID {client_id} has left the chat."
        broadcast(notification.encode(), conn)


def send_to_client(target_id, message, sender_id):
    """Send a message to a specific client based on ID."""
    for client, client_id in clients.items():
        if client_id == target_id:
            try:
                client.sendall(f"From {sender_id}: {message}".encode())
                return
            except:
                pass  # Handle the case where the client is disconnected
    # If the target client ID does not exist, inform the sender
    error_message = f"Error: Target client ID {target_id} not found."
    # Send error message back to the sender
    for client, client_id in clients.items():
        if client_id == sender_id:
            try:
                client.sendall(error_message.encode())
                return
            except:
                pass


def broadcast(message, sender_conn):
    """Send a message to all connected clients except the sender."""
    for client in clients.keys():
        if client != sender_conn:
            try:
                client.sendall(message)
            except:
                pass  # Handle the case where the client is disconnected


def main():
    try:
        port = int(argv[1])
    except:
        port = 8080

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind(("0.0.0.0", port))
        print(f"Server started on port {port}")
        print("Waiting for a client...")
        s.listen()
        while True:
            try:
                conn, addr = s.accept()
                Thread(target=handle_client, args=(conn, addr)).start()
            except KeyboardInterrupt:
                break


if __name__ == "__main__":
    main()