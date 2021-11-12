package StudyFundation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class TankPanel extends Panel implements KeyListener, Runnable{
	private MyTank hero = null;
	private int EnemyNum = 4;
	private int score =0;
	
	private Vector<EnemyTank> enemys = new Vector<>(); 
	
	TankPanel(){
		hero = new MyTank(600, 600);
		int x =100;
		int y= 100;
		for(int i=0;i<EnemyNum;i++) {
			EnemyTank enemytank = new EnemyTank(x, y);
			enemys.add(enemytank);
			new Thread(enemytank).start();
			
			x += 100;
		}
		
	}
	
	
	
	@Override
	public void update(Graphics arg0) {
		paint(arg0);
	}



	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillRect(0, 0, 1000, 700);
		DrawBoard(g);
		DrawTank(hero, g, 0, hero.getDirection());
		for(int i=0;i<enemys.size();i++) {
			EnemyTank et = enemys.get(i);
			DrawTank(et, g, 1, et.getDirection());
			if(!enemys.get(i).getBullets().isEmpty()) {
				DrawBullets(g, enemys.get(i).getBullets());
			}
			
		}

	
		if(!hero.getBullets().isEmpty()) {
			DrawBullets(g, hero.getBullets());
		}
		
	
		
//		DrawTank(new MyTank(70, 70), g, 1, 1);
		
	}
	
	public void DrawBoard(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(1000, 0, 300, 700);
		g.setFont(new Font("宋体",Font.BOLD, 28));
		g.setColor(Color.BLACK);
		g.drawString("坦克大战", 1100, 50);
		
		Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/miku.gif"));
		g.drawImage(image, 1000, 150, 300, 360, this);
		
		g.drawString("击毁敌人坦克数："+score, 1000, 100);
		if(hero.getBlood()>=0)
			g.drawString("你的血量："+hero.getBlood(), 1050, 140);
		else {
			g.drawString("你的血量：0", 1050, 140);
		}
		
	}
	
	
	/**
	 * 
	 * @param tank the tank
	 * @param g graphics
	 * @param type：Color Type
	 * @param direction 1:UP 2:RIGHT 3:DOWN 4:LEFT
	 */
	public void DrawTank(Tank tank, Graphics g, int type, int direction) {
		switch (type) {
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			break;

		default:
			break;
		}
		
		
		switch (direction) {
		case 1:
			g.fill3DRect(tank.getX(), tank.getY(), 10, 60,true);
			g.fill3DRect(tank.getX()+10+40, tank.getY(), 10, 60,true);
			g.fill3DRect(tank.getX()+10, tank.getY()+10, 40, 40,false);
			g.fillOval(tank.getX()+10+5, tank.getY()+10+5, 30,30);
			g.drawLine(tank.getX()+10+5+15, tank.getY()-5, tank.getX()+10+5+15, tank.getY()+10+5);
			break;
		case 2:
			g.fill3DRect(tank.getX(), tank.getY(), 60, 10,true);
			g.fill3DRect(tank.getX(), tank.getY()+10+40, 60, 10,true);
			g.fill3DRect(tank.getX()+10, tank.getY()+10, 40, 40,false);
			g.fillOval(tank.getX()+10+5, tank.getY()+10+5, 30,30);
			g.drawLine(tank.getX()+45, tank.getY()+10+5+15, tank.getX()+60+5, tank.getY()+10+5+15);
			break;
		case 3:
			g.fill3DRect(tank.getX(), tank.getY(), 10, 60,true);
			g.fill3DRect(tank.getX()+10+40, tank.getY(), 10, 60,true);
			g.fill3DRect(tank.getX()+10, tank.getY()+10, 40, 40,false);
			g.fillOval(tank.getX()+10+5, tank.getY()+10+5, 30,30);
			g.drawLine(tank.getX()+10+5+15, tank.getY()+45, tank.getX()+10+5+15, tank.getY()+60+5);
			break;
		case 4:
			g.fill3DRect(tank.getX(), tank.getY(), 60, 10,true);
			g.fill3DRect(tank.getX(), tank.getY()+10+40, 60, 10,true);
			g.fill3DRect(tank.getX()+10, tank.getY()+10, 40, 40,false);
			g.fillOval(tank.getX()+10+5, tank.getY()+10+5, 30,30);
			g.drawLine(tank.getX()-5, tank.getY()+10+5+15, tank.getX()+10+5, tank.getY()+10+5+15);
			break;

		default:
			break;
		}
	}
	
	/**
	 * check whether the enemy can shoot
	 * @param enemys
	 */
	public void CheckShoot(Vector<EnemyTank> enemys){
		for(int i=0;i<enemys.size();i++) {
			EnemyTank enemy = enemys.get(i);
			if(Math.abs(enemy.getY() -hero.getY()) <300 && Math.abs(enemy.getX() -hero.getX()) <100) {
				enemy.shoot();
			}else if(Math.abs(enemy.getY() -hero.getY()) <100 && Math.abs(enemy.getX() -hero.getX()) <300) {
				enemy.shoot();
			}
			
				
			
		}
	}
	
	/**
	 * 己方坦克子弹击中地方坦克
	 * @param bullets 
	 * @param enemys 
	 */
	public void CheckHitted(Vector<Bullet> bullets, Vector<EnemyTank> enemys) {
		if(enemys.size() == 0) {
			TankUtil NewWindow = new TankUtil();
			NewWindow.ShowMessage("You Win");
			try {
				Thread.sleep(1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<bullets.size();i++) {
			for(int j=0;j<enemys.size();j++) {
//				System.out.println(bullets.size());
				int enemy_x = enemys.get(j).getX();
				int enemy_y = enemys.get(j).getY();
				int enemy_blood = enemys.get(j).getBlood();
				int bt_x = bullets.get(i).getX();
				int bt_y = bullets.get(i).getY();
				if(bt_x >= enemy_x && bt_x <= enemy_x +60 && bt_y >= enemy_y && bt_y <= enemy_y +60 ) {
					bullets.get(i).setAlive(false);
					enemys.get(j).setBlood(--enemy_blood);
					
					bullets.remove(i);
					return;
				}
				
				
			}
		}
	}
	
	/**
	 * check the enemy's blood
	 * @param enemy
	 */
	public void CheckBlood(Vector<EnemyTank> enemys) {
		for(int i=0;i<enemys.size();i++) {
			if(enemys.get(i).getBlood() == 0) {
				enemys.get(i).setAlive(false);
				enemys.remove(i);
				score++;
				return;
			}
		}
	}
	
	
	
	
	//敌方坦克击中己方坦克
	
	public void CheckHitted(Vector<EnemyTank> enemys,  MyTank hero) {
		
		for(int j=0;j<enemys.size();j++) {
//			System.out.println(enemys.get(j).getBullets().size());
			for(int i=0;i<enemys.get(j).getBullets().size();i++) {
				int hero_x = hero.getX();
				int hero_y = hero.getY();
				int bt_x = enemys.get(j).getBullets().get(i).getX();
				int bt_y = enemys.get(j).getBullets().get(i).getY();
				if(bt_x >= hero_x && bt_x <= hero_x +60 && bt_y >= hero_y && bt_y <= hero_y +60 ) {
					enemys.get(j).getBullets().get(i).setAlive(false);
					enemys.get(j).getBullets().remove(i);
					int blood = hero.getBlood()-1;
					hero.setBlood(blood);
					if(blood <= 0) {
						TankUtil NewWindow = new TankUtil();
						NewWindow.ShowMessage("Game Over");
						enemys.clear();
						try {
							
							Thread.sleep(1000000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
					
				
			}
		}
		
	}
	
	
	/**
	 * 画出子弹
	 * @param g graph
	 * @param bullets
	 */
	public void DrawBullets(Graphics g, Vector<Bullet> bullets) {
		g.setColor(Color.CYAN);
		for(int i=0;i<bullets.size();i++) {
			if(bullets.get(i).OutRange()) {
				bullets.remove(i);
				continue;
			}
				
			g.fill3DRect(bullets.get(i).getX(), bullets.get(i).getY(), 2, 2, true);
			
		}
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_A) {
			hero.setDirection(4);
			if(!hero.OutRange())
				hero.setX(hero.getX()-hero.getSpeed());
			
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			hero.setDirection(2);
			if(!hero.OutRange())
				hero.setX(hero.getX()+hero.getSpeed());
			
		}else if(e.getKeyCode() == KeyEvent.VK_W) {
			hero.setDirection(1);
			if(!hero.OutRange())
				hero.setY(hero.getY()-hero.getSpeed());
			
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			hero.setDirection(3);
			if(!hero.OutRange())
				hero.setY(hero.getY()+hero.getSpeed());
			
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			hero.shoot();
		}
//		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * main thread 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			repaint();
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			CheckHitted(hero.getBullets(), enemys);
			CheckHitted(enemys, hero);
			CheckShoot(enemys);
			CheckBlood(enemys);
		}
		
	}
	
	
	
}
