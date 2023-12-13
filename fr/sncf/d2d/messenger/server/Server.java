package fr.sncf.d2d.messenger.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Server {
    public Server(String[] args) {
    }

    public void handleServerMode(String[] args) {

        InetAddress address = null;
        int port = 19337;
        String banner = "Bienvenue sur Messenger";

        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {

                case "-a":
                    try {
                        address = InetAddress.getByName(args[i +1]);
                    }
                    catch(UnknownHostException unknownHostException){

                        System.out.println( String.format("Adresse Ip invalide : %s", unknownHostException.getMessage()));
                        return;
                    }
                    System.out.println(address);
                    break;

                case "-p":
                    port = Integer.parseInt(args[i + 1]);
                    if(port>65536||port<0){
                        System.out.println("Entrer un port valide compris entre 0 et 65535");
                        return;
                    }
                    System.out.println(port);
                    break;

                case "-b":
                    banner = args[i + 1];
                    System.out.println(banner);
                    break;

                default:
                    break;
            }

        }


    }

}
