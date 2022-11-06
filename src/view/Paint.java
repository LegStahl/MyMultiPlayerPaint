package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

import modeluser.Painter;
import networkuser.Sender;



public class Paint extends JComponent {
	
	private MyListener listen;
	
	private Display display;
	
	private Sender sender;

	
	public Paint(Display display, Sender sender) {
		listen = new MyListener();
		this.display = display;
		this.display.addMouseListener(listen);
		this.display.addMouseMotionListener(listen);
		this.sender = sender;
	}
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, display.WIDTH, display.HIGHT);
		for(int i = 0; i < Painter.getColumn(); i++) {
			for(int j = 0; j < Painter.getRows() - 1; j++) {
			
			 if(Painter.getCoord(i, j) == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(j, i, 2, 2);
				}
			}
		}
	
	
		
	}
	
	class MyListener implements MouseInputListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
		
			int x = e.getX() - 10;
			int y = e.getY() - 32;
			Painter.setCoord(y, x);
			sender.sendMessage(y + " " + x);
			
			
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
