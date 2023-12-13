package fr.sncf.d2d.messenger.cli;

//import fr.sncf.d2d.messenger.client.Client;
import fr.sncf.d2d.messenger.server.Server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

// les args peuvent être dans le désordre
// supp regex

public class Cli {
    public void argsTreatments(String[] args){
//Gestion erreur mode client ou serveur
        for(String arg:args){
            System.out.print(arg + " " );
        }
        System.out.println();
        if (args.length < 1) {
            System.out.println("Veuillez spécifier le mode client (-c) ou le mode serveur (-l)");
            return;
        }
//Gestion erreur format commande
        if (args[0].equals("-c")) {
            if (args.length < 7) {
                System.out.println("Format de la commande : Messenger -c -h <host> -p <port> -u <username>");
                return;
            }
            String host = null;
            int port = 19337;
            String username = "anonymous";
            for (int i = 1; i < args.length; i++) {
                //Gestion erreur de l'adresse IP
                if (args[i].equals("-h")) {
                    System.out.println(args[i+1]);
                    String regex = "\\b((25[0–5]|2[0–4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0–5]|2[0–4]\\d|[01]?\\d\\d?)\\b";
                    if (Pattern.matches(regex,args[i+1])) {
                        host = args[i + 1];
                    } else {
                        System.out.println("Entrer une adresse Ip valide comprise entre 1.1.1.1 à 255.255.255.255");
                        return;
                    }
                   //Gestion erreur du port
                } else if (args[i].equals("-p")) {
                    port = Integer.parseInt(args[i + 1]);
                    if(port>65536||port<0){
                        System.out.println("Entrer un port valide compris entre 0 et 65535");
                        return;
                    }
                } else if (args[i].equals("-u")) {
                    System.out.println(args[i+1]);
                        username = args[i + 1];
                }
            }

            System.out.println("Mode client activé. Connexion à " + host + " sur le port " + port + " avec l'utilisateur " + username);
            // Code pour le mode client
          //  Client client = new Client(host, port, username);
           // client.start();

        } else if (args[0].equals("-l")) {
            System.out.println(args.length);
            if (args.length < 7) {
                System.out.println("Usage : Messenger -l -a <addr> -p <port> -b <banner>");
                return;
            }
            String addr = null;
            int port = 19337;
            String banner = "Bienvenue sur Messenger";
            for (int i = 1; i < args.length; i++) {
                //Gestion erreur de l'adresse IP
                if (args[i].equals("-a")) {
                    System.out.println(args[i+1]);
                    InetAddress address;
                    try {
                        address = InetAddress.getByName(args[i +1]);
                    }
                    catch(UnknownHostException unknownHostException){

                        System.out.println( String.format("Adresse Ip invalide : %s", unknownHostException.getMessage()));
                        return;
                    }
                    System.out.println(address);

                    //Gestion erreur du port
                } else if (args[i].equals("-p")) {
                    System.out.println(args[i+1]);
                    port = Integer.parseInt(args[i + 1]);
                    if(port>65536||port<0){
                        System.out.println("Entrer un port valide compris entre 0 et 65535");
                        return;
                    }
                } else if (args[i].equals("-b")) {
                    System.out.println(args[i+1]);
                    banner = args[i + 1];
                }
            }

            System.out.println("Mode serveur activé. Adresse d'écoute : " + addr + ", port : " + port + ", bannière : " + banner);
            // Code pour le mode serveur
           // Server server = new Server(addr, port, banner);
        } else {
            System.out.println("Veuillez spécifier le mode client (-c) ou le mode serveur (-l)");
        }

    }
}
