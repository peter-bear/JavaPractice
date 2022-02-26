package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * Class Object
 * 
 * @author A_105 <br>
 *         Purpose: Connects to all objects used in a Level: Enemy (AlienOne and
 *         AlienTwo), Platform, Bomb, and Hero <br>
 *         Restrictions: Not designed to be called by itself, must create a new
 *         child object <br>
 *         For example:
 * 
 *         <pre>
 * Object o = new {child object}(x, y);
 *         </pre>
 */
public class Object extends JComponent {

	private static final long serialVersionUID = 1L;
	protected double x, y, velX, velY;
	private Color color;
	protected Rectangle2D collisionShape;
	protected boolean isDead;

	/**
	 * ensures: Initializes a new object
	 * 
	 * @param x     used to initialize the x position of the object <br>
	 *              requires: x &ge; 0
	 * @param y     used to initialize the y position of the object <br>
	 *              requires: y &ge; 0
	 * @param color used to initialize the color of the object <br>
	 *              requires: color &ne; null
	 */
	public Object(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.velX = 0;
		this.velY = 0;
		this.collisionShape = new Rectangle2D.Double(x, y, 32, 32);
		this.color = color;
		this.isDead = false;
	} // End constructor

	/**
	 * ensures: Updates the object's position if it is not dead
	 */
	public void update() {
		if (!isDead) {
			this.x += velX;
			this.y += velY;
			collisionShape = new Rectangle2D.Double(this.x, this.y, 32, 32);
		}
	} // End update

	/**
	 * ensures: Draws the object
	 * 
	 * @param g used to draw the object
	 */
	public void drawOn(Graphics2D g) {
		// Avoid having to untranslate by mutating a copy of the graphics content
		g = (Graphics2D) g.create();
		g.setColor(this.color);
		g.fill(collisionShape);
	} // End drawOn

	/**
	 * ensures: Determines if two objects are colliding with each other
	 * 
	 * @param obj used to determine collision <br>
	 *            requires: obj &ne; null
	 * @return true if the object is colliding with the parameter object
	 */
	public boolean collidesWith(Object obj) {
		return this.collisionShape.intersects(obj.collisionShape);
	} // End collidesWith

	/**
	 * ensures: Approximates the inverse square root of a number
	 * 
	 * @param num used to take the inverse square root <br>
	 *            requires: num &ge; 0
	 * @return the inverse square root of num
	 */
	static double invSqrt(double num) {
		double halfNum = 0.5d * num;
		double threeHalves = 1.5d;
		// evil bit hack
		long i = Double.doubleToLongBits(num);
		// This works for some reason
		i = 0x5fe6ec85e7de30daL - (i >> 1);
		num = Double.longBitsToDouble(i);
		// Newtonian iterations
		num *= (threeHalves - halfNum * num * num);
		num *= (threeHalves - halfNum * num * num);
		return num;
	} // End invSqrt

}
