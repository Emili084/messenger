package fr.sncf.d2d.messenger.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Serializé les objets en java

public class Client {

    public Client(String[] args) {}

    public void handleClientMode(String[] args) {

        InetAddress host;
        int port;
        String username;

        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {

                case "-h":

                    try {
                       host = InetAddress.getByName(args[i +1]);
                    }
                    catch(UnknownHostException unknownHostException){

                        System.out.println( String.format("Adresse Ip invalide : %s", unknownHostException.getMessage()));
                        return;
                    }

                    System.out.println(host);
                    break;

                case "-p":
                    port = Integer.parseInt(args[i + 1]);
                    if(port>65536||port<0){
                        System.out.println("Entrer un port valide compris entre 0 et 65535");
                        return;
                    }
                    System.out.println(port);
                    break;

                case "-u":
                    username = args[i + 1];
                    System.out.println(username);
                    break;

                default:
                    break;
            }

        }

    }

/*    public void run() {
        try(Socket socket = new Socket(host, port)) {
            System.out.println("Connecté au serveur sur le port " + port);

            //Code de communication avec le serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }
    }*/

}
