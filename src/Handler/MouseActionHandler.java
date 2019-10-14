package Handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionHandler implements MouseListener {
	
	private boolean pressed;
	
	public MouseActionHandler() {
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		pressed=true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pressed=false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getPressed() {
		return pressed;
	}
}
