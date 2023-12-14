package fr.sncf.d2d.messenger.server;

import fr.sncf.d2d.messenger.client.ClientSocketHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHandler {
    private ServerSocket serverSocket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

//    public ServerSocketHandler(ServerSocket serverSocket, InetAddress address, int port) {
//        try {
//            this.serverSocket = new ServerSocket();
//            this.outputStream = new ObjectOutputStream(socket.getOutputStream());
//            this.inputStream = new ObjectInputStream(socket.getInputStream());
//        } catch (IOException e) {
//            e.fillInStackTrace();
//        }
//    }

    public ServerSocketHandler(ServerSocket serverSocket) {
    this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Nouveau client connecté");
                ClientSocketHandler clientSocketHandler = new ClientSocketHandler(socket);

                Thread thread = new Thread(clientSocketHandler);
                thread.start();
            }
        } catch (IOException e) {

        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        ServerSocketHandler server = new ServerSocketHandler(serverSocket);
        server.startServer();

    }

//    public void sendObject(Object obj){
//        try{
//            outputStream.writeObject(obj);
//        } catch (IOException e) {
//            e.fillInStackTrace();
//        }
//    }
//
//    public Object receiveObject() {
//        try {
//            return inputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.fillInStackTrace();
//            return null;
//        }
//    }//   }
}