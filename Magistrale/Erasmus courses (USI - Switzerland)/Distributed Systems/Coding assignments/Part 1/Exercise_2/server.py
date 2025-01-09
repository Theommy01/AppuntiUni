import socket
import threading
from sys import argv


# Function to handle each client connection
def handle_client(client, addr):
     print(f"Connected by: {addr}")

     while True:
          try:
               # Receive data from the client
               data = client.recv(1024).decode("utf-8")
               if not data:
                    break

               print(f"Received from {addr}: {data}")

               # Send a response back to the client
               response = f"Server received: {data}"
               client.send(response.encode("utf-8"))

          except ConnectionResetError:
               # Manage a connection error (for example, if "client terminal" gets closed
               print(f"Connection with {addr} closed unexpectedly")
               break

     client.close()
     print(f"Connection with {addr} closed")


def tcp_server():
     # Get the port number from terminal input, or default to 8080 if not provided
     try:
          port = int(argv[1])
     except:
          port = 8080

     print(f"Server started on port {port}")

     with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
          # Bind the server to all network interfaces
          s.bind(("0.0.0.0", port))
          s.listen(5)
          print("Waiting for clients...")

          while True:
               # Accept a client connection
               client, addr = s.accept()

               # In order to allow multiple clients simultaneously, use threading
               # This will create a different thread for each accepted connection

               # Create a new thread to handle the client
               client_thread = threading.Thread(target=handle_client, args=(client, addr))
               client_thread.start()

if __name__ == "__main__":
    tcp_server()

# HOW TO TEST THE CODE
# 1) Run this script (server.py) to start the server.
#    Alternatively, in a terminal, run "python main.py port", replacing "port" with the desired port number (default: 8080).
# 2) Open a second terminal in the folder where "client.py" is located.
# 3) In the second terminal, run the script (client.py)