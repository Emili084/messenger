//package fr.sncf.d2d.messenger;
//
//import fr.sncf.d2d.messenger.client.Client;
//import fr.sncf.d2d.messenger.server.Server;
//import fr.sncf.d2d.messenger.server.ServerSocketHandler;
//
//import java.net.InetAddress;
//
//public class Messenger {
//
//    private static InetAddress host;
//    private static InetAddress address;
//    private static int portClient;
//    private static int portServer;
//    private static String username;
//    private static String banner;
//
//    public static void main(String[] args) {
//
//        if (args.length < 1) {
//            System.out.println("Veuillez spécifier le mode client (-c) ou le mode serveur (-l)");
//            return;
//        }
//
//        boolean hasModeFlag = false;
//
//        for (int i = 0; i < args.length; i++) {
//
//            switch (args[i]) {
//
//                case "-c":
//
//                    Client client = new Client(args, host, portClient, username);
//
//                    client.handleClientMode(args);
//                    host = client.getHost();
//                    portClient = client.getPort();
//                    username = client.getUsername();
//                    System.out.println(host);
//                    System.out.println(portClient);
//                    System.out.println(username);
//                    hasModeFlag = true;
//                    break;
//
//                case "-l":
//                    Server server = new Server(args, address, portServer, banner);
//                    server.handleServerMode(args);
//                    address = server.getAddress();
//                    portServer = server.getPort();
//                    banner = server.getBanner();
//                    System.out.println(address);
//                    System.out.println(portServer);
//                    System.out.println(banner);
//                    ServerSocketHandler serverSocketHandler = new ServerSocketHandler(address, portServer);
//                    serverSocketHandler.receiveObject();
//                    serverSocketHandler.sendObject(obj);
//                    hasModeFlag = true;
//                    break;
//                default:
//                    break;
//            }
//
//        }
//
//        if (!hasModeFlag) {
//            System.out.println("Veuillez spécifier le mode client (-c) ou le mode serveur (-l)");
//        }
//    }
//
//
//}
