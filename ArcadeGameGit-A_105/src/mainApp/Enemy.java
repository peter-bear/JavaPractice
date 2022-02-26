package mainApp;

import java.awt.geom.Rectangle2D;

import java.awt.Color;

/**
 * Class Enemy
 * 
 * @author A_105 <br>
 *         Purpose: Creates an Enemy object in Level <br>
 *         Restrictions: Not designed to be called by itself, must initialize
 *         from AlienOne or AlienTwo <br>
 *         For example:
 * 
 *         <pre>
 *         Object e = new Enemy(x, y);
 *         </pre>
 */
public abstract class Enemy extends Object {

	private static final long serialVersionUID = 1L;
	protected boolean xChanged;
	protected boolean yChanged;

	/**
	 * ensures: Initializes an enemy at position (x, y)
	 * 
	 * @param x used to initialize the object's x position <br>
	 *          requires: x &ge; 0
	 * @param y used to initialize the object's y position <br>
	 *          requires: y &ge; 0
	 */
	public Enemy(int x, int y) {
		super(x, y, Color.BLUE);
		resetCollision();
	} // End constructor

	public void resetCollision() {
		this.xChanged = false;
		this.yChanged = false;
	} // End resetCollision

	/**
	 * ensures: Removes the enemy after it has been killed by the hero
	 */
	public void die() {
		this.isDead = true;
		this.collisionShape = new Rectangle2D.Double();
	} // End die

	/**
	 * ensures: Adds a knockback effect on collision with hero
	 * 
	 * @param xVel the x velocity after collision
	 * @param yVel the y velocity after collision
	 */
	public void knockBack(double xVel, double yVel) {
		this.velX = xVel;
		this.velY = yVel;
	} // End knockBack

	/**
	 * ensures: Changes the position of the enemy on platform collision
	 * 
	 * @param p the platform the object collides with <br>
	 *          requires: p &ne; null
	 */
	public abstract void reposition(Platform p);
}
