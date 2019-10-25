package edu.westga.cs3270.model.board;

import edu.westga.cs3270.model.game.Position;

public interface GameBoard {
	
	
	int getLength();
	
	int getWidth();
	
	Position getUpPosition(Position strtingPosition);
	
	Position getDownPosition(Position startingPosition);
	
	Position getLeftPosition(Position startingPositon);
	
	Position getRightPosition(Position startingPosition);
	
	Position getCurrentPosition();
	
	String convertBoardBaluesToString();
	
}
