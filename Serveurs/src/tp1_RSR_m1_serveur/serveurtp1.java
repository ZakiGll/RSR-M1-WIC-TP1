package tp1_RSR_m1_serveur;

import java.net.*;
import java.io.*;


public class serveurtp1 {
	
	public static void main(String argv[]) {
		int port = 1225;

		try {

		//I obligatoire?

		//serveur positionne sa socket d'écoute

		ServerSocket ss = new ServerSocket(port);

		// se met en attente de connexion de la part d'un client

		System.out.println("Serveur en attente: ");

		Socket soc = ss.accept();

		//I crée un flux de données en sortie

		PrintWriter ostream = new PrintWriter (soc.getOutputStream ());


		

		InputStreamReader reader = new InputStreamReader(soc.getInputStream());

		BufferedReader istream = new BufferedReader(reader);

		// Bloque jusqu'à l'arrivée de données

		String ch1 = istream.readLine();
		String ch2 = istream.readLine();

		System.out.println("Les chaines recues sont : "+ch1+" et "+ch2);
		
		if(ch1.contains(ch2)) {
			ostream.println(ch1+" contient "+ch2);
			ostream.flush ();
		}
		else {
			ostream.println(ch1+" ne contient pas "+ch2);
			ostream.flush ();
		}
		
		

		// affiche les coordonnées du client qui vient de se connecter

		System.out.println(" adresse client:"+soc.getRemoteSocketAddress() );


		}catch(Exception e) {

		System.err.println("Erreur:"+e);
	}
}
}

