package MultiThreadsStudy;

public class QuicCnt {
	public static void main(String[] args) {
		Runnable Hundred = new Runnable() {

			@Override
			public void run() {
				int sum =2;
//				System.out.println(2);
				for(int i=3;i<=100000;i++) {
					if(Isprime(i)) {
//						System.out.println(i);
						sum += i;
					}
				}
				System.out.println("Sum:"+sum);
				}
			private Boolean Isprime(int num) {
				for(int i=2;i<num;i++) {
					if(num%i == 0) {
						return false;
					}
				}
				return true;
			}
			};
		new Thread(Hundred).start();
	
	}
	
}
