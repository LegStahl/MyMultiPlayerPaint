package modeluser;


import view.Display;

public class Painter extends Thread{
	
	private static int[][] boardForPaint = new int[Display.HIGHT][Display.WIDTH];
	
	public static final float COUNT_UPDATE = 60.0f;
	
	public static final float UPDATE_INTERVAL = 1000000000 / COUNT_UPDATE;
	
	public static final long SLEEP_TIME = 1000; 
	
	public static final long	IDLE_TIME		= 1;
	
	public static final long	SECOND	= 1000000000l;
	
	private Display display;

	
	public Painter(Display display) {
		super();
		this.display = display;

	}
	
	public static int getColumn() {
		return boardForPaint.length;
	}
	
	public static int getRows() {
		return boardForPaint[0].length;
	}

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

	public void run() {
	

		

		float delta = 0;
		


		long lastTime = System.nanoTime();
		while (true) {
	
				long now = System.nanoTime();
				long elapsedTime = now - lastTime;
				lastTime = now;

			
		
	
				boolean render = false;
		
					
					delta += (elapsedTime / UPDATE_INTERVAL);
					while (delta > 1) {
						delta--;
						if (!render) {
							render = true;
						}
					}
					if (render) {
						if(true)
							display.render();
						
					} else {
						try {
							Thread.sleep(IDLE_TIME);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			
		}
		
	}
}
