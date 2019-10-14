package Main;

public class Snake {
	
	private final String title="Snake";
	
	private final int width=820;
	
	private final int height=820;
	
	public Window window;
	
	private Display display;
	
	public static void main(String[]args) {
		new Snake();
	}
	
	private Snake() {
		window=new Window(title,width,height);
		display=new Display(window);
		display.start();
	}
}
