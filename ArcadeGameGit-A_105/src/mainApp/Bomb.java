package mainApp;

import java.awt.geom.Rectangle2D;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.Color;

/**
 * Class Bomb
 * 
 * @author A_105 <br>
 *         Purpose: Creates a Bomb that must be collected by the Hero <br>
 *         Restrictions: None <br>
 *         For example:
 * 
 *         <pre>
 *         Object b = new Bomb(x, y);
 *         </pre>
 */
public class Bomb extends Object {

	private static final long serialVersionUID = 1L;
	private Clip bombCollect;

	/**
	 * ensures: Initializes a bomb at position (x, y)
	 * 
	 * @param x used to initialize the object's x position <br>
	 *          requires: x &ge; 0
	 * @param y used to initialize the object's y position <br>
	 *          requires: y &ge; 0
	 */
	public Bomb(int x, int y) {
		super(x, y, Color.BLACK);
		try {
			this.bombCollect = AudioSystem.getClip();
			this.bombCollect.open(
					AudioSystem.getAudioInputStream(FrameDisplay.class.getResourceAsStream("Music/Bomb Collect.wav")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // End constructor

	/**
	 * ensures: Removes the bomb after it has been collected by the hero
	 */
	public void collect() {
		bombCollect.start();
		bombCollect.setMicrosecondPosition(0);
		this.isDead = true;
		this.collisionShape = new Rectangle2D.Double();
	} // End collect
}
