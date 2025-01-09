import socket
from sys import argv

def main():
    # Get the port number from terminal input, or default it to 8080 if not provided
    try:
        port = int(argv[1])
    except:
        port = 8080

    print(f"Server started on port {port}")

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        # Bind the server to all network interfaces (0.0.0.0 allows connections on any interface)
        s.bind(("0.0.0.0", port))

        # Set the server as "listening", to tell the o.s. the maximum number of possible pending connection requests
        # !In general, it is written as s.listen(backlog), with "backlog" as the
        # simultaneous allowed connections. If not specified, it will depend on the O.S.
        s.listen(5)
        print("Waiting for a client...")

        #Accept a client connection
        client, addr = s.accept() #client, addr corresponds to the input from the "second terminal"
        print(f"Connected by: {addr}")

        #Send a message to the connected client
        client.sendall(b"Hello") #Use sendall instead of send to guarantee that all the provided data are sent

        #Close the connection to free up the connection slot
        print("Closing connection")
        client.close()


if __name__ == "__main__":
    main()

# HOW TO TEST THE CODE
# 1) Run this script (main.py) to start the server.
#    Alternatively, in a terminal, run "python main.py port", replacing "port" with the desired port number (default: 8080).
# 2) Open a second terminal in the same folder where "main.py" is located.
# 3) In the second terminal, type: telnet 127.0.0.1 8080 to connect to the server.