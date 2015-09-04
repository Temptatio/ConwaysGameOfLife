package de.gameoflife;

import java.awt.image.BufferedImage;

public class GameOfLife {

	Gittereigenschaften		gittereigenschaften;
	GameOfLifeEigenschaften	gameOfLifeEigenschaften;

	private Gitter gitter;

	public GameOfLife(Gittereigenschaften gittereigenschaften,
			GameOfLifeEigenschaften gameOfLifeEigenschaften) {
		this.gittereigenschaften = gittereigenschaften;
		this.gameOfLifeEigenschaften = gameOfLifeEigenschaften;

		this.gitter = new Gitter(gittereigenschaften);

		this.init();
	}

	private void init() {

		Zufallsgenerator zufallsgenerator = new Zufallsgenerator();
		int besetzt = 0;

		while (!isVoll(besetzt)) {
			int x = zufallsgenerator.getZufallskoordinate(0,
					this.gittereigenschaften.getXDimension());
			int y = zufallsgenerator.getZufallskoordinate(0,
					this.gittereigenschaften.getYDimension());

			if (!this.gitter.getElement(x, y)) {
				this.gitter.setElement(x, y, true);
				++besetzt;
			}
		}
	}

	private boolean isVoll(int besetzt) {
		int maxBesetzung = this.gameOfLifeEigenschaften
				.getInitialeBesetzungsdichte()
				* this.gittereigenschaften.getXDimension()
				* this.gittereigenschaften.getYDimension();
		return maxBesetzung == besetzt;
	}

	public void naechsteGeneration() {

		Gitter neuesGitter = new Gitter(this.gittereigenschaften);

		for (int i = 0; i < this.gittereigenschaften.getXDimension(); ++i) {
			for (int j = 0; j < this.gittereigenschaften.getYDimension(); ++j) {
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
						neuesGitter.setElement(i, j,
								true && this.gitter.getElement(i, j));
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

	public int getLebensdauer() {
		return this.gameOfLifeEigenschaften.getLebensdauer();
	}

	public void setLebensdauer(int lebensdauer) {
		this.gameOfLifeEigenschaften.setLebensdauer(lebensdauer);
	}

	public BufferedImage GitterAlsBild() {
		return this.gitter.getAlsBild();
	}

}
