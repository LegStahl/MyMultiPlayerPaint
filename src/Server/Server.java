package Server;

import java.io.BufferedReader;
//import Server.HelpServer;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modeluser.Painter;

public class Server {
	
	public static List <HelpServer> listOfUsers;
	
	private static int[][] boardForPaint = new int[600][800];

	public static void setCoord(int y, int x) {
		if((x >= 0 && x <= boardForPaint[0].length) && (y >= 0 && y <= boardForPaint.length) ) {
			boardForPaint[y][x] = 1;
		}
	}
	
	public static int getCoord(int y, int x) {
		if((x >= 0 && x < boardForPaint[0].length) && (y >= 0 && y < boardForPaint.length) ) {
			return boardForPaint[y][x] ;
		}
		return -1;
	}
	
	public static int getColumn() {
		return boardForPaint.length;
	}
	
	public static int getRows() {
		return boardForPaint[0].length;
	}
	
	
	public static void main(String[] argv) {
		
		
		try {
		int portNumber = Integer.parseInt(argv[0]);
		
		listOfUsers = new ArrayList<>();
		
		
			//BufferedReader nameReader;
			ServerSocket serverSocket= new ServerSocket(portNumber);
	

			while(true) {
			
				Socket clientSocket = serverSocket.accept();
				
				System.out.println("Server:35");
				
				//nameReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				//String clientName = nameReader.readLine();
				
				HelpServer helpServer = new HelpServer(clientSocket);
				
				helpServer.start();
				
				System.out.println("Server:47");
				
				listOfUsers.add(helpServer);
				
			}
		
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


	
	public static void sendAllUsers(String message) {
		
		for ( HelpServer entry : listOfUsers) {
			
			entry.sendMessage(message);
			
			System.out.println("Server:78");
			
	    }
	}
	
	
	
}
