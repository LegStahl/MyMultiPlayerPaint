package networkuser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import modeluser.Painter;

public class Receiver extends Thread {
	
	private Socket userSocket;
	
	private BufferedReader reader;
	
	public Receiver(Socket userSocket) {
		
		this.userSocket = userSocket;
		
	}
	
	public void run() {
		try {
			String message;
			
			reader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
			System.out.println("Receiver: 27");
		
		
		
		
			while(true) {
				while((message = reader.readLine()) != null) {
					Scanner scanner = new Scanner(message);
					int y = scanner.nextInt();
					int x = scanner.nextInt();
					Painter.setCoord(y, x);
					System.out.println("Receiver: 46");
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
