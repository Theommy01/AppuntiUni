import socket
from sys import argv


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
        while True:
            try:
                data = input("Enter a message: ")
            except:
                data = "exit"
            s.sendall(data.encode())
            print("Message sent")
            if data == "exit":
                break
            response = s.recv(1024)
            print(f"Received: {response.decode()}")
        print("Closing connection")


if __name__ == "__main__":
    main()
