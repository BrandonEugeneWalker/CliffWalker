package edu.westga.cs3270.ai;

import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs3270.model.Action;
import edu.westga.cs3270.model.QState;
import edu.westga.cs3270.model.board.QTable;

public class QLearning {
	private Random random;
	private double epsilon;
	private double gamma;
	private double alpha;
	private QTable qTable;
	private boolean isOver;
	private ArrayList<String> movesPerformed;
	
	
	public QLearning(double epsilon, double gamma, double alpha, QTable qTable) {
		this.epsilon = epsilon;
		this.gamma = gamma;
		this.alpha = alpha;
		this.random = new Random(0);
		this.qTable = qTable;
		this.isOver = false;
		this.movesPerformed = new ArrayList<String>();
	}
	
	public void runLearningEpisode(int numberOfEpisodes) {
		for (int i = 0; i < numberOfEpisodes; i++) {
			while(!this.isOver) {
				this.makeMove();
			}
			this.printGamePath();
			this.movesPerformed.clear();
		}
	}
	
	
	public void makeMove() {
		//choose action
		Action selectedAction = this.selectAction();
		QState currentPosition = this.qTable.getCurrentPosition();
		double qValueOld = this.qTable.getActionRewardValue(selectedAction);
		
		//do action
		this.performAction(selectedAction);
		
		//update q values
		int actionReward = this.qTable.getCurrentPosition().getStateReward();
		double bestActionValue = this.qTable.getCurrentPosition().getBestActionValue();
		double td_target =  actionReward + (this.gamma * bestActionValue);
		double td_error = td_target - qValueOld;
		double qValueNew = qValueOld + (this.alpha * td_error);
		this.updateActionReward(selectedAction, currentPosition, qValueNew);
		
		if (this.qTable.isAtGoalState() || this.qTable.isAtGoalState()) {
			this.isOver = true;
		}
		
		
	}
	
	private Action selectAction() {
		double randomDouble = this.random.nextDouble();
		Action selectedAction = null;
		if(randomDouble < this.epsilon) {
			int randomActionSelector = this.random.nextInt(4);
			selectedAction = this.actionFromInt(randomActionSelector);
		} else {
			selectedAction = this.qTable.getCurrentPosition().getBestAction();
		}
		return selectedAction;
	}
	
	private Action actionFromInt(int id) {
		Action returnAction = null;
		switch (id) {
		case 0:
			returnAction = Action.UP;
		case 1:
			returnAction = Action.DOWN;
		case 2:
			returnAction = Action.LEFT;
		case 3:
			returnAction = Action.RIGHT;
		default:
			break;	
		}
		return returnAction;
	}
	
	private int intFromAction(Action action) {
		int returnInt = -1;
		switch (action) {
			case UP:
				returnInt = 0;
			case DOWN:
				returnInt = 1;
			case LEFT:
				returnInt = 2;
			case RIGHT:
				returnInt = 3;
			default:
				break;
		}
		return returnInt;
	}
	
	private void performAction(Action action) {
		switch (action) {
			case UP:
				this.qTable.moveUp();
				this.movesPerformed.add("UP");
			case DOWN:
				this.qTable.moveDown();
				this.movesPerformed.add("DOWN");
			case LEFT:
				this.qTable.moveLeft();
				this.movesPerformed.add("LEFT");
			case RIGHT:
				this.qTable.moveRight();
				this.movesPerformed.add("RIGHT");
			default:
				break;
		}
	}
	
	private void updateActionReward(Action action, QState state, double newReward) {
			switch (action) {
			case UP:
				state.setUp(newReward);
			case DOWN:
				state.setDown(newReward);
			case LEFT:
				state.setLeft(newReward);
			case RIGHT:
				state.setRight(newReward);
			default:
				break;
		}
	}
	
	private void printGamePath() {
		System.out.println("------ Moves ------");
		int count = 1;
		for(String currentString : this.movesPerformed) {
			System.out.println("Move " + count + " " + currentString);
			count++;
		}
		System.out.println("------  End  ------");
	}

}
