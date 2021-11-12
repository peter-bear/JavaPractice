package objects;

/**
 * Class Alien1
 *  @author Yao Xiong
 * Alien that moves on horizontal directions only
 * <br> For example
 * <pre>
 * 	Alien1 a = new Alien(1,1,50,50,"//img//alien_pic.png");
 * </pre>
 * 
 */
public class Alien1 extends MotherAlien{

	public Alien1(int x, int y, int length, int height, String fileAddress) {
		super(x, y-1,length, height, 5, fileAddress);		
		
	}

	@Override
	public void moveOnDir() {
		// TODO Auto-generated method stub
		this.moveX();
	}
	
	


	
	
	
	
}
