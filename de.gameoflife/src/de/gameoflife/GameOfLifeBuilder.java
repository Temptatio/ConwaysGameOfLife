package de.gameoflife;

public class GameOfLifeBuilder {

	private static final int	XDIMDEFAULT						= 100;
	private static final int	YDIMDEFAULT						= 100;
	private static final int	INITIALEBESETZUGSDICHTEDEFAULT	= 30;

	/**
	 * Die Zahl der Gitterelemente in x-Richtung
	 */
	private int xDim;

	/**
	 * Die Zahl der Gitterelemente in y-Richtung
	 */
	private int yDim;

	/**
	 * Die initiale Besetzungsdichte in %
	 */
	private int intialeBesetzungsdichte;

	/**
	 * Die Zahl der Generationen
	 */
	private int generationen;

	/**
	 * Die Lebensdauer einer Generation in ms
	 */
	private int lebensdauer;

	/**
	 * Die initiale Wahrscheinlichkeitsverteilung
	 */
	private Verteilungstyp verteilungstyp;

	/**
	 * Ein Flag, das anzeigt, ob periodische Randbedingungen benutzt werden
	 * sollen, oder nicht
	 */
	private boolean isPeriodischeRandbedingung;

	public GameOfLifeBuilder() {
		this.yDim = YDIMDEFAULT;
		this.xDim = XDIMDEFAULT;
		this.intialeBesetzungsdichte = INITIALEBESETZUGSDICHTEDEFAULT;
		// TODO Implementierung einfuegen, sobald vorhanden
		// this.wahrscheinlichkeitsverteilung = ;
		this.isPeriodischeRandbedingung = true;
	}

	/**
	 * Diese Methode setzt die gewuenschten Dimensionen des dem Spiel des Lebens
	 * zugrunde liegenden Gitters
	 * 
	 * @param xDim
	 *            Die Zahl der Gitterelemente in x-Richtung
	 * @param yDim
	 *            Die Zahl der Gitterelemente in y-Richtung
	 */
	public void setDimensions(int xDim, int yDim) {
		this.xDim = xDim;
		this.yDim = yDim;
		this.intialeBesetzungsdichte = INITIALEBESETZUGSDICHTEDEFAULT;
	}

	/**
	 * Diese Methode setzt die initiale Besetzungsdichte des Spiel des Lebens
	 * 
	 * @param initialeBesetzungsdichte
	 *            Die anfaengliche Besetzungsdichte des Spiel des Lebens
	 */
	public void setInitialeBesetzungsdichte(int initialeBesetzungsdichte) {
		this.intialeBesetzungsdichte = initialeBesetzungsdichte;
	}

	/**
	 * Diese Methode setzt die Zahl der Generationen fuer das Spiel des Lebens
	 * 
	 * @param generationen
	 *            Die Zahl der Generationen; falls der Wert kleiner 0 ist,
	 *            werden so viele Generationen erzeugt wie moeglich
	 */
	public void setGenerationen(int generationen) {
		this.generationen = generationen;
	}

	/**
	 * Diese Methode setzt die Lebensdauer einer Generation in ms
	 * 
	 * @param lebensdauer
	 *            Die Lebensdauer einer Generation in ms
	 */
	public void setLebensdauer(int lebensdauer) {
		this.lebensdauer = lebensdauer;
	}

	/**
	 * Diese Methode setzt die intiale Zufallsverteilung, der die besetzten
	 * Gitterelemente folgen
	 * 
	 * @param zufallsverteilung
	 *            Die anfaengliche Zufallsverteilung
	 */
	public void setInitialeVerteilung(Verteilungstyp verteilungstyp) {
		this.verteilungstyp = verteilungstyp;
	}

	/**
	 * Diese Methode setzt das Flag, ob periodische Randbedingungen verwendet
	 * werden sollen, oder nicht
	 * 
	 * @param isPeriodischeRandbedingung
	 *            <tt>true</tt> bei periodischen Randbedingungen; <tt>false</tt>
	 *            bei nicht-periodischen Randbedingungen
	 */
	public void setIsPeriodischeRandbedingung(
			boolean isPeriodischeRandbedingung) {
		this.isPeriodischeRandbedingung = isPeriodischeRandbedingung;
	}

	/**
	 * Diese Methode baut eine Instanz des Spiel des Lebens mit den definierten
	 * Parametern und gibt diese zurueck
	 * 
	 * @return Das mit den gewuenschten Parametern erstelle Spiel des Lebens
	 */
	public GameOfLife build() {
		Gittereigenschaften gittereigenschaften = new Gittereigenschaften(
				this.xDim, this.yDim);
		GameOfLifeEigenschaften gameOfLifeEigenschaften = new GameOfLifeEigenschaften(
				this.intialeBesetzungsdichte, this.lebensdauer,
				this.verteilungstyp, Randbedingungstyp.PERIODISCH);
		return new GameOfLife(gittereigenschaften, gameOfLifeEigenschaften);
	}

}
