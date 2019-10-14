package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public class Food extends Entity implements Tickable,Renderable {

	public Food(Display display,int x,int y) {
		super(display,x,y);
	}
	
	public void tick() {
		int direction=(int)(Math.random()*4);
		
		if(direction==0 && y>0) {
			y-=display.getResolution();
		}else if(direction==1 && y+display.getResolution()<display.getHeight()) {
			y+=display.getResolution();
		}else if(direction==2 && x>0) {
			x-=display.getResolution();
		}else if(direction==3 && x+display.getResolution()<display.getWidth()) {
			x+=display.getResolution();
		}
	}

	public void render(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillRect(x,y,display.getResolution(),display.getResolution());
	}

}
