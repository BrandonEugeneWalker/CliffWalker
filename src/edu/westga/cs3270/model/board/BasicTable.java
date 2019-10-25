package edu.westga.cs3270.model.board;

import java.util.HashMap;

import edu.westga.cs3270.model.game.QPoint;
import edu.westga.cs3270.model.game.QState;

public class BasicTable implements QTable {

	private HashMap<QPoint, QState> gameTiles;
	private int xSize;
	private int ySize;
	private QState currentPosition;
	private QPoint currentPoint;

	public BasicTable(int xSize, int ySize) {
		if (xSize < 0 || ySize < 0) {
			throw new IllegalArgumentException("The size of the board cannot be negative.");
		}
		this.xSize = xSize;
		this.ySize = ySize;
		this.gameTiles = new HashMap<QPoint, QState>();
		this.currentPoint = new QPoint(0, 0);
		this.initializeBoard();
	}

	@Override
	public int getLengthX() {
		return this.xSize;
	}

	@Override
	public int getWidthY() {
		return this.ySize;
	}

	@Override
	public QState getUpPosition() {
		int currentY = this.currentPoint.getY();
		int currentX = this.currentPoint.getX();
		QState returnState = null;
		if (currentY > this.ySize) {
			returnState = null;
		} else {
			currentY++;
			QPoint upPoint = new QPoint(currentX, currentY);
			returnState = this.gameTiles.get(upPoint);
		}
		return returnState;
	}

	@Override
	public QState getDownPosition() {
		int currentY = this.currentPoint.getY();
		int currentX = this.currentPoint.getX();
		QState returnState = null;
		if (currentY <= 0) {
			returnState = null;
		} else {
			currentY--;
			QPoint downPoint = new QPoint(currentX, currentY);
			returnState = this.gameTiles.get(downPoint);
		}
		return returnState;
	}

	@Override
	public QState getLeftPosition() {
		int currentY = this.currentPoint.getY();
		int currentX = this.currentPoint.getX();
		QState returnState = null;
		if (currentX <= 0) {
			returnState = null;
		} else {
			currentX--;
			QPoint leftPoint = new QPoint(currentX, currentY);
			returnState = this.gameTiles.get(leftPoint);
		}
		return returnState;

	}

	@Override
	public QState getRightPosition() {
		int currentY = this.currentPoint.getY();
		int currentX = this.currentPoint.getX();
		QState returnState = null;
		if (currentX >= this.xSize) {
			returnState = null;
		} else {
			currentX++;
			QPoint rightPoint = new QPoint(currentX, currentY);
			returnState = this.gameTiles.get(rightPoint);
		}
		return returnState;
	}

	@Override
	public QState getCurrentPosition() {
		return this.currentPosition;
	}

	@Override
	public String convertBoardBaluesToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveUp() {
		int currentY = this.currentPoint.getY();
		if (currentY < this.ySize) {
			this.currentPoint.incrementY();
			this.currentPosition = this.gameTiles.get(this.currentPoint);
		}
	}

	@Override
	public void moveDown() {
		int currentY = this.currentPoint.getY();
		if (currentY > 0) {
			this.currentPoint.decrementY();
			this.currentPosition = this.gameTiles.get(this.currentPoint);
		}
	}

	@Override
	public void moveLeft() {
		int currentX = this.currentPoint.getX();
		if (currentX > 0) {
			this.currentPoint.decrementX();
			this.currentPosition = this.gameTiles.get(currentPoint);
		}
	}

	@Override
	public void moveRight() {
		int currentX = this.currentPoint.getX();
		if (currentX < this.xSize) {
			this.currentPoint.incrementX();
			this.currentPosition = this.gameTiles.get(currentPoint);
		}
	}

	private void initializeBoard() {
		for (int x = 0; x <= this.xSize; x++) {
			for (int y = 0; x <= this.ySize; y++) {
				QState boardPosition = this.initializePosition(x, y);
				QPoint boardPoint = new QPoint(x, y);
				this.gameTiles.put(boardPoint, boardPosition);
			}
		}
	}

	private QState initializePosition(int x, int y) {
		int rewardValue = -1;
		if (x > 0 && x < this.xSize && y == 0) {
			rewardValue = -100;
		} else if (x == this.xSize && y == this.ySize) {
			rewardValue = 0;
		}
		return new QState(rewardValue);
	}

}
