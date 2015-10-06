package de.gameoflife;

import javax.swing.WindowConstants;

public class MainClass {
	public static void main(String[] args) {
		GameOfLifeMaske gameOfLifeMaske = new GameOfLifeMaske(new GOFController());
		gameOfLifeMaske.setVisible(true);
		gameOfLifeMaske.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
