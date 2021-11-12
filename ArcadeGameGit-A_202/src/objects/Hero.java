package objects;




/**
 * Hero class
 * @author Qingyuan Jiao; Yao Xiong
 * <br> For Example
 * <pre>
 *	Hero h = new Hero(0,0,50,50, "img//hero_pic.png");
 * </pre>
 */
public class Hero extends GameObject{
	
	private int facing; // 1:right -1:left
	private int life;
	private int verticalVelocity;
	private int horizonVelocity;
	private int score;
	private int initPosX;
	private int initPosY;
	
	private boolean ifCollideWithPlane;
	
	/**
	 * ensures: the constructor of hero class
	 * <br> initialize hero's direction to right, life to 3, and score to 0
	 * @param x x position of hero
	 * @param y y position of hero
	 * @param length length / width of the hero 
	 * @param height height of hero
	 * @param fileAddress hero's image file address
	 */
	public Hero(int x, int y, int length, int height, String fileAddress) {
		super(x, y, length, height,fileAddress);
		
		this.verticalVelocity = 5;
		this.horizonVelocity = 5;
		
		this.initPosX = x;
		this.initPosY = y;
		this.facing = 1;
		this.life = 3;
		this.score = 0;

	}
	

	/**
	 * change the hero's facing direction
	 * <br> Restriction: the direction could only be 1 or -1
	 * @param i 
	 */
	public void changeFacing(int i) {
		this.facing = i;
	}
	
	/**
	 * get the direction of hero
	 * @return facing direction
	 */
	public int getFacing() {
		return this.facing;
	}
	
	
	// notes below are hypothetical code for preventing character
	// from moving too far to the right or left
	public void move() {
		this.alterX(this.getX() + horizonVelocity*this.getFacing());
		
		if(this.getX() > 725){
			this.alterX(715);
		
		}else if(this.getX() < 25) {
			this.alterX(30);
		}
			
		
	}
	
	/**
	 * make the hero move up
	 */
	public void moveUp() {
		this.alterY(this.getY() - 2*this.verticalVelocity);
	}
	
	/**
	 * make the hero fall down, the fall velocity is constant: 5
	 */
	public void fall() {
		this.alterY(this.getY() + 5);
		
	}
	
	/**
	 * use to check whether the hero is collide with plane
	 * @return ifCollideWithPlane
	 */
	public boolean ifCollideWithPlane() {
		return this.ifCollideWithPlane;
	}
	
	/**
	 * get the life number of the hero
	 * @return life number
	 */
	public int getLife() {
		return this.life;
	}
	
	/**
	 * when hero collide with alien, hero will lose one life
	 */
	public void loseLife() {
		this.life--;
		this.alterX(this.initPosX);
		this.alterY(this.initPosY);
	}
	
	/**
	 * reset hero's velocity after colliding with plane
	 */
	public void resetVelocity() {
		this.verticalVelocity = 5;
	}
	
	/**
	 * get hero's score
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * set hero's score
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub	
	
	}

	@Override
	public void handleCollisionWithHero(Hero h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCollisionWithAlien(MotherAlien a) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * if hero collide with plane, hero will fall down
	 */
	@Override
	public void handleCollisionWithPlane(Plane p) {
		// TODO Auto-generated method stub
		
		if(collideWith(p)) {
			verticalVelocity = 0;
			fall();
			ifCollideWithPlane = false;
			
		} 
		
	}

	
}
