package DataStructure;

public class RecursionDemo2 {
	public static void main(String[] args) {
		System.out.println(print(9));
	}
	public static int print(int num) {
		if(num==0) {
			return 0;
		}
		System.out.println(print(num-1));
		return num;
		
	}
}
