package mainApp;

/**
 * Class AlienOne
 * 
 * @author A_105 <br>
 *         Purpose: Creates an Alien that moves in a random direction at a
 *         random speed <br>
 *         Restrictions: None <br>
 *         For example:
 * 
 *         <pre>
 *         Object a1 = new AlienOne(x, y);
 *         </pre>
 */
public class AlienOne extends Enemy {

	private static final long serialVersionUID = 1L;
	private double xComponent, yComponent;

	/**
	 * ensures: Initializes an alien at position (x, y) with a random velocity
	 * 
	 * @param x used to initialize the object's x position <br>
	 *          requires: x &ge; 0
	 * @param y used to initialize the object's y position <br>
	 *          requires: y &ge; 0
	 */
	public AlienOne(int x, int y) {
		super(x, y);
		this.xComponent = Math.random() * 1.5 + 1;
		this.yComponent = Math.random() * 1.5 + 1;
		this.velX = xComponent;
		this.velY = yComponent;
	} // End constructor

	/**
	 * ensures: Changes the position of the alien on platform collision
	 * 
	 * @param p the platform the object collides with <br>
	 *          requires: p &ne; null
	 */
	public void reposition(Platform p) {
		if (this.y > p.y + 28.9) {
			this.y = p.y + 32;
			if (!yChanged) {
				this.yComponent = -yComponent;
				this.velY = -velY;
			}
			this.yChanged = true;
			return;
		}
		if (this.y < p.y - 28.9) {
			this.y = p.y - 32;
			if (!yChanged) {
				this.yComponent = -yComponent;
				this.velY = -velY;
			}
			this.yChanged = true;
			return;
		}
		if (this.x > p.x + 28.9) {
			this.x = p.x + 32;
			if (!xChanged) {
				this.xComponent = -xComponent;
				this.velX = xComponent;
			}
			this.xChanged = true;
			return;
		}
		if (this.x < p.x - 28.9 && !xChanged) {
			this.x = p.x - 32;
			if (!xChanged) {
				this.xComponent = -xComponent;
				this.velX = xComponent;
			}
			this.xChanged = true;
		}
	} // End reposition

	/**
	 * ensures: Updates the location of the alien
	 */
	public void update() {
		super.update();
		// Knockback effect
		if ((yComponent * this.velY + xComponent * this.velX) < 0) {
			this.velX += xComponent * .075d;
			this.velY += yComponent * .075d;
		} else {
			this.velX = xComponent;
			this.velY = yComponent;
		}
	} // End update
}
