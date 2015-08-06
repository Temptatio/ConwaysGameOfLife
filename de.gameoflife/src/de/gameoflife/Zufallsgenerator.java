package de.gameoflife;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Zufallsgenerator {
	
//	private SecureRandom secureRandom;
	private Random secureRandom;
	
	public Zufallsgenerator() {
		SecureRandom tmp = new SecureRandom();
		long seed = new BigInteger(tmp.generateSeed(64)).longValue();
		this.secureRandom = new Random(seed);
	}
	
	public boolean isBesetzt() {
		return (this.secureRandom.nextBoolean());
	}
	
	public int getZufallskoordinate(int min, int max) {
		return this.secureRandom.nextInt((max+min))-min;
	}
	
}
