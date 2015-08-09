package de.gameoflife;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainClass extends JComponent {

	private static final int	XDIM			= 150;
	private static final int	YDIM			= 150;
	private static final int	GENERATIONEN	= -1;
	public static GameOfLife	gameOfLife;

	public static void main(String[] args) throws InterruptedException {
		MainClass fenster = new MainClass();
		gameOfLife = new GameOfLife(XDIM, YDIM, XDIM * YDIM / 3);

		JFrame frame = new JFrame("MainClass");
		frame.add(fenster);
		frame.setSize(XDIM * 4, YDIM * 4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		int i = GENERATIONEN;
		while(i != 0) {
			gameOfLife.naechsteGeneration();
			Thread.sleep(100);
			fenster.repaint();
			i -= (GENERATIONEN > -1) ? 1 : 0;
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(gameOfLife.GitterAlsBild(), 0, 0, this);
	}
}
