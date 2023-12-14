package fr.sncf.d2d.messenger.client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocketHandler implements Runnable {

    public static ArrayList<ClientSocketHandler> clientSocketHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public ClientSocketHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            clientSocketHandlers.add(this);
            broadcastMessage("SERVER: " + clientUsername + "est dans Messenger");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void broadcastMessage(String messageToSend) {
        for (ClientSocketHandler clientSocketHandler : clientSocketHandlers) {
            try {
                if (!clientSocketHandler.clientUsername.equals(clientUsername)) {
                    clientSocketHandler.bufferedWriter.write(messageToSend);
                    clientSocketHandler.bufferedWriter.newLine();
                    clientSocketHandler.bufferedWriter.flush();

                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }

        }
    }

    public void removeClientSocketHandler() {
        clientSocketHandlers.remove(this);
        broadcastMessage("SERVER" + clientUsername + "a quitté Messenger");
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientSocketHandler();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
