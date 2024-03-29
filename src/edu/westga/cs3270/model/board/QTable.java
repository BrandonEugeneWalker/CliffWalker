package edu.westga.cs3270.model.board;

import edu.westga.cs3270.model.Action;
import edu.westga.cs3270.model.QState;

public interface QTable {
	
	
	int getLengthX();
	
	int getWidthY();
	
	QState getUpPosition();
	
	QState getDownPosition();
	
	QState getLeftPosition();
	
	QState getRightPosition();
	
	QState getCurrentPosition();
	
	String convertBoardBaluesToString();
	
	void moveUp();
	
	void moveDown();
	
	void moveLeft();
	
	void moveRight();
	
	boolean isOffCliff();
	
	boolean isAtGoalState();
	
	int getActionRewardValue(Action action);
	
}
