package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;




public class HelpServer extends Thread {
	
	private Socket socket;
	
   	private PrintWriter out;
    
    private BufferedReader in;
	
	public HelpServer( Socket socket ) {
		
		super();
	
		this.socket = socket;
		
        try {
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
        }
        catch (IOException e){
            e.getMessage();
        }
	}
	
	public void sendMass(){
		
		for( int i = 0; i < Server.getColumn(); i++){
			
			for( int j = 0; j < Server.getRows(); j++){
				
				if(Server.getCoord(i, j) == 1) {
					
					out.println(i + " " + j);
					
				}
			
			} 
			
		}
		
	}
	
	public void run() {
		
		String message;
		
		sendMass();
		
		try {
			while((message = in.readLine()) != null) {
				
				Scanner scanner = new Scanner(message);
				
				int y = scanner.nextInt();
				
				int x = scanner.nextInt();
				
				Server.setCoord(y, x);
				
				Server.sendAllUsers(y + " " + x );
				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void sendMessage(String message) {
		out.println(message);
	}
	
	
	
}