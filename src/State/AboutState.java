package State;

import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.Button;
import Entity.Label.Label;
import Enum.Action;
import Main.Display;

public class AboutState extends State {
	
	private Label about;
	
	private Label version;
	
	private Label developer;
	
	private Label github;
	
	private Button back;
	
	public AboutState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		about=new Label(display,0,0,display.getWidth(),200,"About",new Font("TimesRoman",Font.ITALIC,150));
		
		version=new Label(display,0,250,display.getWidth(),100,"Version: Oct,10,2019",new Font("TimesRoman",Font.ITALIC,50));
		
		developer=new Label(display,0,400,display.getWidth(),100,"Developer: Dominic Jiang",new Font("TimesRoman",Font.ITALIC,50));
		
		github=new Label(display,0,550,display.getWidth(),100,"Github: Java-Game-Snake",new Font("TimesRoman",Font.ITALIC,50));
		
		back=new Button(display,0,700,display.getWidth(),100,"Back",new Font("TimesRoman",Font.ITALIC,75),Action.start);
	}
	
	public void tick() {
		if(tickDelta<=0) {
			back.tick();
		}
		tickDelta-=0.1;
	}
	
	public void render(Graphics2D g) {
		about.render(g);
		version.render(g);
		developer.render(g);
		github.render(g);
		back.render(g);
	}
}
