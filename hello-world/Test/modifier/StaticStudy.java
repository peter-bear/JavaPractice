package modifier;

public class StaticStudy {
	private int cnt;
	public static int cnt2;
	{
		this.cnt =0;
	}
	static {
		cnt2=0;
	}
	public void add() {
		this.cnt++;
	}
	public static void add2() {
		cnt2++;
	}
	public void show() {
		System.out.println("非静态计数器"+cnt);
		System.out.println("静态计数器: "+cnt2);
	}
}


