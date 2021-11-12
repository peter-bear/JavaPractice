package MultiThreadsStudy;

public class CountThreadDemo {
	//Ö÷Ïß³Ì
	public static void main(String[] args) {
		Count number = new Count();
		Count number2 = new Count("Count 2");
		number.setName("Count 1");
		number.start();
		number2.start();
		AnotherCount();
	}
	public static void AnotherCount() {
		for(int i = 1; i<=100;i++) {
			System.out.println("main: "+i);
		}
	}
}
