package StudyFundation;

import java.awt.Graphics;

public class Bullet implements Runnable{
	private int x;
	private int y;
	private int direction;
	private boolean isAlive;
	private int speed=6;
	Bullet(int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.direction = dir;
		isAlive = true;
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

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
//	public void DrawBullet(Graphics g) {
//		g.fill3DRect(this.getX(), this.getY(), 2, 2, true);
//	}

	public boolean OutRange() {
		return x > 1000 || x <0 || y <0 || y >700;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isAlive) {
			
//			System.out.printf("X£º%d Y: %d\n",x,y);
			switch (direction) {
			case 1:
				y -= speed;
				break;
			case 2:
				x += speed;
				break;
			case 3:
				y += speed;
				break;
			case 4:
				x -= speed;
				break;

			default:
				break;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(OutRange())
				this.setAlive(false);
			
		}
		
	}

}
