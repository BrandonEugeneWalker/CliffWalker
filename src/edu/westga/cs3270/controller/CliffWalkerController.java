package edu.westga.cs3270.controller;

import edu.westga.cs3270.ai.QLearning;
import edu.westga.cs3270.model.board.BasicTable;
import edu.westga.cs3270.model.board.QTable;

public class CliffWalkerController {

	public static void main(String[] args) {
		QTable learningTable = new BasicTable(3, 11);
		
		double epsilon = 0.1;
		double gamma = 0.9;
		double alpha = 0.1;
		
		QLearning learningAI = new QLearning(epsilon, gamma, alpha, learningTable);
		
		learningAI.runLearningEpisode(1);
		String results = learningTable.convertBoardBaluesToString();
		
		System.out.print(results);

	}

}
