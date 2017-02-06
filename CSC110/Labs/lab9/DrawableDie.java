import java.awt.*;

class DrawableDie extends Rectangle {
	private static final long serialVersionUID = 5L;
	private int numDots;
	private int halfDot; // radius of a dot in pixels
	private int half;
	private int third;
	private int quarter;
	// dot positions
	Point rcenter, lcenter, center, luCorner, llCorner, ruCorner, rlCorner;
	private int size;

	private int quartX;

	private int dotSize;

	DrawableDie(Die die) {
		super();
		numDots = die.getValue();
	}

	/*
	 * Sets the size and location of the super class (Rectangle)
	 */
	void setPosition(int xCoord, int yCoord, int size) {
		// the size is always set to be a multiple of 4
		x = xCoord;
		y = yCoord;
		int halfDot = (int)(Math.round(size/12.0));
		size = halfDot*12;
		dotSize = halfDot*2;
		height = size;
		center = new Point(x+size/2-halfDot,y+size/2-halfDot);
		lcenter = new Point(x+size/4-halfDot,y+size/2-halfDot);
		rcenter = new Point(x+3*size/4-halfDot,y+size/2-halfDot);
		luCorner = new Point(x+size/4-halfDot,y+size/4-halfDot);
		llCorner = new Point(x+size/4-halfDot,y+3*size/4-halfDot);
		ruCorner = new Point(x+3*size/4-halfDot,y+size/4-halfDot);
		rlCorner = new Point(x+3*size/4-halfDot,y+3*size/4-halfDot);
	}

	/*
	 * Draws the Die.
	 */
	void drawDie(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.x,this.y,this.width,this.height);
		g.setColor(Color.gray);
		g.drawRect(this.x,this.y,this.width-1,this.height-1);
		g.setColor(Color.black);
		Point mid = new Point(x+size/2-halfDot,y+size/2-halfDot);
		Point luCorner = new Point(x+size/4-halfDot,y+size/4-halfDot);
		Point llCorner = new Point(x+3*size/4-halfDot,y+size/4-halfDot);
		Point ruCorner = new Point(x+3*size/4-halfDot,y+size/4-halfDot);
		int midX = x+size/2;
		int midY = y+size/2;
		quartX = x+size/4;
		quartX = y+size/4;
		switch(numDots) {
			case 1:
				oneDot(g);
				break;
			case 2:
				twoDots(g);
				break;
			case 3:
				threeDots(g);
				break;
			case 4:
				fourDots(g);
				break;
			case 5:
				fiveDots(g);
				break;
			case 6:
				sizeDots(g);
				break;
		}

	}

	private void oneDot(Graphics g) {
		g.fillOval(center.x,center.y,dotSize,dotSize);
	}
	private void twoDots(Graphics g) {
		g.fillOval(luCorner.x,luCorner.y,dotSize,dotSize);
		g.fillOval(rlCorner.x,rlCorner.y,dotSize,dotSize);
	}
	private void threeDots(Graphics g) {
		oneDot(g);
		twoDots(g);
	}
	private void fourDots(Graphics g) {
		twoDots(g);
		g.fillOval(llCorner.x,llCorner.y,dotSize,dotSize);
		g.fillOval(ruCorner.x,ruCorner.y,dotSize,dotSize);
	}
	private void fiveDots(Graphics g) {
		oneDot(g);
		fourDots(g);
	}
	private void sizeDots(Graphics g) {
		fourDots(g);
		g.fillOval(lcenter.x,lcenter.y,dotSize,dotSize);
		g.fillOval(rcenter.x,rcenter.y,dotSize,dotSize);
	}

}
