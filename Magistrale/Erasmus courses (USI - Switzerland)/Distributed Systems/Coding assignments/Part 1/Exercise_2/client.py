import socket

def tcp_client():
    # Assign server's IP and port
    server_ip = '127.0.0.1'  # localhost
    server_port = 8080

    # Create a socket object (IPv4, TCP)
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:
        # Connect to the server
        client_socket.connect((server_ip, server_port))
        print(f"Connection to {server_ip}:{server_port} successfully!")

         # Send message to the server
        message = input("Enter message to send to the server: ")
        client_socket.send(message.encode("utf-8"))

        # Receive server reply
        data = client_socket.recv(1024)
        print(f"Server message: {data.decode('utf-8')}")  # It is expected to be the input in line20 of server.py file

    except Exception as e:(
            print(f"A connection error eccured: {e}"))

    finally:
        # Close connection
        client_socket.close()
        print("Connection closed succesfully")

# Run client
if __name__ == "__main__":
    tcp_client()

#!!! Client will not run if serves is not running yet.
#In order for this program works, run (server.py) for first !!!

#Further information in the instructions provided in (server.py) file