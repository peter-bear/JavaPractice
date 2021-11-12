package objects;

import java.awt.Graphics2D;
import java.util.Random;


/**
 * General Alien class
 * @author Qingyuan Jiao, Yao Xiong
 *
 */
public abstract class MotherAlien extends GameObject
{

	private int moveDirX; // 1:Right -1:Left 
	private int moveDirY; // 1:Up -1:Down
	private int velocity;
	private int credit;
	private int dirChangeCounter = 0;
	
	public abstract void moveOnDir();
	
	/**
	 * ensures: alien's initial velocity is 2, set alien's credit
	 * @param x x position
	 * @param y y position
	 * @param length width
	 * @param height height
	 * @param credit score hero will get after kill alien
	 */
	public MotherAlien(int x, int y, int length, int height, int credit) {
		super(x, y, length, height);
		this.velocity = 2;
		this.credit = credit;
	
		this.moveDirX = (getRandomDir());
		this.moveDirY = (getRandomDir());
		
	}
	
	/**
	 * Similar to previous one
	 * @param x
	 * @param y
	 * @param length
	 * @param height
	 * @param credit
	 * @param fileAddress image Address of alien
	 */
	public MotherAlien(int x, int y, int length, int height, int credit, String fileAddress) {
		this(x,y,length, height, credit);
		super.setImageFile(fileAddress);
	}
	

	
	/**
	 * get how much the hero will get after killing alien
	 * @return
	 */
	public int getCredit() {
		return credit;
	}
	
	/**
	 * get the X direction of Alien
	 * @return moveDirX
	 */
	public int getMoveDirX() {
		return moveDirX;
	}
	
	/**
	 *  get the Y direction of Alien
	 * @return moveDirY
	 */
	public int getMoveDirY() {
		return moveDirY;
	}

	/**
	 * change X position of alien
	 */
	public void moveX() {
		alterX(getX() + moveDirX*velocity);	
		if(this.getX() > 725){
			this.alterX(715);
			moveDirX *= -1;
		}else if(this.getX() < 25) {
			this.alterX(30);
			moveDirX *= -1;
		}
		
		
	}
	
	/**
	 * change the Y postion of alien
	 */
	public void moveY() {
		alterY(getY() - moveDirY*velocity);
	}
	
	/**
	 * get random direction
	 * @return will return 0 or 1
	 */
	public int getRandomDir() {
		int ranD = new Random().nextInt(2);
		if(ranD == 0)
			return -1;
		else
			return 1;
	}
	
	/**
	 * Randomly change the direction of alien, (whether reverse X direction or Y direction)
	 */
	public void randomReverseDir() {
		if(this.getRandomDir()>0)
			this.moveDirX *= -1;
		else
			this.moveDirY *= -1;
		
	}
	
	/**
	 * Reverse Direction on alien
	 */
	public void reverseDir() {
		this.moveDirX *= -1;
		this.moveDirY *= -1;
	}
	
	/**
	 * Since hero will reverse direction, the drawOn method need to change, 
	 * <br> flip the picture
	 */
	@Override
	public void drawOn(Graphics2D g2) {
		g2.translate(getX(), getY());
		
		if(this.getMoveDirX() == 1)
			g2.drawImage(this.getImageFile(), 0, 0,this.getLength(), this.getHeight(), null);
		else
			g2.drawImage(this.getImageFile(), this.getLength(), 0,-this.getLength(), this.getHeight(), null);

		
		g2.translate(-getX(), -getY());
		
	}
	
	/**
	 * update the position of motheralien
	 */
	@Override
	public void update() {
		
		moveOnDir();
		dirChangeCounter++;
		if (dirChangeCounter == 200) {
			this.randomReverseDir();
			this.randomReverseDir();
			dirChangeCounter = 0;
		}
	}
	
	/**
	 * when alien collide with each other, they will reverse their direction
	 */
	@Override
	public void handleCollisionWithAlien(MotherAlien a) {
		if (collideWith(a)) {
			reverseDir();
			update();
		}
		
	}
	
	/**
	 * when the alien collide with hero, hero will lose one life
	 */
	@Override
	public void handleCollisionWithHero(Hero h) {
		if (collideWith(h)) {
			h.loseLife();
		}
	}
	
	/**
	 * when alien collide with plane, it will reverse the direction
	 */
	@Override
	public void handleCollisionWithPlane(Plane p) {
		
		if (collideWith(p)) {
			
			reverseDir();
			update();
		}
	}
	
	

}
