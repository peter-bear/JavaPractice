package StudyFundation;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.Vector;

public class Tank{
	
	private Vector<Bullet> bullets = new Vector<>();
	private int x;
	private int y;
	private int direction=1;
	private int speed =5;
	private boolean isAlive = true;
	private int BulletNum = 3;
	private int RightEdge = 900;
	private int DownEdge = 600;
	private int blood = 5;

	

	Tank(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	
	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public int getBulletNum() {
		return BulletNum;
	}
	public void setBulletNum(int bulletNum) {
		BulletNum = bulletNum;
	}
	
	
	
	public Vector<Bullet> getBullets() {
		return bullets;
	}
	public void setBullets(Vector<Bullet> bullets) {
		this.bullets = bullets;
	}
	
	public boolean OutRange() {
		return (x > RightEdge && direction == 2) || (x <=this.speed && direction ==4)
				|| (y <=this.speed && direction == 1) || (y >DownEdge && direction == 3);
	}
	
	
	public void shoot() {
		Bullet bullet=null;
		switch (this.getDirection()) {
		case 1:
			bullet = new Bullet(this.getX()+10+5+15, this.getY()-5, 1);
			break;
		case 2:
			bullet = new Bullet(this.getX()+60+5, this.getY()+10+5+15, 2);
			break;
		case 3:
			bullet = new Bullet(this.getX()+10+5+15, this.getY()+60+5, 3);
			break;
		case 4:
			bullet = new Bullet(this.getX()-5, this.getY()+10+5+15, 4);
			break;
		default:
			break;
		}
		if(bullets.size() <BulletNum) {
			bullets.add(bullet);
			Thread thread = new Thread(bullet);
			thread.start();
		}

	}
	
//	private int wheel_width;
//	private int wheel_height;
//	private int body_width;
//	private int body_circle_radius;
//	private int gun_len;
	
//	public void setWheel(int width, int height) {
//		wheel_width = width;
//		wheel_height = height;
//	}
	
//	public void 

	
}
