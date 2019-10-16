package State;

import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.Button;
import Entity.Label.Label;
import Enum.Action;
import Main.Display;

public class EndState extends State {
	
	private Label gameOver;
	
	private Label score;
	
	private Button restart;
	
	private Button menu;

	public EndState(Display display) {
		super(display);
		
		createObject();
	}	
	
	private void createObject() {
		int start=(display.getHeight()-800)/4;
		
		gameOver=new Label(display,0,start,display.getWidth(),200,"Game Over",new Font("TimesRoman",Font.ITALIC,150));
		
		int length=display.getRunState().getSnake().getBody().size()-6;
		
		score=new Label(display,0,start+300,display.getWidth(),100,"Score "+length,new Font("TimesRoman",Font.ITALIC,75));
		
		restart=new Button(display,0,start+500,display.getWidth(),100,"Restart",new Font("TimesRoman",Font.ITALIC,75),Action.restart);
		
		menu=new Button(display,0,start+700,display.getWidth(),100,"Menu",new Font("TimesRoman",Font.ITALIC,75),Action.start);	
	}
	
	public void tick() {
		if(tickDelta<=0) {
			restart.tick();
			menu.tick();
		}
		tickDelta-=0.1;
	}

	public void render(Graphics2D g) {
		gameOver.render(g);
		score.render(g);
		restart.render(g);
		menu.render(g);
	}
}
