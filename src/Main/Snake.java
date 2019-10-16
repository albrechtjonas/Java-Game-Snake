package Main;

import java.awt.Toolkit;

public class Snake {
	
	private final String title="Snake";
	
	private int width;
	
	private int height;
	
	public Window window;
	
	private Display display;
	
	public static void main(String[]args) {
		new Snake();
	}
	
	private Snake() {
		getDimension();
		
		window=new Window(title,width,height);
		display=new Display(window);
		display.start();
	}
	
	private void getDimension() {
		Toolkit toolKit=Toolkit.getDefaultToolkit();
		
		width=(int)toolKit.getScreenSize().getWidth();
		
		height=(int)toolKit.getScreenSize().getHeight();
	}
}
