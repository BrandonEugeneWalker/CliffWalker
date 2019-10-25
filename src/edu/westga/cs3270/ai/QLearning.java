package edu.westga.cs3270.ai;

import java.util.Random;

import edu.westga.cs3270.model.board.QTable;

public class QLearning {
	private Random random;
	private double epsilon;
	private double gamma;
	private double alpha;
	private QTable qTable;
	
	
	public QLearning(double epsilon, double gamma, double alpha, QTable qTable) {
		if (this.qTable == null) {
			throw new IllegalArgumentException("The Q-Table cannot be null!");
		}
		this.epsilon = epsilon;
		this.gamma = gamma;
		this.alpha = alpha;
		this.random = new Random(0);
		this.qTable = qTable;
	}
	
	public void learnEpisode() {
		
	}
	
	private void selectAction() {
		int randomValue = this.random.nextInt(4);
	}

}
