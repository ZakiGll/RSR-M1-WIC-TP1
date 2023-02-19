package tp1_RSR_m1_qst5;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2_Qst5 {
	public static void main(String argv[]) {
		int port = 1230;
		String host = "localhost";
		try {
			InetAddress adr = InetAddress.getByName(host);
			Socket socket = new Socket(adr,port);
			
			System.out.println("mon adress client: "+socket.getLocalAddress()+": "+socket.getLocalPort());
			System.out.println("mon serveur est: "+socket.getInetAddress()+": "+socket.getPort());
			
			Scanner scanner = new Scanner(System.in);
		    System.out.print("Entrez la 1er chaine : ");
		    String ch1 = scanner.nextLine();
		    System.out.print("Entrez la 2eme chaine : ");
		    String ch2 = scanner.nextLine();
		    
		    System.out.println("Les chaines envoyées :");
		    System.out.println("1- "+ch1);
		    System.out.println("2- "+ch2);
		    
		    ObjectOutputStream ostream = new ObjectOutputStream(socket.getOutputStream());
			ostream.writeObject(ch1);
			ostream.writeObject(ch2);
			ostream.flush();
		    
			ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
			String line = (String) reader.readObject();
			int nbrClients = (int) reader.readObject();
			System.out.println("message recu du serveur est: "+line);
			System.out.println("Le nembre des clients connectés :"+nbrClients);
			
			
			
			
			
		}
		catch (Exception e) {
			System.err.println("Erreur :"+e);
		}
	}
}
