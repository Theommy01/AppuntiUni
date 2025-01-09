import socket
from sys import argv
import handshake_pb2  # Import the generated protobuf classes
import threading

def listen_for_messages(s):
    # Thread to listen for messages from the server.
    while True:
        try:
            message = s.recv(1024)
            if not message:
                break
            print(f"Notification: {message.decode()}")
        except:
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

        # Start a thread to listen for messages from the server
        threading.Thread(target=listen_for_messages, args=(s,), daemon=True).start()

        # Receive the handshake message
        handshake_data = s.recv(1024)
        handshake_response = handshake_pb2.Handshake()
        handshake_response.ParseFromString(handshake_data)

        if handshake_response.error:
            print("Error during handshake. Closing connection.")
            return  # Close the connection if an error occurres
        else:
            print(f"Handshake successful. Assigned ID: {handshake_response.id}")

        while True:
            try:
                target_id = input("Enter recipient ID : ")
                target_id = int(target_id)

                message = input("Enter your message: ")

                s.sendall(f"{target_id}:{message}".encode())
            except ValueError:
                print("Invalid ID. Please enter a valid recipient ID.")
            except Exception as e:
                print(f"Error sending message: {e}")

        print("Closing connection")

if __name__ == "__main__":
    main()