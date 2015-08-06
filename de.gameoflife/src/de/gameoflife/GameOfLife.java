package de.gameoflife;

import java.awt.image.BufferedImage;

public class GameOfLife {

	private static final int	XDEFAULT			= 100;
	private static final int	YDEFAULT			= 100;
	private static final int	MAXBESETZTDEFAULT	= 30;
	
	private int xDim;
	private int yDim;
	private int initialeBesetzung;
	
	private Gitter gitter;
	
	public GameOfLife(int xDim, int yDim, int initialeBesetzung) {
		this.xDim = xDim;
		this.yDim = yDim;
		this.initialeBesetzung = initialeBesetzung;
		
		this.gitter = new Gitter(xDim, yDim, initialeBesetzung);
		this.init();
	}

	private void init() {
		
		Zufallsgenerator zufallsgenerator = new Zufallsgenerator();
		int besetzt = 0;
		
		while(!isVoll(besetzt)) {
			int x = zufallsgenerator.getZufallskoordinate(0, this.xDim);
			int y = zufallsgenerator.getZufallskoordinate(0, this.yDim);
			
			if(!this.gitter.getElement(x, y)) {
				this.gitter.setElement(x, y, true);
				++besetzt;
			}
		}
	}

	private boolean isVoll(int besetzt) {
		return this.initialeBesetzung == besetzt;
	}

	public void naechsteGeneration() {

		Gitter neuesGitter = new Gitter(this.xDim, this.yDim, 0);

		for (int i = 0; i < this.xDim; ++i) {
			for (int j = 0; j < this.yDim; ++j) {
				int l = (this.gitter.getElement(i - 1, j)) ? 1 : 0;
				int lo = (this.gitter.getElement(i - 1, j + 1)) ? 1 : 0;
				int mo = (this.gitter.getElement(i, j + 1)) ? 1 : 0;
				int ro = (this.gitter.getElement(i + 1, j + 1)) ? 1 : 0;
				int r = (this.gitter.getElement(i + 1, j)) ? 1 : 0;
				int ru = (this.gitter.getElement(i + 1, j - 1)) ? 1 : 0;
				int mu = (this.gitter.getElement(i, j - 1)) ? 1 : 0;
				int lu = (this.gitter.getElement(i - 1, j - 1)) ? 1 : 0;

				int besetzteNachbarn = l + lo + mo + ro + r + ru + mu + lu;
				
				switch (besetzteNachbarn) {
					case 2:
						neuesGitter.setElement(i, j, true && this.gitter.getElement(i, j));
						break;
					case 3:
						neuesGitter.setElement(i, j, true);
						break;
					default:
						neuesGitter.setElement(i, j, false);
						break;
				}
			}
		}

		this.gitter = neuesGitter;
	}
	
	public BufferedImage GitterAlsBild() {
		return this.gitter.getAlsBild();
	}

}
