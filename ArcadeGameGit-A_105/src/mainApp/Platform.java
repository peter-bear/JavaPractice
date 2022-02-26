package mainApp;

import java.awt.Color;

/**
 * Class Platform
 * 
 * @author A_105 <br>
 *         Purpose: Creates a Platform tile in Level <br>
 *         Restrictions: None <br>
 *         For example:
 * 
 *         <pre>
 *         Object p = new Platform(x, y);
 *         </pre>
 */
public class Platform extends Object {

	private static final long serialVersionUID = 1L;

	/**
	 * ensures: Initializes a hero at position (x, y)
	 * 
	 * @param x used to initialize the object's x position <br>
	 *          requires: x &ge; 0
	 * @param y used to initialize the object's y position <br>
	 *          requires: y &ge; 0
	 */
	public Platform(int x, int y) {
		super(x, y, Color.RED);
	} // End constructor
}
