package de.gameoflife;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainClass extends JComponent {
	
	private static final int XDIM = 150;
	private static final int YDIM = 150;
	private static final int GENERATIONEN = 1000;
	
//	public static void main(String[] args) throws InterruptedException {		
//		Gitter gitter = new Gitter(XDIM, YDIM, 50);
//		
//		for(int i = 0; i < GENERATIONEN; ++i) {
//			gitter.printGitter();
//			gitter.naechsteGeneration();
//			System.out.print("\n");
//			Thread.sleep(500);
//		}
//	}
	public static Gitter gitter;
	
	public static void main(String[] args) throws InterruptedException {	
		MainClass fenster = new MainClass();
		gitter = new Gitter(XDIM, YDIM, (int)(XDIM*YDIM*0.9));
		
		JFrame frame = new JFrame("MainClass");
		frame.add(fenster);
		frame.setSize(XDIM*4, YDIM*4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		for(int i = 0; i < GENERATIONEN; ++i) {
//		gitter.printGitter();
		gitter.naechsteGeneration();
//		System.out.print("\n");
		Thread.sleep(100);
		fenster.repaint();
	}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(gitter.getAlsBild(), 0, 0, this);
	}
}
