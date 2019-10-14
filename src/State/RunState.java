package State;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Food;
import Entity.Snake;
import Main.Display;

public class RunState extends State {
	
	private int rate=6;
	
	private Snake snake;
	
	private Food food;
	
	private int foodTick;
	
	private int foodDelta=80;
	
	public RunState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		int centerX=display.getWidth()/display.getResolution()/2;
		int centerY=display.getHeight()/display.getResolution()/2-3;
		
		snake=new Snake(display,centerX,centerY);
	}
	
	public void tick() {
		
		pauseTick();
		
		snake.tick();
		
		if(food!=null) {
			
			if(foodTick%foodDelta==0 && foodTick!=0) {
				food.tick();
				foodTick=0;
			}
			foodTick++;
		}
		
		foodTick();
	}
	
	public void render(Graphics2D g) {
		
		snake.render(g);
		
		if(food!=null) {
			food.render(g);
		}
		
		int resolution=display.getResolution();
		for(int x=0;x<display.getWidth()/resolution;x++) {
			for(int y=0;y<display.getHeight()/resolution;y++) {
				g.setColor(Color.DARK_GRAY);
				g.drawRect(x*resolution,y*resolution,resolution,resolution);
			}
		}
	}
	
	private void pauseTick() {
		if(display.getKeyActionHandler().getPause()) {
			State.setState(display.getPauseState());
		}
	}
	
	private void foodTick() {
		if(food==null) {
			int x=(int)(Math.random()*(display.getWidth()/display.getResolution()));
			int y=(int)(Math.random()*(display.getHeight()/display.getResolution()));
			
			food=new Food(display,x*display.getResolution(),y*display.getResolution());
		}
	}
	
	public void setRate(int rate) {
		this.rate=rate;
	}
	
	public int getRate() {
		return rate;
	}
	
	public Snake getSnake() {
		return snake;
	}
	
	public void setFood(Food food) {
		this.food=food;
	}
	
	public Food getFood() {
		return food;
	}
}
