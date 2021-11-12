package modifier;

public class FinalStudy extends Point{
	
}

class Point{
	private int x;
	private int y;
	final int Origion_x;
	final int Origion_y;
//	static final int Origion_x;
//	static final int Origion_y;
//	static{
//		Origion_x=0;
//		Origion_y=0;
//	}
	Point(){
		Origion_x=0;
		Origion_y=0;
	}
	public void SetPoint(int x, int y) {
		this.x =x;
		this.y =y;
	}
	
	public void Print() {
		System.out.println("ԭ�㣺 "+"( "+Origion_x+", "+Origion_y+" )");
		System.out.println("( "+this.x+", "+this.y+" )");
	}
}