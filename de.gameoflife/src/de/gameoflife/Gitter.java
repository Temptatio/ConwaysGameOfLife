package de.gameoflife;

import java.awt.image.BufferedImage;

public class Gitter {

	private final int	xDim;
	private final int	yDim;
	private final int	maxBesetzt;
	private boolean[]	gitter;

	public Gitter(int xDim, int yDim, int maxBesetzt) {
		this.xDim = xDim;
		this.yDim = yDim;
		this.maxBesetzt = maxBesetzt;
		this.gitter = new boolean[this.xDim * this.yDim];
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
