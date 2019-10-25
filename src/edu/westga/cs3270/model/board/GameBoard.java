package edu.westga.cs3270.model.board;

import edu.westga.cs3270.model.game.Position;

public interface GameBoard {
	
	int getLength();
	
	int getWidth();
	
	Position getUp(Position strtingPosition);
	
	Position getDown(Position startingPosition);
	
	Position getLeft(Position startingPositon);
	
	Position getRight(Position startingPosition);
	
	
	
	

}
