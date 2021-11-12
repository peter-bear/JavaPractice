package java_class_study;

public class LargestFactor {
	public static void main(String[] args) {
		int m =2037;
		int n = 3589;
		int a = m;	
		int b = n;
		int r = a%b;
		while (r!=0) {
			a = b;
			b = r;
			r = a%b;
		}
		 int divisor = b;    
		 
		 System.out.println("The Greatest Common Divisor:"+divisor);
		 System.out.println("The Lowest Common Multiple:"+(m*n)/divisor);
	}
}
