package objects;
/**
 * Class Alien2
 * @author Qingyuan Jiao
 * Alien that moves both horizontally and vertically
 * 
 *
 *
 */
public class Alien2 extends MotherAlien{
	
	public Alien2(int x, int y, int length, int height, String fileAddress) {
		super(x, y,length, height, 10, fileAddress);
		
	}
	

	
	@Override
	public void moveOnDir() {
		
		this.moveX();
		this.moveY();
	}
	



	

}
