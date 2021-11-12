package mainApp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import objects.Alien2;
import objects.Alien1;
import objects.Bomb;
import objects.Bullet;
import objects.GameObject;
import objects.Hero;
import objects.MotherAlien;
import objects.Plane;



/**
 * Class: GameComponent
 * @author Qingyuan Jiao; Yao Xiong
 * Displays all game elements,
 * <br>  Deal with service between game elements, such as check collision between alien and hero
 * <br> The usage of this class
 * <br> For example
 * <pre>
 * 	GameComponent gc = new GameComponent();
 * </pre>
 *
 */
public class GameComponent extends JComponent {
	
	private ArrayList<Plane> planes;
	private ArrayList<Hero> heros;
	private ArrayList<Bullet> bullets;
	private ArrayList<MotherAlien> aliens;
	private ArrayList<Bomb> bombs;;
	
	private boolean isLevelClear;
	private boolean isGameOver;
	private Image bgimage;
	
	public GameComponent(){
		this.isLevelClear = false;
		this.isGameOver = false;
		this.planes = new ArrayList<Plane>();
		this.heros = new ArrayList<Hero>();
		this.bullets = new ArrayList<Bullet>();
		this.aliens = new ArrayList<MotherAlien>();
		this.bombs = new ArrayList<Bomb>();
		
		try {
			this.bgimage = ImageIO.read(new File("imgSources/bg.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Background Image Not Find");
		}
		
	}

	
	
	/**
	 * Override JComponent's paint method
	 * <br> ensures: if the game is over, show gameOver page 
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
	
		Graphics2D g2 = (Graphics2D) g;
		
		if (this.isGameOver) {
			this.drawGameOver(g2);
			
		} else {
			g2.drawImage(this.bgimage, 0, 0,800,800, null);
			this.drawPlanes(g2);
			this.drawAllObjects(g2);
			
		}
		
		
		
	}
	
	/**
	 * draw game over page
	 * @param g2
	 */
	public void drawGameOver(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 100));
		g2.drawString("Game Over", 130, 350);
		g2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 35));
		g2.drawString("Press space to restart", 200, 400);
	}
	

	
	/**
	 * draw all game objects
	 * @param g2
	 */
	public void drawAllObjects(Graphics2D g2) {
		for (Bomb bomb: this.bombs) {
			bomb.drawOn(g2);
		}
		
		for (MotherAlien alien: this.aliens) {
			alien.drawOn(g2);
		
			
		}
		
		for (Hero hero: this.heros) {
			hero.drawOn(g2);
		}
		
		for (Bullet bullet: this.bullets) {
			bullet.drawOn(g2);
		}
		
	}
	
	/**
	 * ensures: Add Bullet into bullet list 
	 * @param x x position of the bullet
	 * @param y y position of the bullet
	 * @param facing the direction of the bullet
	 */
	public void addBullet(int x, int y, int facing) {
		this.bullets.add(new Bullet(x, y, facing, heros.get(0)));
	}
	
	/**
	 * ensures: return the number of bullet
	 * @return number of bullet in bullet list
	 */
	public int getBulletNum() {
		return this.bullets.size();
	}
	
	/**
	 * ensures: add hero into hero list
	 * @param x x position of the hero
	 * @param y y position of the hero
	 * @param length the width of the hero
	 * @param height the height of the hero
	 * @param fileAddress the hero's picture address
	 */
	public void addHero(int x, int y, int length, int height, String fileAddress) {
		this.heros.add(new Hero(x, y, length, height, fileAddress));
	}
	
	/**
	 * ensures: get specific hero according to index
	 * @param i index
	 * @return the specific hero 
	 */
	public Hero getHero(int i) {
		return this.heros.get(i);
	}
	
	/**
	 * ensures: add bomb into bomb list
	 * @param x x position of the bomb 
	 * @param y y position of the bomb
	 * @param radius the radius of the bomb
	 * @param fileAddress the file address of bomb's image
	 */
	public void addBomb(int x, int y, int radius, String fileAddress) {
		this.bombs.add(new Bomb(x,y,radius,fileAddress));
	}
	
	/**
	 * ensures: Add alien1 into the alien list
	 * @param x x position of the alien 
	 * @param y y position of the alien
	 * @param length the width of the alien
	 * @param height the height of the alien
	 * @param fileAddress the file address of alien's image
	 */
	public void addAlien1(int x, int y, int length, int height, String fileAddress) {
		this.aliens.add(new Alien1(x, y, length, height, fileAddress));
	}
	
	/**
	 * ensures: Add alien2 into the alien list
	 * @param x x position of the alien 
	 * @param y y position of the alien
	 * @param length the width of the alien
	 * @param height the height of the alien
	 * @param fileAddress the file address of alien's image
	 */
	public void addAlien2(int x, int y, int length, int height, String fileAddress) {
		this.aliens.add(new Alien2(x, y, length, height, fileAddress));
	}
	
	/**
	 * ensures: Add plane into the plane list
	 * @param x x position of the plane 
	 * @param y y position of the plane
	 * @param length the width of the plane
	 * @param height the height of the plane
	 * @param fileAddress the file address of alien's image
	 */
	public void addPlane(int x, int y, int length, int height, String fileAddress) {
		this.planes.add(new Plane(x, y,length, height, fileAddress));
	}
	
	/**
	 * ensures draw planes on graphics2d
	 * @param g2 graphics2d
	 */
	public void drawPlanes(Graphics2D g2) {
		for (int i = 0; i < this.planes.size(); i++) {
			this.planes.get(i).drawOn(g2);
		}
	}
	
	/**
	 * return the score store in the hero class
	 * @return hero's score
	 */
	public int getScore() {
		return this.getHero(0).getScore();
	}
	
	/**
	 * set hero's score
	 * @param score score
	 */
	public void setScore(int score) {
		this.getHero(0).setScore(score);
	}
	
	/**
	 * get hero's life
	 * @return hero's life
	 */
	public int getHeroLife() {
		return this.heros.get(0).getLife();
	}
	
	/**
	 * get the list of plane
	 * @return plane list
	 */
	private ArrayList<Plane> getPlanes() {
		return this.planes;
	}

	/**
	 * set the level is clear
	 * @param x boolean parameter
	 */
	public void setLevelClear(boolean x) {
		this.isLevelClear = x;
	}
	
	/**
	 * check whether the level is clear in this game
	 * @return isLevelClear
	 */
	public boolean isLevelClear() {
		return this.isLevelClear;
	}
	
	/**
	 * set the game is over
	 * @param x boolean
	 */
	public void setGameOver(boolean x) {
		this.isGameOver = x;
	}
	
	/**
	 * check whether the game is over
	 * @return isGameOver
	 */
	public boolean isGameOver() {
		return this.isGameOver;
	} 
	
	
	/**
	 * returns if the gameobject objs is on any of the planes
	 * @param objs
	 * @return
	 */
	public boolean isOnPlane(GameObject objs) {
		
		for (int i = 0; i < getPlanes().size(); i++) {
			if (objs.getY() + objs.getHeight() == getPlanes().get(i).getY()
					&& objs.getX() + objs.getLength() >= getPlanes().get(i).getX()
					&& objs.getX() <= getPlanes().get(i).getX() + getPlanes().get(i).getLength()) {
				return true;
			}
				
		}
		
		return false;
	}
	
	
	/**
	 * updates all game changes, including collision and position update according to velocity
	 */
	public void updateAll() {
	
		//handling collisions
		for (MotherAlien a: aliens) {
			a.handleCollisionWithHero(heros.get(0));
			
			for (Plane p: planes) {
				a.handleCollisionWithPlane(p);
			}
			
			for (Bullet b: bullets) {
				b.handleCollisionWithAlien(a);
				
			}
			
			for(MotherAlien a2: aliens) {
				if(!a2.equals(a)) {
					a.handleCollisionWithAlien(a2);
				}
			}
			
		}
		
		for (Bomb b: bombs) {
			b.handleCollisionWithHero(heros.get(0));
		}
		
		for(Bullet b:bullets) {
			for (Plane p: planes) {
				b.handleCollisionWithPlane(p);
			}
		}
		
		if(!isOnPlane(heros.get(0))) {
			
			for (Plane p: planes) {
				heros.get(0).handleCollisionWithPlane(p);
			
			}
		} else {
			//resets the velocity to 5
			heros.get(0).resetVelocity();
		}
		
		
		//updating positions
		ArrayList<GameObject> objects = new ArrayList<>();
		objects.addAll(heros);
		objects.addAll(aliens);
		objects.addAll(bombs);
		objects.addAll(bullets);
		
		for (GameObject object: objects) {
			if (object.getRemoval()) {
				aliens.remove(object);
				heros.remove(object);
				bombs.remove(object);
				bullets.remove(object);
			}
			object.update();
		}
		
		if (this.bombs.isEmpty()) {
			this.setLevelClear(true);
		}
		
		
	}
	 
	
}
