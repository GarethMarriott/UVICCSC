import java.awt.*;
import javax.swing.*;

public class Animation {

	/**
 	 * Runs a small animation example.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		// create a red ball in position (150,70)
		Ball ball = new Ball(150,70,30,Color.green);
		// create a frame to contain the ball
		BallFrame bf = new BallFrame(ball,1000,1950);
		bf.showFrame();
	}
}
