package WebRegistration;


public class test {
	public static void main(String[] args) {
//		Long start = Calendar.getInstance().getTimeInMillis();
//		Long end =(long) 0;
//		while((end-start)<1000) {
//			end = Calendar.getInstance().getTimeInMillis();
//			System.out.println("Hello");
//		}
//		System.out.println("world");
		int a = 19;
		int b = 79;
		int c = 100;
		MAX(a, b, c);
		
	}
	public static void MAX(int a, int b, int c) {
		System.out.println("NUM: "+a+" "+b+" "+c);
		int max = a;
		if(a < b) {
			max =b;
			if(b < c) {
				max = c;
			}
		}
		print(max);
	}
	public static void print(int max) {
		System.out.println("MAX is "+max);
	}
}
