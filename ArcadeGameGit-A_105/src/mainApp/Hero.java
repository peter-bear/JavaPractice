package mainApp;

import java.awt.Color;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Class Hero
 * 
 * @author A_105 <br>
 *         Purpose: Creates a Hero object in Level <br>
 *         Restrictions: Only one Hero per level <br>
 *         For example:
 * 
 *         <pre>
 *         Object h = new Hero(x, y);
 *         </pre>
 */
public class Hero extends Object {

	private static final long serialVersionUID = 1L;
	private final static double X_VEL = 3d;
	private final static double JUMP_VEL = -7.0d;
	private final static double GRAVITY = .23d;
	private final static double TERMINAL_VELOCITY = 7.0d;
	private final static double AIR_FRICTION = 0.075d;
	private int lives;
	private boolean grounded, holdingRight, holdingLeft;
	private Clip jumpSound, hitAlienSound;

	/**
	 * ensures: Initializes a hero at position (x, y)
	 * 
	 * @param x used to initialize the object's x position <br>
	 *          requires: x &ge; 0
	 * @param y used to initialize the object's y position <br>
	 *          requires: y &ge; 0
	 */
	public Hero() {
		super(0, 0, Color.GREEN);
		this.grounded = false;
		this.holdingRight = false;
		this.holdingLeft = false;
		try {
			this.jumpSound = AudioSystem.getClip();
			this.jumpSound.open(
					AudioSystem.getAudioInputStream(FrameDisplay.class.getResourceAsStream("Music/Jump.wav")));
			this.hitAlienSound = AudioSystem.getClip();
			this.hitAlienSound.open(
					AudioSystem.getAudioInputStream(FrameDisplay.class.getResourceAsStream("Music/Hit Alien.wav")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // Hero
	
	/**
	 * ensures: initializes the position of hero
	 * @param x used to initialize the x position of hero
	 * @param y used to initialize the y position of hero
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * ensures: Returns the hero's remaining lives
	 * 
	 * @return the number of lives
	 */
	public int getLives() {
		return this.lives;
	} // End getLives

	/**
	 * ensures: Sets the number of lives
	 * 
	 * @param lives the number of lives <br>
	 *              requires: lives &gt; 0
	 */
	public void setLives(int lives) {
		this.lives = lives;
	} // End setLives

	/**
	 * ensures: Takes a life from the hero
	 */
	public void takeLife() {
		hitAlienSound.start();
		hitAlienSound.setMicrosecondPosition(0);
		this.lives--;
	} // End takeLife

	/**
	 * ensures: Applies a jumping effect to the hero
	 */
	public void jump() {
		if (this.grounded) {
			this.velY = JUMP_VEL;
			jumpSound.start();
			jumpSound.setMicrosecondPosition(0);
		}
		this.grounded = false;
	} // End jump

	/**
	 * ensures: Stops jumping on object collision
	 */
	public void cancelJump() {
		if (this.velY < 0)
			this.velY = 0;
	} // End cancelJump

	/**
	 * ensures: Applies a falling effect faster than normal
	 */
	public void fastFall() {
		if (!grounded)
			this.velY = TERMINAL_VELOCITY;
	} // End fastFall

	/**
	 * ensures: Applies a falling effect
	 */
	public void fall() {
		this.grounded = false;
	} // End fall

	/**
	 * ensures: Determines if a key is being held down
	 * 
	 * @param key  the key that is held or released <br>
	 *             requires: key = "left" || "right"
	 * @param hold true if the key is pressed
	 */
	public void holdKey(String key, boolean hold) {
		if (key == "left")
			this.holdingLeft = hold ? true : false;
		if (key == "right")
			this.holdingRight = hold ? true : false;
	} // End holdKey

	/**
	 * ensures: Checks if the hero is above an enemy
	 * 
	 * @param e the enemy to check for <br>
	 *          requires: e &ne; null
	 * @return true if hero is above the enemy
	 */
	public boolean isAbove(Enemy e) {
		return this.y < e.y - 20 && this.x > e.x - 31 && this.x < e.x + 31;
	} // End isAbove

	/**
	 * ensures: Changes the position of the alien on platform collision
	 * 
	 * @param p the platform the object collides with <br>
	 *          requires: p &ne; null
	 */
	public void reposition(Platform p) {
		if (this.y > p.y + 24) {
			this.y = p.y + 32;
			this.velY = 0;
			return;
		}
		if (this.y < p.y - 24) {
			this.y = p.y - 31;
			this.velY = 0;
			this.grounded = true;
			return;
		}
		if (this.x > p.x + 27) {
			this.x = p.x + 32;			
			this.velX = 0;
			this.grounded = true;
		}
		if (this.x < p.x - 27) {
			this.x = p.x - 32;
			this.velX = 0;
			this.grounded = true;
		}
	} // End reposition

	/**
	 * ensures: Adds a knockback effect on collision with enemy
	 * 
	 * @param e the enemy that the hero collides with <br>
	 *          requires: e &ne; null
	 */
	public void knockBack(Enemy e) {
		this.grounded = true;
		double xVector = this.x - e.x;
		double yVector = this.y - e.y;
		double normalize = invSqrt(xVector * xVector + yVector * yVector);
		this.velX = xVector * normalize * 4;
		this.velY = yVector * normalize * 4;
		e.knockBack(-xVector * normalize * 6, -yVector * normalize * 6);
	} // End knockBack

	/**
	 * ensures: Updates the location of the alien
	 */
	@Override
	public void update() {
		super.update();
		if (this.holdingRight)
			this.velX = X_VEL;
		if (this.holdingLeft)
			this.velX = -X_VEL;
		if (!this.grounded) {
			this.velY += GRAVITY;
			if (Math.abs(this.velX) - AIR_FRICTION >= 0 && !(holdingLeft || holdingRight)) {
				this.velX -= this.velX > 0 ? AIR_FRICTION : -AIR_FRICTION;
			}
			if (this.velY > TERMINAL_VELOCITY)
				this.velY = TERMINAL_VELOCITY;
		} else if (!(holdingLeft || holdingRight))
			this.velX = 0;
	} // End update
}
