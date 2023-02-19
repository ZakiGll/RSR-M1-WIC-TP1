package tp1_RSR_m1_qst2;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class clientTp1Qst2 {
	public static void main(String argv[]) {
		int port = 1226;
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
		    
		    DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
			ostream.writeUTF(ch1);
			ostream.writeUTF(ch2);
			ostream.flush();
		    
			DataInputStream reader = new DataInputStream(socket.getInputStream());
			String line = reader.readUTF();
			System.out.println("message recu du serveur est: "+line);
			
			
			
			
		}
		catch (Exception e) {
			System.err.println("Erreur :"+e);
		}
	}
}
