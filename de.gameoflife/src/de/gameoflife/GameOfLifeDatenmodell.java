package de.gameoflife;

public class GameOfLifeDatenmodell {
	
	private int xDimension;
	private int yDimension;
	
	private int lebensdauer;
	
	private int initialeBesetzungsdichte;
	
	private Verteilungstyp initialeVerteilung;
	
	private int generationen;
	
	private boolean isPeriodischeRandbedingung;

	public int getxDimension() {
		return this.xDimension;
	}

	public void setxDimension(int xDimension) {
		this.xDimension = xDimension;
	}

	public int getyDimension() {
		return this.yDimension;
	}

	public void setyDimension(int yDimension) {
		this.yDimension = yDimension;
	}

	public int getLebensdauer() {
		return this.lebensdauer;
	}

	public void setLebensdauer(int lebensdauer) {
		this.lebensdauer = lebensdauer;
	}

	public int getInitialeBesetzungsdichte() {
		return this.initialeBesetzungsdichte;
	}

	public void setInitialeBesetzungsdichte(int initialeBesetzungsdichte) {
		this.initialeBesetzungsdichte = initialeBesetzungsdichte;
	}

	public Verteilungstyp getInitialeVerteilung() {
		return this.initialeVerteilung;
	}

	public void setInitialeVerteilung(Verteilungstyp initialeVerteilung) {
		this.initialeVerteilung = initialeVerteilung;
	}

	public int getGenerationen() {
		return this.generationen;
	}

	public void setGenerationen(int generationen) {
		this.generationen = generationen;
	}

	public boolean isPeriodischeRandbedingung() {
		return this.isPeriodischeRandbedingung;
	}

	public void setPeriodischeRandbedingung(boolean isPeriodischeRandbedingung) {
		this.isPeriodischeRandbedingung = isPeriodischeRandbedingung;
	}
	

}
