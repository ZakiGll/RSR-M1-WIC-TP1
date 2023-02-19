package tp1_RSR_m1_serveur_qst2_2;

import java.io.DataInputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serveurQst2_2 {
	public static void main(String argv[]) {
		int port = 1227;

		try {

		//I obligatoire?

		//serveur positionne sa socket d'écoute

		ServerSocket ss = new ServerSocket(port);

		// se met en attente de connexion de la part d'un client

		System.out.println("Serveur en attente: ");

		Socket soc = ss.accept();

		//I crée un flux de données en sortie

		ObjectOutputStream ostream = new ObjectOutputStream (soc.getOutputStream ());


		

		ObjectInputStream reader = new ObjectInputStream(soc.getInputStream());


		// Bloque jusqu'à l'arrivée de données

		String ch1 = (String) reader.readObject();
		String ch2 = (String) reader.readObject();

		System.out.println("Les chaines recues sont : "+ch1+" et "+ch2);
		
		if(ch1.contains(ch2)) {
			ostream.writeObject(ch1+" contient "+ch2);
			ostream.flush ();
		}
		else {
			ostream.writeObject(ch1+" ne contient pas "+ch2);
			ostream.flush ();
		}
		
		

		// affiche les coordonnées du client qui vient de se connecter

		System.out.println(" adresse client:"+soc.getRemoteSocketAddress() );


		}catch(Exception e) {

		System.err.println("Erreur:"+e);
	}
}
}
