
package objects;

/**
 * Platforms class
 * @author Qingyuan Jiao; Yao Xiong;
 * <pre>
 * 	Plane p = new Plane(0,0,50,50,"IMG//plane_pic.png")
 * </pre>
 */
public class Plane extends GameObject {
	
	/**
	 * ensures: the constructor of plane class
	 * @param x x position
	 * @param y y position
	 * @param length length / width of the plane
	 * @param height height of the plane
	 * @param fileAddress image address of plane
	 */
	public Plane(int x, int y, int length, int height, String fileAddress) {
		super(x, y, length, height,fileAddress);
	}

	
	@Override
	public void handleCollisionWithHero(Hero h) {
			
		return;
	}
	
	@Override
	public void handleCollisionWithAlien(MotherAlien a) {
		return;
	}
	
	@Override
	public void handleCollisionWithPlane(Plane p) {
		return;
	}

	@Override
	public void update() {
		return;
	}
	
	
}
