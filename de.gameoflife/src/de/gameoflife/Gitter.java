package de.gameoflife;

import java.awt.image.BufferedImage;

public class Gitter {

	private static final int	XDEFAULT			= 100;
	private static final int	YDEFAULT			= 100;
	private static final int	MAXBESETZTDEFAULT	= 30;

	private final int	xDim;
	private final int	yDim;
	private final int	maxBesetzt;
	private boolean[]	gitter;

	public Gitter() {
		this(XDEFAULT, YDEFAULT, MAXBESETZTDEFAULT);
	}

	public Gitter(int x, int y) {
		this(x, y, MAXBESETZTDEFAULT);
	}

	public Gitter(int xDim, int yDim, int maxBesetzt) {
		this.xDim = xDim;
		this.yDim = yDim;
		this.maxBesetzt = maxBesetzt;
		this.gitter = new boolean[this.xDim * this.yDim];

		if(this.maxBesetzt > 0) {
			init();
		}
	}

	private void init() {
		
//		this.setElement(35, 35, true);
//		this.setElement(35, 36, true);
//		this.setElement(36, 35, true);
//		this.setElement(36, 36, true);
		
		Zufallsgenerator zufallsgenerator = new Zufallsgenerator();
		int besetzt = 0;
		
		while(!isVoll(besetzt)) {
			int x = zufallsgenerator.getZufallskoordinate(0, this.xDim);
			int y = zufallsgenerator.getZufallskoordinate(0, this.yDim);
			
			if(!this.getElement(x, y)) {
				this.setElement(x, y, true);
				++besetzt;
			}
		}
		
//		for (int i = 0; i < this.xDim && !isVoll(besetzt); ++i) {
//			for (int j = 0; j < this.yDim && !isVoll(besetzt); ++j) {
//				boolean isBesetzt = zufallsgenerator.isBesetzt();
//				besetzt += (isBesetzt) ? 1 : 0;
//				this.setElement(i, j, isBesetzt);
//			}
//		}
	}

	private boolean isVoll(int besetzt) {
		return this.maxBesetzt == besetzt;
	}

	public boolean getElement(int x, int y) {

		if (x >= this.xDim || x < 0) {
			x = (x + this.xDim) % this.xDim;
		}

		if (y >= this.yDim || y < 0) {
			y = (y + this.yDim) % this.yDim;
		}

		return this.gitter[y * this.xDim + x];
	}

	public void setElement(int x, int y, boolean isBesetzt) {
		if (x > this.xDim || y > this.yDim) {
			throw new ArrayIndexOutOfBoundsException();
		}

		this.gitter[y * this.xDim + x] = isBesetzt;
	}

	public void naechsteGeneration() {

		Gitter neuesGitter = new Gitter(this.xDim, this.yDim, 0);

		for (int i = 0; i < this.xDim; ++i) {
			for (int j = 0; j < this.yDim; ++j) {
				int l = (this.getElement(i - 1, j)) ? 1 : 0;
				int lo = (this.getElement(i - 1, j + 1)) ? 1 : 0;
				int mo = (this.getElement(i, j + 1)) ? 1 : 0;
				int ro = (this.getElement(i + 1, j + 1)) ? 1 : 0;
				int r = (this.getElement(i + 1, j)) ? 1 : 0;
				int ru = (this.getElement(i + 1, j - 1)) ? 1 : 0;
				int mu = (this.getElement(i, j - 1)) ? 1 : 0;
				int lu = (this.getElement(i - 1, j - 1)) ? 1 : 0;

				int besetzteNachbarn = l + lo + mo + ro + r + ru + mu + lu;
				
				switch (besetzteNachbarn) {
					case 2:
						neuesGitter.setElement(i, j, true && getElement(i, j));
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

		this.gitter = neuesGitter.getGitter();
	}

	public void printGitter() {
		for (int i = 0; i < this.xDim; ++i) {
			for (int j = 0; j < this.yDim; ++j) {
				String data = (getElement(j, i)) ? "X " : "  ";
				System.out.print(data);
			}
			System.out.print("\n");
		}
	}

	private boolean[] getGitter() {
		return this.gitter;
	}
	
	public BufferedImage getAlsBild() {
		BufferedImage gitterAlsBild = new BufferedImage(this.xDim*4, this.yDim*4, BufferedImage.TYPE_INT_RGB);
		
		for(int i = 0; i < this.xDim; ++i) {
			for(int j = 0; j < this.yDim; ++j) {
				int farbe = (this.getElement(i, j)) ? 0 : 16777215;
				
				int xPos = i*4;
				int yPos = j*4;
				
				for(int n = 0; n < 4; ++n) {
					for(int m = 0; m < 4; ++m) {
						gitterAlsBild.setRGB(xPos+n, yPos+m, farbe);
					}
				}
			}
		}
		
		return gitterAlsBild;
	}

}
