package de.gameoflife;

public class Gittereigenschaften {

	/**
	 * Die Zahl der Gitterelemente in horizontaler Richtung
	 */
	private final int xDimension;

	/**
	 * Die Zahl der Gitterelemente in vertikaler Richtung
	 */
	private final int yDimension;

	/**
	 * Der Konstruktor fuer die Klasse, die die Gittereigenschaften definiert
	 * 
	 * @param xDimension
	 *            Die Zahl der Gitterelemente in horizontaler Richtung
	 * @param yDimension
	 *            Die Zahl der Gitterelemente in vertikaler Richtung
	 */
	public Gittereigenschaften(int xDimension, int yDimension) {
		this.xDimension = xDimension;
		this.yDimension = yDimension;
	}
	
	/**
	 * Diese Methode gibt die Zahl der Gitterelemente in horizontaler Richtung zurueck
	 * 
	 * @return
	 */
	public int getXDimension() {
		return this.xDimension;
	}
	
	/**
	 * Diese Methode gibt die Zahl der Gitterelemente in vertikaler Richtung zurueck
	 * @return
	 */
	public int getYDimension() {
		return this.yDimension;
	}
}
