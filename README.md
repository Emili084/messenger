# Messenger

Ce projet est un système de messagerie permettant de fonctionner en mode client ou serveur.

# Utilisation
## Client
Pour utiliser le mode client, exécutez la commande suivante :   
Messenger -c -h &lt;host&gt; -p &lt;port&gt; -u &lt;username&gt;
### Exemple
Messenger -c -h 192.168.1.200 -p 8000 -u Emilio

## Serveur
Pour utiliser le mode serveur, exécutez la commande suivante :  
Messenger -l -a &lt;address&gt; -p &lt;port&gt; -b &lt;banner&gt;
### Exemple
Messenger -l -a 192.168.1.200 -p 8000 -b banniere

# Ou j'en suis 

## Logique d'utilisation 
Elle est dans Messenger, Client, Server

## Principe de fonctionnement Messenger avec écoute écriture lecture 
Elle est dans ServerSocketHandler, ClientSocketHandler, ClientTest
