# Messenger

Ce projet est un système de messagerie permettant de fonctionner en mode client ou serveur.

# Utilisation
## Client

Pour utiliser le mode client, exécutez la commande suivante :   
Messenger -c -h <host> -p <port> -u <username>
### Exemple
Messenger -c -h 192.168.1.200 -p 8000 -u Emilio

## Serveur

Pour utiliser le mode serveur, exécutez la commande suivante :  
Messenger -l -a <address> -p <port> -b <banner>
### Exemple
Messenger -l -a 192.168.1.200 -p 8000 -b banniere
