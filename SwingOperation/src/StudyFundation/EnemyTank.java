package StudyFundation;


public class EnemyTank extends Tank implements Runnable{
	
	
	EnemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		super.setBulletNum(5);
		super.setDirection(3);
		super.setSpeed(5);
		super.setBlood(3);
	}
	

	/**
	 * 敌方坦克移动方法
	 */
	public void move() {
		for(int i=0;i<30;i++) {
			if(!this.OutRange()) {
				switch (getDirection()) {
				case 1:
					this.setY(this.getY()-this.getSpeed());
					break;
				case 2:
					this.setX(this.getX()+this.getSpeed());
					break;
				case 3:
					this.setY(this.getY()+this.getSpeed());
					break;
				case 4:
					this.setX(this.getX()-this.getSpeed());
					break;

				default:
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				if(getDirection() == 3) {
					this.setDirection(1);
				}else if(getDirection() ==4) {
					this.setDirection(2);
				}
				else {
					this.setDirection(getDirection()+2);
				}
				
//				for(int j=0;j<20;j++)
//					go();
			}
			
			
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isAlive()) {
			move();
			//敌方坦克改变方向
			this.setDirection((int)(Math.random()*4)+1);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
