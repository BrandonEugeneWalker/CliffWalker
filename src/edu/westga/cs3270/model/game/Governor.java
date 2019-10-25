package edu.westga.cs3270.model.game;

/**
 * This class handles the state of the game and various actions based on that. A
 * implementation of Governor class written by Mengxiao Lin aka linmx0130 on
 * GitHub.
 * 
 * @author Mengxiao Lin, adapted by Brandon Walker.
 *
 */
public class Governor {
	private static final String THE_POSITION_CANNOT_BE_NULL = "The position cannot be null";
	private int gameHeight;
	private int gameWidth;
	private Position startState;
	private Position endState;
	private Position currentState;
	private boolean episodeEnd = false;

	/**
	 * Creates a new instance of the Governor class.
	 * 
	 * @param height the height of the game board.
	 * @param width  the width of the game board.
	 * @precondition width, height cannot be zero or negative
	 */
	public Governor(int height, int width) {
		if (height == 0 || width == 0) {
			throw new IllegalArgumentException("The governor cannot have a negative size.");
		}
		this.gameHeight = height;
		this.gameWidth = width;
		this.startState = new Position(0, 0, -1); //TODO
		this.endState = new Position(width - 1, 0, 100); //TODO
		this.startEpisode();
	}

	/**
	 * Starts the game episode.
	 * 
	 * @precondition none
	 * @postcondition the episode has started.
	 */
	public void startEpisode() {
		this.currentState = this.startState;
		this.episodeEnd = false;
	}

	/**
	 * Receives an action and then directs the game from there.
	 * 
	 * @precondition none
	 * @postcondition the action happens
	 * @param action the action to take
	 * @return the value of the state that was moved into.
	 */
	public int receiveAction(Action action) {
		Position newPos = this.currentState.clone();
		switch (action) {
			case UP:
				newPos.setyPos(newPos.getyPos() + 1);
				break;
			case DOWN:
				newPos.setyPos(newPos.getyPos() - 1);
				break;
			case LEFT:
				newPos.setxPos(newPos.getxPos() - 1);
				break;
			case RIGHT:
				newPos.setxPos(newPos.getxPos() + 1);
				break;
			default:
				break;
		}
		if (this.outsideMap(newPos)) {
			newPos = this.startState.clone();
			this.currentState = newPos;
		}
		if (this.isInCliff(newPos)) {
			this.currentState = this.startState.clone();
			this.episodeEnd = true;
			return -500;
		} else {
			this.currentState = newPos;
			this.episodeEnd = this.currentState.equals(this.endState);
			return -1;
		}
	}

	/**
	 * Gets and returns the current state.
	 * 
	 * @return the current state
	 */
	public Position getCurrentState() {
		return this.currentState;
	}

	/**
	 * Checks if the position is outside of the map.
	 * 
	 * @precondition the position cannot be null
	 * @param position the position to check.
	 * @return true if outside false if not
	 */
	public boolean outsideMap(Position position) {
		if (position == null) {
			throw new IllegalArgumentException(THE_POSITION_CANNOT_BE_NULL);
		}
		return (position.getxPos() >= gameWidth || position.getxPos() < 0 || position.getyPos() >= gameHeight
				|| position.getyPos() < 0);
	}

	/**
	 * Checks if the position is a cliff position.
	 * 
	 * @precondition the position cannot be null
	 * @param position the position to check
	 * @return true if a cliff, false if not.
	 */
	private boolean isInCliff(Position position) {
		if (position == null) {
			throw new IllegalArgumentException(THE_POSITION_CANNOT_BE_NULL);
		}
		if (position.getxPos() != 0 && position.getxPos() != this.gameWidth - 1) {
			if (position.getyPos() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets and returns if the game episode has ended.
	 * 
	 * @precondition none
	 * @return true if ended, false if not.
	 */
	public boolean isEpisodeEnd() {
		return this.episodeEnd;
	}

	/**
	 * Gets and returns the game boards height.
	 * 
	 * @precondition none
	 * @return the height
	 */
	public int getHeight() {
		return this.gameHeight;
	}

	/**
	 * Gets and returns the width of the
	 * 
	 * @return the width of the game board.
	 */
	public int getWidth() {
		return this.gameWidth;
	}

}
