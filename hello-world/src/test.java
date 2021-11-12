public class test {
	
	static int s=4;
	public static void main(String[] args) {
//		MyMap.changeNum(7);
//		System.out.println(MyMap.getNum());
//		
//		MyMap.changeNum(8);
//		System.out.println(MyMap.getNum());
		
		String a ="str";
		String b = a;
		String c =	b.toUpperCase();
		System.out.println(s);
		
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
