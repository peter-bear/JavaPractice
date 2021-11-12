package java_class_study;

public class isprime {
	public static void main(String[] args) {
		for(int i=2; i<=200; i++) {
			boolean isPrime = true;
			for (int j=2; j<i; j++) {
				if((i%j) == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(i+" is prime");
			}
		}
//		System.out.print("ÓÐ"+(100-m)+"¸öËØÊý");
	}
}
