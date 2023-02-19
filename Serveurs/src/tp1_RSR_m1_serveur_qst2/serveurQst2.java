package tp1_RSR_m1_serveur_qst2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serveurQst2 {
	public static void main(String argv[]) {
		int port = 1226;

		try {

		//I obligatoire?

		//serveur positionne sa socket d'écoute

		ServerSocket ss = new ServerSocket(port);

		// se met en attente de connexion de la part d'un client

		System.out.println("Serveur en attente: ");

		Socket soc = ss.accept();

		//I crée un flux de données en sortie

		DataOutputStream ostream = new DataOutputStream (soc.getOutputStream ());


		

		DataInputStream reader = new DataInputStream(soc.getInputStream());


		// Bloque jusqu'à l'arrivée de données

		String ch1 = reader.readUTF();
		String ch2 = reader.readUTF();

		System.out.println("Les chaines recues sont : "+ch1+" et "+ch2);
		
		if(ch1.contains(ch2)) {
			ostream.writeUTF(ch1+" contient "+ch2);
			ostream.flush ();
		}
		else {
			ostream.writeUTF(ch1+" ne contient pas "+ch2);
			ostream.flush ();
		}
		
		

		// affiche les coordonnées du client qui vient de se connecter

		System.out.println(" adresse client:"+soc.getRemoteSocketAddress() );


		}catch(Exception e) {

		System.err.println("Erreur:"+e);
	}
}
}
