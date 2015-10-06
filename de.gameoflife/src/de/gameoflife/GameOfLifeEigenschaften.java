package de.gameoflife;

public class GameOfLifeEigenschaften {

	/**
	 * Die initiale Besetzungsdichte des Spiel des Lebens in %
	 */
	private final int initialeBesetzungsdichte;
	
	/**
	 * Die Lebensdauer einer Generation in ms
	 */
	private int lebensdauer;

	/**
	 * Die Art der initialen Wahrscheinlichkeitsverteilung
	 */
	private final Verteilungstyp verteilungstyp;

	/**
	 * Die Randbedingung, die verwendet werden soll
	 */
	private final Randbedingungstyp randbedingungstyp;

	/**
	 * Der Konstruktor der Klasse, die die Parameter des Spiel des Lebens
	 * definiert
	 * 
	 * @param initialeBesetzungsdichte
	 *            Die initiale Besetzungsdichte in %
	 * @param initialeWahrscheinlichkeitsverteilung
	 *            Die Art der initialen Verteilung
	 * @param randbedingungstyp
	 *            Die Art der Randbedingung, die verwendet werden soll
	 */
	public GameOfLifeEigenschaften(int initialeBesetzungsdichte, int lebensdauer,
			Verteilungstyp verteilungstyp,
			Randbedingungstyp randbedingungstyp) {
		this.initialeBesetzungsdichte = initialeBesetzungsdichte;
		this.lebensdauer = lebensdauer;
		this.randbedingungstyp = randbedingungstyp;
		this.verteilungstyp = verteilungstyp;
	}

	/**
	 * Diese Methode gibt die anfaengliche Besetzungsdichte des Spiel des Lebens
	 * in % zurueck
	 * 
	 * @return
	 */
	public int getInitialeBesetzungsdichte() {
		return this.initialeBesetzungsdichte;
	}
	
	/**
	 * Diese Methode gibt die Lebensdauer einer Generation in ms zurueck
	 * 
	 * @return Die Lebensdauer einer Generation
	 */
	public int getLebensdauer() {
		return this.lebensdauer;
	}
	
	/**
	 * Diese Methode setzt die Lebensdauer einer Generation in ms
	 * 
	 * @param lebensdauer Die Lebensdauer einer Generation
	 */
	public void setLebensdauer (int lebensdauer) {
		this.lebensdauer = lebensdauer;
	}

	/**
	 * Diese Methode gibt die Art der anfaenglichen Verteilung der
	 * Gitterelemente zurueck
	 * 
	 * @return
	 */
	public Verteilungstyp getWahrscheinlichkeitsverteilungstyp() {
		return this.verteilungstyp;
	}

	/**
	 * Diese Methode gibt die Art der Randbedingung zurueck, die verwendet
	 * werden soll
	 * 
	 * @return
	 */
	public Randbedingungstyp getRandbedingungstyp() {
		return this.randbedingungstyp;
	}

}
