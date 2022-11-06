package view;

import javax.swing.JFrame;

import networkuser.Sender;




public class Display extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 800;
	
	public static final int HIGHT = 600;
	
	private Paint paint;
	
	public Display(Sender sender) {
		
		super();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		setResizable(false);
		paint = new Paint(this, sender);
		
		getContentPane().add(paint);
	

		pack();
		setSize(WIDTH, HIGHT);
		setLocationRelativeTo(null);
		System.out.println("Hello World");
		setVisible(true);
		
	}
	
	public void render() {
		paint.repaint();
	}

}
