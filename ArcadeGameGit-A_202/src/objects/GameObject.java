package objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class GameObject
 * Collidable class. All game elements that can collide with other elements inherits this class
 * @author Qingyuan Jiao
 * <pre>
 * 	GameObject go =  new GameObject(0,0,50,50,"img//game.png");
 * </pre>
 *
 */
public abstract class GameObject {
	private int xPos;
	private int yPos;
	private int length;
	private int height;
	private boolean toBeRemoved;
	private Image imageFile;
	
	public abstract void update();
	public abstract void handleCollisionWithHero(Hero h);
	public abstract void handleCollisionWithAlien(MotherAlien a);
	public abstract void handleCollisionWithPlane(Plane p);
	
	/**
	 * ensures: the constructor of GameObject
	 * @param x x position
	 * @param y y position
	 * @param length width of the game object
	 * @param height height of the game object
	 */
	public GameObject(int x, int y, int length, int height) {
		this.xPos = x;
		this.yPos = y;
		this.length = length;
		this.height = height;
		imageFile = null;
	}
	
	/**
	 * similar to previous constructor
	 * @param x
	 * @param y
	 * @param length
	 * @param height
	 * @param fileAddress imagFile address of the game object
	 */
	public GameObject(int x, int y, int length, int height, String fileAddress) {
		this.xPos = x;
		this.yPos = y;
		this.length = length;
		this.height = height;
		try {
			imageFile = ImageIO.read(new File(fileAddress));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * return the image class of this game object
	 * @return
	 */
	public Image getImageFile() {
		return imageFile;
	}
	
	/**
	 * Set the image address of game object
	 * @param imageFile
	 */
	public void setImageFile(String imageFile) {
		try {
			this.imageFile = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * get x position
	 * @return x position
	 */
	public int getX() {
		return xPos;
		
	}
	
	/**
	 * get y position
	 * @return y position
	 */
	public int getY() {
		return yPos;
	}
	
	/**
	 * change x position
	 * @param x int
	 */
	public void alterX(int x) {
		xPos = x;
	}
	
	/**
	 * change y position
	 * @param y int
	 */
	public void alterY(int y) {
		yPos = y;
	}
	
	/**
	 * change height
	 * @param h int 
	 */
	public void setHeight(int h) {
		this.height = h;
	}
	
	/**
	 * change the width 
	 * @param l int
	 */
	public void setLength(int l) {
		this.length = l;
	}
	
	/**
	 * get length / width of the game object
	 * @return length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * get height of the game object
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * ensures: get whether this object can be removed
	 * @return
	 */
	public boolean getRemoval() {
		return this.toBeRemoved;
	}
	
	/**
	 * ensures: set the gameobject should be removed or not
	 * @param x boolean
	 */
	public void setRemoval(boolean x) {
		toBeRemoved = x;
	}
	
	/**
	 * ensures: used to check collision between two GameObjects
	 * @param a the other GameObject
	 * @return whether they are collided with each other
	 */
	public boolean collideWith(GameObject a) {

		//right side collision
		if(this.getX()<=a.getX()&& (this.getX()+this.getLength())>=a.getX()){
			if(this.getY()<=a.getY() && (this.getY()+this.getHeight())>=a.getY()) {
				return true;
			}else if(this.getY()>=a.getY() && (a.getY()+a.getHeight())>=this.getY()) {
				return true;
			}
		}
		//left side collision
		else if(this.getX()>=a.getX() && (a.getX()+a.getLength())>=this.getX()) {
			if(this.getY()<=a.getY() && (this.getY()+this.getHeight())>=a.getY()) {
				return true;
			}else if(this.getY()>=a.getY() && (a.getY()+a.getHeight())>=this.getY()) {
				return true;
			}
		}

		
		return false;
	}
	
	/**
	 * ensures: draw the GameObject on graph g2
	 * @param g2 graphics2D 
	 */
	public void drawOn(Graphics2D g2) {
		g2.translate(getX(), getY());
		if(this.getImageFile()!=null)
			g2.drawImage(this.getImageFile(), 0, 0,this.length, this.height, null);
		else 
			g2.drawRect(0, 0, this.length, this.height);
		
		g2.translate(-getX(), -getY());
	}


}
