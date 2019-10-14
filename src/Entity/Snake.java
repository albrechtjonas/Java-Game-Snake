package Entity;

import java.awt.Graphics2D;
import java.util.LinkedList;

import Interface.Renderable;
import Interface.Tickable;
import Main.Display;
import State.State;

public class Snake extends Entity implements Tickable,Renderable {
	
	private LinkedList<Node> body=new LinkedList<Node>();
	
	private Node head;
	
	private Node tail;
	
	private Direction direction;
	
	public Snake(Display display,int x,int y) {
		super(display,x,y);
		
		createBody();
	}
	
	private void createBody() {
		for(int i=y;i<6+y;i++) {
			body.add(new Node(display,x*display.getResolution(),i*display.getResolution()));
		}
	}
	
	private int index=0;
	
	public void tick() {
		update();
		
		control();
		
		if(index%display.getRunState().getRate()==0) {
			index=0;
			move();
		}
		
		collision();
		
		index++;
		
	}
	
	public void render(Graphics2D g) {
		for(int i=0;i<body.size();i++) {
			body.get(i).render(g);
		}
	}
	
	private void update() {
		head=body.getFirst();
		tail=body.getLast();
	}
	
	private void control() {
		if(display.getKeyActionHandler().getUp() && direction!=Direction.down) {
			direction=Direction.up;
		}else if(display.getKeyActionHandler().getDown() && direction!=Direction.up && direction!=null) {
			direction=Direction.down;
		}else if(display.getKeyActionHandler().getLeft() && direction!=Direction.right) {
			direction=Direction.left;
		}else if(display.getKeyActionHandler().getRight() && direction!=Direction.left) {
			direction=Direction.right;
		}
	}
	
	private void move() {
		if(direction==Direction.up) {
			body.addFirst(new Node(display,head.getX(),head.getY()-display.getResolution()));
			body.remove(tail);
		}else if(direction==Direction.down) {
			body.addFirst(new Node(display,head.getX(),head.getY()+display.getResolution()));
			body.remove(tail);
		}else if(direction==Direction.left) {
			body.addFirst(new Node(display,head.getX()-display.getResolution(),head.getY()));
			body.remove(tail);
		}else if(direction==Direction.right) {
			body.addFirst(new Node(display,head.getX()+display.getResolution(),head.getY()));
			body.remove(tail);
		}
	}
	
	private void collision() {
		for(int x=0;x<body.size();x++) {
			int xPosition=body.get(x).getX();
			int yPosition=body.get(x).getY();
			
			for(int y=x+1;y<body.size();y++) {
				if(xPosition==body.get(y).getX() && yPosition==body.get(y).getY()) {
					display.resetEndState();
					State.setState(display.getEndState());
				}
			}
		}
		
		if(head.getX()<0 || head.getX()+display.getResolution()>display.getWidth()) {
			display.resetEndState();
			State.setState(display.getEndState());
		}
		
		if(head.getY()<0 || head.getY()+display.getResolution()>display.getHeight()) {
			display.resetEndState();
			State.setState(display.getEndState());
		}

		Food food=display.getRunState().getFood();
		
		if(food!=null && food.getX()==head.getX() && food.getY()==head.getY()) {
			display.getRunState().setFood(null);
			
			if(direction==Direction.up) {
				body.addFirst(new Node(display,head.getX(),head.getY()-display.getResolution()));
			}else if(direction==Direction.down) {
				body.addFirst(new Node(display,head.getX(),head.getY()+display.getResolution()));
			}else if(direction==Direction.left) {
				body.addFirst(new Node(display,head.getX()-display.getResolution(),head.getY()));
			}else if(direction==Direction.right) {
				body.addFirst(new Node(display,head.getX()+display.getResolution(),head.getY()));
			}
		}	
	}
	
	public LinkedList<Node> getBody() {
		return body;
	}
	
	
}

enum Direction {
	up,down,left,right
}
