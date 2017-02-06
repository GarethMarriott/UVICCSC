import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * A frame that houses a bouncing ball.
 * The ball starts and stops with a user mouse click.
 * @author: Bette Bultena (for use in UVic CSC110 labs.
 */
public class BallFrame extends JPanel implements Runnable, MouseListener {

// initial Ball info:
	private int start_x = 150;
	private int start_y = 50;
	private int dx = 11;
	private int dy = 5;
	private Ball ball;
// The graphics and animation part
	private Thread animator;
	private int width;
	private int height;
	private boolean timeToStop;
	private Image buffer;
	private Graphics bufferGraphics;
	private static final int sleep = 30;

	/**
	 * Create a frame that contains a bouncing ball.
	 * @param ball The ball.
	 * @param height The height, in pixels, of the frame.
	 * @param width The width, in pixels, of the frame.
	 */
	public BallFrame(Ball ball, int height, int width) {
		super();
		this.ball = ball;
		this.width = width;
		this.height = height;
		this.setPreferredSize(new Dimension(width,height));
		addMouseListener(this);
		repaint();
	}

	/**
	 * Starts the animation thread.
	 */
	public void start() {
		if (animator == null) {
			timeToStop = false;
			animator = new Thread(this);
			animator.start();
		}
	}

	/**
	 * Stops the animation thread.
	 */
	public void stop() {
		timeToStop = true;
	}

	/**
	 * Paints the frame to accommodate the ball movement.
	 * To reduce flickering of the whole image, a buffer is used.
	 * @param g The paintbrush for this component.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// clear the buffer of the image
		buffer = this.createImage(this.getWidth(),this.getHeight());
		bufferGraphics = buffer.getGraphics();
		bufferGraphics.setColor(this.getBackground());
		bufferGraphics.fillRect(0,0,width,height);
		// Draw the ball into the buffer
		bufferGraphics.setColor(ball.getColour());
		Point p = ball.getPoint();
		int r = ball.getRadius();
		bufferGraphics.fillOval(p.x-r,p.y-r,r*2,r*2);
		// draw the image to this panel
		g.drawImage(buffer,0,0,this);
	}

	/**
	 * Adjusts the location of the ball within the frame each sleep interval.
	 */
	public void run() {
		int r = ball.getRadius();
		int x = ball.getPoint().x;
		int y = ball.getPoint().y;
		while(!timeToStop) {
			// Change direction when we hit an edge.
			if ((x-r+dx < 0) || (x+r+dx  > width)) {
				dx = -dx;
			}
			if ((y-r+dy < 0) || (y+r+dy > height)) {
				dy = -dy;
			}
			ball.move(dx,dy);
			// Get the new point
			x = ball.getPoint().x;
			y = ball.getPoint().y;
			//repaint only the portion of the image that was altered.
			// The following two statements are consolidated to repaint the area that
			// was changed.
			repaint(x-r-dx,y-r-dy,2*r,2*r);
			repaint(x-r,y-r,2*r,2*r);
			// pause
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupt");
			}
		}
		animator = null;
	}

	/**
	 * Responds to a mouse click with the frame.
	 * @param e The event that is registered with this component.
	 */
	public void mouseClicked(MouseEvent e) {
		if (animator != null) {
			timeToStop = true;
		} else {
			start();
		}
	}

/* the folowing methods are not used but are required to be present for the MouseListener Interface.*/
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}

	/**
	 * Render the frame on the computer screen.
	 */
	public void showFrame() {
		JFrame frame = new JFrame("Bouncing Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
	}
}
