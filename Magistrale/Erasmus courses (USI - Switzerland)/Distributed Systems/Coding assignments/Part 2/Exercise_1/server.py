import socket
from sys import argv
from threading import Thread

# Define a list to track connected clients
connected_clients = []

def handle_client(conn, addr):
    with conn:
        print(f"Connected by {addr}")
        connected_clients.append(addr)  # Add the new client to the list of connected clients
        try:
            while True:
                data = conn.recv(1024)
                if not data or data == b"exit":  # Close connection if client sends "exit"
                    break
                print(f"Received: {data.decode()}")  # Display received message
                conn.sendall(data)  # Echo back the message to the client
        finally:
            print(f"Closing connection to {addr}")
            connected_clients.remove(addr)  # Remove the client from the list upon disconnection

# Define the thread for server operator commands
def operator():
    while True:
        command = input("Operator: ")  # Input for server operator to execute commands
        if command == "num_users":  # Display number of currently connected clients
            print(f"Number of connected users: {len(connected_clients)}")


def main():
    try:
        port = int(argv[1])
    except:
        port = 8080

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind(("0.0.0.0", port))
        print(f"Server started on port {port}")
        print("Waiting for a client...")

        # Start the operator thread for server commands
        Thread(target=operator, daemon=True).start()

        s.listen()
        while True:
            try:
                conn, addr = s.accept()
                # Start a new thread for each client that connects
                Thread(target=handle_client, args=(conn, addr)).start()
            except KeyboardInterrupt:
                break


if __name__ == "__main__":
    main()
