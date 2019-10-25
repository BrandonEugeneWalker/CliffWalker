package edu.westga.cs3270.model.game;

public class QPoint {

	private int x;
	private int y;
	
	public QPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void incrementX() {
		this.x++;
	}
	
	public void incrementY() {
		this.y++;
	}
	
	public void decrementX() {
		this.x--;
	}
	
	public void decrementY() {
		this.y--;
	}
	
	@Override
	public boolean equals(Object otherPoint) {
		boolean xValueIsSame = this.x == ((QPoint) otherPoint).getX();
		boolean yValueIsSame = this.y == ((QPoint) otherPoint).getY();
		return xValueIsSame && yValueIsSame;
	}
}
