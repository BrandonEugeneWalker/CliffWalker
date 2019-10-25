package edu.westga.cs3270.model.game;

/**
 * This class stores a position in the game board in a x,y coordinate plane.
 * A implementation of Position class written by Mengxiao Lin aka linmx0130 on
 * GitHub.
 * @author Mengxiao Lin, adapted by Brandon Walker.
 *
 */
public class Position {

	private int xPos;
	private int yPos;

	/**
	 * Creates a new instance of a Position object.
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate.
	 */
	public Position(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}

	/**
	 * Checks if the two Positions are equal.
	 * 
	 * @precondition none
	 * @param object the object to compare with
	 * @return true if equal, false if not
	 */
	@Override
	public boolean equals(Object object) {
		boolean isEquals = false;
		if (this == object) {
			isEquals = true;
		} else if (this.getClass() == object.getClass()) {
			Position positionToCompare = (Position) object;
			boolean xIsSame = this.xPos == positionToCompare.xPos;
			boolean yIsSame = this.yPos == positionToCompare.yPos;
			isEquals = xIsSame && yIsSame;
		}
		return isEquals;
	}
	
	/**
	 * Returns the hash code value of the object.
	 */
    @Override
    public int hashCode() {
        int result = this.xPos;
        result = 31 * result + this.yPos;
        return result;
    }

	/**
	 * Gets and returns the x position.
	 * 
	 * @return the x position.
	 */
	public int getxPos() {
		return this.xPos;
	}

	/**
	 * Sets the x position.
	 * 
	 * @precondition none
	 * @param xPos the new x position
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * Gets and returns the y position.
	 * 
	 * @return the y position.
	 */
	public int getyPos() {
		return this.yPos;
	}

	/**
	 * Sets the y position.
	 * 
	 * @precondition none
	 * @param yPos the new y position
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * Clones the Position.
	 * 
	 * @precondition none
	 * @return the cloned position
	 */
	@Override
	public Position clone() {
		return new Position(this.xPos, this.yPos);
	}

	/**
	 * Creates and returns a string representation of a Position. (x, y).
	 * 
	 * @precondition none
	 * @return a string representation of a Position.
	 */
	@Override
	public String toString() {
		return "(" + this.xPos + ", " + this.yPos + ")";
	}
}
