package mainApp;

/**
 * Class AlienTwo
 * 
 * @author A_105 <br>
 *         Purpose: Creates an Alien that tracks the Hero <br>
 *         Restrictions: None <br>
 *         For example:
 * 
 *         <pre>
 *         Object a2 = new AlienTwo(x, y, hero);
 *         </pre>
 */

public class AlienTwo extends Enemy {

	private static final long serialVersionUID = 1L;
	private Object target;

	/**
	 * ensures: Initializes an alien at position (x, y) that tracks a Hero
	 * 
	 * @param x      used to initialize the object's x position <br>
	 *               requires: x &ge; 0
	 * @param y      used to initialize the object's y position <br>
	 *               requires: y &ge; 0
	 * @param target the Hero for the alien to track <br>
	 *               requires: target &ne; null
	 */
	public AlienTwo(int x, int y, Object target) {
		super(x, y);
		this.velY = 2;
		this.target = target;
	} // End constructor

	/**
	 * ensures: Changes the position of the alien on platform collision
	 * 
	 * @param p the platform the object collides with <br>
	 *          requires: p &ne; null
	 */
	public void reposition(Platform p) {
		if (this.y > p.y + 28) {
			this.y = p.y + 32;
			this.velY = 0;
			return;
		}
		if (this.y < p.y - 28) {
			this.y = p.y - 32;
			this.velY = 0;
			return;
		}
		if (this.x > p.x + 28) {
			this.x = p.x + 32;
			this.velX = 0;
		}
		if (this.x < p.x - 28) {
			this.x = p.x - 32;
			this.velX = 0;
		}
	} // End reposition

	/**
	 * ensures: Updates the location of the alien
	 */
	public void update() {
		super.update();
		// chase the player
		double errorY = target.y - this.y;
		double errorX = target.x - this.x;
		double normalize = invSqrt(errorY * errorY + errorX * errorX);
		// Knockback effect
		if ((errorY * this.velY + errorX * this.velX) < 0) {
			this.velX += errorX * normalize * 0.25d;
			this.velY += errorY * normalize * 0.25d;
		} else {
			this.velX = errorX * normalize;
			this.velY = errorY * normalize;
		}
	} // End update
}
