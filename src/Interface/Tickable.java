package Interface;

import java.awt.Rectangle;

import Enum.Action;
import Main.Display;
import State.State;

public interface Tickable {
	public abstract void tick();
	
	public default void update(Display display,Rectangle rectangle,Action status) {
		
		int mouseX=display.getMouseMotionHandler().getX();
		
		int mouseY=display.getMouseMotionHandler().getY();
		
		if(display.getMouseActionHandler().getPressed()) {
			if(mouseX>rectangle.x && mouseX<rectangle.x+rectangle.width) {
				if(mouseY>rectangle.y && mouseY<rectangle.y+rectangle.height) {
					display.resetTickDelta();
					if(status==Action.start) {
						display.resetRunState();
						State.setState(display.getStartState());
					}else if(status==Action.help) {
						State.setState(display.getHelpState());
					}else if(status==Action.about) {
						State.setState(display.getAboutState());
					}else if(status==Action.run) {
						State.setState(display.getRunState());
					}else if(status==Action.end) {
						State.setState(display.getEndState());
					}else if(status==Action.restart) {
						display.resetRunState();
						State.setState(display.getRunState());
					}
				}
			}
		}
	}
}
