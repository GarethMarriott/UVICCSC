import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * DicePanel is created specifically as a teaching demo for first year Computer Science students.
 * It demonstrates the rendering of two instances of a Die class that has a roll method.
 * To be shown on its own, it needs to be created,
 * and then showFrame() called.
 * It can be run from this file, but it is recommended that it be run from a student's
 * program.
 * The panel is created with some flexibilty to position the dice in a central location.
 * A maximum size for the dice are set, though.
 *
 * Created by B. Bultena : 2016-09-15
 *
 * This Jaa code is open source and may be used as a learning tool
 * and can be shared, but should not be claimed as original work
 * by anyone using this file.
 * Modifications are encouraged; however must include credit to the original author.
 */

public class DicePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 16L;
	// initial Die info:
	private DrawableDie d1 = new DrawableDie();
	private DrawableDie d2 = new DrawableDie();
	private int dotSize;
	// This panel info:
	private int panelWidth, panelHeight,buttonHeight;
	// Default values
	private static final int HT = 200;
	private static final int WD = 400;
	private static final int MAX_DIE_SIZE = 60;

	/**
	 * Initializes a panel with two dice that are randomly rolled to initial values.
	 * @param width The preferred width of the panel.
	 * @param height The preferred height of the panel.
	 */
	public DicePanel(int width, int height) {
		super();
		JButton rollCmd = new JButton("Roll!");
		buttonHeight = rollCmd.getSize().height;
		panelWidth = width;
		panelHeight = height+buttonHeight;
		this.setPreferredSize(new Dimension(panelWidth,panelHeight));
		rollCmd.addActionListener(this);
		setLayout(new BorderLayout());
		add(rollCmd,BorderLayout.NORTH);
		d1 = new DrawableDie();
		d2 = new DrawableDie();
		// layout the components
		repaint();
	}

	public DicePanel() {
		this(WD,HT);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension new_size = getSize();
		panelWidth = new_size.width;
		panelHeight = new_size.height-buttonHeight;
		// determine a 'fittable' size for the dice (up to the max size).
		int d_width = panelWidth/5;
		int d_height = (panelHeight-buttonHeight)/3;
		int d_size = Math.min(MAX_DIE_SIZE,Math.min(d_width,d_height));
		// place the dice relatively central to the panel
		int rollSpace = 3*d_size;
		int firstDieX = (panelWidth-rollSpace)/2;
		int secondDieX = firstDieX+d_size+d_size;
		int dieY = (panelHeight-d_size)/2+buttonHeight;
		d1.setPosition(firstDieX,dieY,d_size);
		d2.setPosition(secondDieX,dieY,d_size);
		d1.drawDie(g);
		d2.drawDie(g);
	}

	public void actionPerformed(ActionEvent e) {
		d1.numDots = d1.die.roll();
		d2.numDots = d2.die.roll();
		repaint();
	}

	/**
	 * Render the frame on the computer screen.
	 */
	public void showFrame() {
		JFrame frame = new JFrame("Rolling Dice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
	}

	/*
	 * A private inner class.
	 * The DrawableDie is a picture of a specific Die object that can be rendered within the DicePanel.
	 */

	private class DrawableDie extends Rectangle {
		private static final long serialVersionUID = 5L;
		private int halfDot; // radius of a dot in pixels
		// dot positions
		private Point center, luCorner, llCorner, ruCorner, rlCorner,lCenter,rCenter;
		// And of course the die that it represents
		Die die;
		int numDots;

		DrawableDie() {
			super();
			die = new Die();
			die.roll(); //give it a random start.
			numDots = die.getValue();
		}

		/*
		 * Sets the size and location of the super class (Rectangle)
		 * Point of origin is the bottom upper corner of the rectangle.
		 * Must be called before drawing on a panel.
		 */
		void setPosition(int xCoord, int yCoord, int size) {
			// the size is always set to be a multiple of 4
			x = xCoord;
			y = yCoord;
			int halfDot = (int)(Math.round(size/12.0));
			size = halfDot*12;
			dotSize = halfDot*2;
			height = size;
			width = size;
			center = new Point(x+size/2-halfDot,y+size/2-halfDot);
			lCenter = new Point(x+size/4-halfDot,y+size/2-halfDot);
			rCenter = new Point(x+3*size/4-halfDot,y+size/2-halfDot);
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
			g.fillRect(x,y,width,height);
			g.setColor(Color.black);
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
					sixDots(g);
					break;
			}
			g.setColor(Color.black);
			g.drawRect(this.x,this.y,this.width-1,this.height-1);
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
		private void sixDots(Graphics g) {
			fourDots(g);
			g.fillOval(lCenter.x,lCenter.y,dotSize,dotSize);
			g.fillOval(rCenter.x,rCenter.y,dotSize,dotSize);
		}
	} // end of private inner class


	public static void main(String[] args) {
		DicePanel dp = new DicePanel();
		dp.showFrame();
	}
}
