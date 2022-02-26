public class test {
	
	static int s=4;
	public static void main(String[] args) {
//		MyMap.changeNum(7);
//		System.out.println(MyMap.getNum());
//		
//		MyMap.changeNum(8);
//		System.out.println(MyMap.getNum());
		
//		String a ="str";
//		String b = a;
//		String c =	b.toUpperCase();
//		System.out.println(s);
//		System.out.println(answer(6));
		Fibo(20);
		
	}
	public static int answer(int num) {
		
//		for(int i= 3;i<200;i++) {
//			if(Fibo(i) > num+1)
//				return i-4;
//		}
		return Fibo(num+1)-1;
	}
	
	public static int Fibo(int num) {
		int c = 0;
		int a = 1;
		int b=  1;
		for(int i=2;i<num; i++) {
			c = a+b;
			a = b;
			b = c;
			System.out.println((i+1)+"\t"+c);
		}
		return c;
	}
	
	private static class MyMap{
		private static int num=4;
		
		public static void changeNum(int n) {
			num = n;
		}
		
		public static int getNum() {
			return num;
		}
	}
	
}
