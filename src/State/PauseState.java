package State;

import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.Button;
import Entity.Label.Label;
import Enum.Action;
import Main.Display;

public class PauseState extends State {
	
	private Label pause;
	
	private Button restart;
	
	private Button menu;
	
	private Button back;
	
	public PauseState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		pause=new Label(display,0,0,display.getWidth(),200,"Pause",new Font("TimesRoman",Font.ITALIC,150));
		
		restart=new Button(display,0,300,display.getWidth(),100,"Restart",new Font("TimesRoman",Font.ITALIC,75),Action.restart);
		
		menu=new Button(display,0,500,display.getWidth(),100,"Menu",new Font("TimesRoman",Font.ITALIC,75),Action.start);
		
		back=new Button(display,0,700,display.getWidth(),100,"Back",new Font("TimesRoman",Font.ITALIC,75),Action.run);
	}
	
	public void tick() {
		if(tickDelta<=0) {
			restart.tick();
			menu.tick();
			back.tick();
		}
		tickDelta-=0.1;
	}
	
	public void render(Graphics2D g) {
		pause.render(g);
		restart.render(g);
		menu.render(g);
		back.render(g);
	}
}
