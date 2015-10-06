package de.gameoflife;

/**
 * Diese Schnittstelle definiert die Faehigkeiten einer
 * Wahrscheinlichkeitsverteilung
 *
 */
public interface Wahrscheinlichkeitsverteilung {

	/**
	 * Diese Methode gibt den naechsten zufaellig verteilten boolean-Wert
	 * zurueck
	 * 
	 * @return Eine Zufallszahl
	 */
	public boolean isBesetzt();

	/**
	 * Diese Methode gibt einen zufaellig verteilten integer-Wert in einem gegebenen Intervall zurueck
	 * @param min Der Minimalwert, der von der Zufallszahl angenommen werden kann
	 * @param max Der Maximalwert, der von der Zufallszahl angenommen werden kann
	 * @return Eine Zufallszahl
	 */
	public int getZufallskoordinate(int min, int max);

}
