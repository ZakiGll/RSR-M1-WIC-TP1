package tp1_RSR_m1_serveur_qst5;

import java.io.*;
import java.net.*;


public class ServeurTcp extends Thread{
	
	private Socket socket;
	static int nbrClients=0;
	

	public static void main(String argv[]) {
		int port = 1230;
		try {
		
		ServerSocket serverSocket = new ServerSocket(port);

		while(true) {
			
		System.out.println("Serveur en attente: ");
		
		Socket socketClient = serverSocket.accept();
		
		ServeurTcp serveur= new ServeurTcp(socketClient);
		nbrClients++;
		serveur.start();
			}

		}catch(Exception e) {
			e.printStackTrace();
			}
		}
	
	public ServeurTcp(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			System.out.println("Le nombre des clients conectes: "+nbrClients);
			ObjectOutputStream ostream = new ObjectOutputStream (socket.getOutputStream ());

			ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());

			String ch1 = (String) reader.readObject();
			String ch2 = (String) reader.readObject();

			System.out.println("Les chaines recues sont : "+ch1+" et "+ch2);
			
			if(ch1.contains(ch2)) {
				ostream.writeObject(ch1+" contient "+ch2);
				ostream.writeObject(nbrClients);
				ostream.flush ();
				nbrClients--;
			}
			else {
				ostream.writeObject(ch1+" ne contient pas "+ch2);
				ostream.writeObject(nbrClients);
				ostream.flush ();
				nbrClients--;
			}
			
			System.out.println(" adresse client:"+socket.getRemoteSocketAddress() );
			
			
			
		}catch(Exception e) {

			System.err.println("Erreur:"+e);
	}}
	}

