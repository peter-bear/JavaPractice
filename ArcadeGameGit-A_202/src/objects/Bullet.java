package objects;
/**
 * Bullet class
 * @author Qingyuan Jiao; Yao Xiong
 *	<pre>
 *		Bullet b = new Bullet(0,0, 1, h);
 *	</pre>
 */
public class Bullet extends GameObject {
	private int facing; //1:right -1:left
	private Hero owner;
	private int velocity;
	
	/**
	 * ensures: bullet's width is 10 and height is 5
	 * <br> bullet's owner is a hero. The hero can shoot 5 bullets on one screen
	 * <br> bullet's image file is also a constant
	 * @param x x position of bullet
	 * @param y y position of bullet
	 * @param i the facing direction of bullet
	 * @param o the owner
	 */
	public Bullet(int x, int y, int i, Hero o) {
		super(x, y, 10,5, "imgSources/bullet.png");
		this.facing = i;
		this.owner = o;
		velocity = 8;
	}
	
	/**
	 * movement of bullet along its direction 
	 */
	public void fly() {
		this.alterX(this.getX() + this.velocity*this.facing);
	}

	/**
	 * update the postion of bullet
	 */
	@Override
	public void update() {
		this.fly();
	}
	
	/**
	 * handle the collision between bullet and alien
	 * <br>alien will be delete
	 */
	@Override
	public void handleCollisionWithAlien(MotherAlien a) {
		if (collideWith(a)) {
			if(!a.getRemoval())
				owner.setScore(owner.getScore()+a.getCredit());
			a.setRemoval(true);
			
		}
		
	}
	
	@Override
	public void handleCollisionWithHero(Hero h) {
		return;
	}
	
	/**
	 * if bullet collide with plane, it will be deleted
	 */
	@Override
	public void handleCollisionWithPlane(Plane p) {
		// TODO Auto-generated method stub
		if (collideWith(p)) {
			this.setRemoval(true);
			
		}
	}
	
}
