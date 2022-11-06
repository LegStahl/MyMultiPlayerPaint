package networkuser;


import java.io.PrintWriter;
import java.net.Socket;

public class Sender {
	
	private PrintWriter writer;
	
	public Sender(Socket userSocket)  {
		try {
		writer = new PrintWriter(userSocket.getOutputStream(), true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void sendMessage(String message) {
		writer.println(message);
		System.out.println("Sender: 21");
	}
	
	

}
