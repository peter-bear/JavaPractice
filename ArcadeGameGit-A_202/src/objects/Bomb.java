package objects;


/**
 * Bomb class 
 * @author Yao Xiong
 * <pre>
 * 	Bomb b = new Bomb(10,10, 20, "img//bomb_pic.png");
 * </pre>
 *
 */
public class Bomb extends GameObject{
	
	/**
	 * ensures: The constructor of bomb class
	 * @param x x position of bomb
	 * @param y y position of bomb 
	 * @param the radius of bomb
	 * @param fileAddress image address of bomb 
	 */
	public Bomb(int x, int y, int radius, String fileAddress) {
		super(x, y, radius, radius, fileAddress);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		return;
	}
	
	
	@Override
	public void handleCollisionWithHero(Hero h) {
		if (collideWith(h)) {
			this.setRemoval(true);
			h.setScore(h.getScore()+10);
		}
	}

	@Override
	public void handleCollisionWithPlane(Plane p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCollisionWithAlien(MotherAlien a) {
		// TODO Auto-generated method stub
		
	}
}
