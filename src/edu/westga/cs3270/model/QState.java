package edu.westga.cs3270.model;

/**
 * This class represents a state in the QTable.
 * @author Brandon Walker
 *
 */
public class QState {
	private int stateReward;
	private double up;
	private double down;
	private double left;
	private double right;

	/**
	 * Creates a new instance of a QState object.
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate.
	 */
	public QState(int reward) {
		this.stateReward = reward;
		this.up = 0;
		this.down = 0;
		this.left = 0;
		this.right = 0;
	}
	
	/**
	 * @return the up
	 */
	public double getUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(double up) {
		this.up = up;
	}

	/**
	 * @return the down
	 */
	public double getDown() {
		return down;
	}

	/**
	 * @param down the down to set
	 */
	public void setDown(double down) {
		this.down = down;
	}

	/**
	 * @return the left
	 */
	public double getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(double left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public double getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(double right) {
		this.right = right;
	}

	/**
	 * @return the positionReward
	 */
	public int getStateReward() {
		return stateReward;
	}
}
