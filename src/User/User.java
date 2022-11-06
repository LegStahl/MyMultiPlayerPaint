package User;

import java.net.InetAddress;
import java.net.Socket;

import modeluser.Painter;
import networkuser.Receiver;
import networkuser.Sender;
import view.Display;

public class User {
	public static boolean INPAINT = true;
	
	public static void main(String[] argv) {
		try {
			InetAddress ipServer = InetAddress.getByName(argv[0]);
			int portServer = Integer.parseInt(argv[1]);
			Socket userSocket = new Socket(ipServer, portServer);
			Sender sender = new Sender(userSocket);
			Receiver receiver = new Receiver(userSocket);
			receiver.start();
			Thread.sleep(1500);
			Display display = new Display(sender);
			Painter painter = new Painter(display);
			painter.start();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

