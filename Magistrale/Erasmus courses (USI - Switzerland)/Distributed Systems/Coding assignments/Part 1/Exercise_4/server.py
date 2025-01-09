import socket
import threading
from sys import argv

clients = []
aliases = []

def broadcast(message):
    #Send a message to all the clients
    for client in clients:
         client.send(message)

def handle_client(client):
    #Handle communications with a specific client
    while True:
        try:
            message = client.recv(1024).decode('utf-8')

            if message.lower().endswith('end'): 
                index = clients.index(client)   
                alias = aliases[index]
                broadcast(f"{alias} has left the chat room!".encode('utf-8'))
                clients.remove(client)
                aliases.remove(alias)
                client.close()
                break

            broadcast(message.encode('utf-8'))
        except:
            #Handle disconnections (i.e.: terminal gets closed)
            index = clients.index(client)
            clients.remove(client)
            client.close()
            alias = aliases[index]
            broadcast(f"{alias} has left the chat room!".encode('utf-8'))
            aliases.remove(alias)
            break

def receive():

    try:
        port = int(argv[1])
    except:
        port = 8080

    print(f"Server started on port {port}")

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind(("0.0.0.0", port))

        s.listen(5)

        while True:
            print('Waiting for a client...')
            client, addr = s.accept()
            print(f"Connected by: {addr}")

            #Inform the client that he has to choose an alias
            client.send('Please, register with an alias'.encode('utf-8'))
            alias = client.recv(1024).decode('utf-8')
            aliases.append(alias)
            clients.append(client)
            print(f"Alias of this client registered: {alias}".encode('utf-8'))
            broadcast(f"{alias} has connected to the chat room!".encode('utf-8'))

            client.send('You are connected :-).'.encode('utf-8'))
            #Inform the user that, if its message ends with 'end', he'll exit the room
            client.send('\nRemember that, when your message ends with "end",'
                        'you will exit the room. \n'.encode('utf-8'))
            client.send('This includes also words as pretend, contend etc. \nTo avoid unexpected exits, please '
                        'remember to type a full stop (.) at the end of you message.'.encode('utf-8'))

            thread = threading.Thread(target=handle_client, args=(client,))
            thread.start()

if __name__ == "__main__":
    receive()

# HOW TO TEST THE CODE
# 1) In a first terminal, run "python main.py port", replacing "port" with the desired port number (default: 8080).
# 2) Open as much other terminals in the same folder as many clients you want to include