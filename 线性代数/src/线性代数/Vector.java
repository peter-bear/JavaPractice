package 线性代数;

public class Vector {
	private int values[];
	Vector(int s[]){
		values = s;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return values.toString();
	}
	public static void mian(String[] args) {
		System.out.println("Hello");
		int a[] = {5,2};
		Vector vc1 = new Vector(a);
		System.out.println(vc1);
		
	}

}
