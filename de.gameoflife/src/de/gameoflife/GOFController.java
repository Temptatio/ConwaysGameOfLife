package de.gameoflife;

public class GOFController implements GameOfLifeController{

	@Override
	public GameOfLife intialisiereGameOfLife(
			GameOfLifeDatenmodell gameOfLifeDatenmodell) {
		
		GameOfLifeBuilder gameOfLifeBuilder = new GameOfLifeBuilder();
		
		int xDim = gameOfLifeDatenmodell.getxDimension();
		int yDim = gameOfLifeDatenmodell.getyDimension();		
		gameOfLifeBuilder.setDimensions(xDim, yDim);
		
		int initialeBesetzungsdichte = gameOfLifeDatenmodell.getInitialeBesetzungsdichte();
		gameOfLifeBuilder.setInitialeBesetzungsdichte(initialeBesetzungsdichte);
		
		Verteilungstyp verteilungstyp = gameOfLifeDatenmodell.getInitialeVerteilung();
		gameOfLifeBuilder.setInitialeVerteilung(verteilungstyp);
		
		boolean isPeriodischeRandbedingung = gameOfLifeDatenmodell.isPeriodischeRandbedingung();
		gameOfLifeBuilder.setIsPeriodischeRandbedingung(isPeriodischeRandbedingung);
		
		int generationen = gameOfLifeDatenmodell.getGenerationen();
		gameOfLifeBuilder.setGenerationen(generationen);
		
		int lebensdauer = gameOfLifeDatenmodell.getLebensdauer();
		gameOfLifeBuilder.setLebensdauer(lebensdauer);
		
		return gameOfLifeBuilder.build();
	}

}
