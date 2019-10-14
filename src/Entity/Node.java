package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Interface.Renderable;
import Main.Display;

public class Node extends Entity implements Renderable {
	public Node(Display display,int x,int y) {
		super(display,x,y);
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(x,y,display.getResolution(),display.getResolution());
	}
}
