package tp1_RSR_m1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class clienttp1 {
	public static void main(String argv[]) {
		int port = 1225;
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
		    
		    PrintWriter ostream = new PrintWriter(socket.getOutputStream());
			ostream.println(ch1);
			ostream.println(ch2);
			ostream.flush();
		    
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			BufferedReader istream = new BufferedReader(reader);
			String line = istream.readLine();
			System.out.println("message recu du serveur est: "+line);
			
			
			
			
		}
		catch (Exception e) {
			System.err.println("Erreur :"+e);
		}
	}
}
