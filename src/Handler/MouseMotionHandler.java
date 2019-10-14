package Handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {
	
	private int x;
	
	private int y;
	
	public MouseMotionHandler() {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x=e.getX();
		y=e.getY();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
