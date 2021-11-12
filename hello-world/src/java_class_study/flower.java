package java_class_study;

public class flower {
	public static void main(String[] args) {
		for(int i=100; i<1000; i++ ) {

			int a = i/100;
			int b = (i%100)/10;
			int c = (i%100)%10;
			int sum = a*a*a+b*b*b*b+c*c*c;
			if (sum==i) {
				System.out.println(i+"是水仙花数");
			}
		}
		System.out.println("Finish");
	}
}
