package fr.sncf.d2d.messenger;

import fr.sncf.d2d.messenger.client.Client;
import fr.sncf.d2d.messenger.server.Server;

import java.net.InetAddress;

public class Messenger {

    private static InetAddress host;
    private String address;
    private static int portClient;
    private int portServer;
    private static String username;
    private String banner;

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Veuillez spécifier le mode client (-c) ou le mode serveur (-l)");
            return;
        }

        boolean hasModeFlag = false;

        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {

                case "-c":

                    Client client = new Client(args, host, portClient, username);

                    client.handleClientMode(args);
                    host = client.getHost();
                    portClient = client.getPort();
                    username = client.getUsername();
                    System.out.println(host);
                    System.out.println(portClient);
                    System.out.println(username);
                    hasModeFlag = true;
                    break;

                case "-l":
                    Server server = new Server(args);
                    server.handleServerMode(args);
                    hasModeFlag = true;
                    break;
                default:
                    break;
            }

        }

        if (!hasModeFlag) {
            System.out.println("Veuillez spécifier le mode client (-c) ou le mode serveur (-l)");
        }
    }


}
