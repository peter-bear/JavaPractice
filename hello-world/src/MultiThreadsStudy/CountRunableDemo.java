package MultiThreadsStudy;

public class CountRunableDemo {
	public static void main(String[] args) {
//�ڲ���ʵ�ֽӿ�
//		Runnable num1 = new Runnable() {
//			@Override
//			public void run() {
//				for(int i=1; i<=10;i++) {
//					System.out.println("Thread ID: "+Thread.currentThread().getId()+" Thread Name: "+Thread.currentThread().getName()+" NO"+i+" time");
//				}
//			}
//		};
//		Runnable num2 = new Runnable() {
//			@Override
//			public void run() {
//				for(int i=1; i<=10;i++) {
//					System.out.println("Thread ID: "+Thread.currentThread().getId()+" Thread Name: "+Thread.currentThread().getName()+" NO"+i+" time");
//				}
//			}
//		};
//		new Thread(num1,"�Է�").start();
//		new Thread(num2,"����").start();
		EatAndListenRunnableClass eat = new EatAndListenRunnableClass();
		EatAndListenRunnableClass listen = new EatAndListenRunnableClass();
		Thread ET = new Thread(eat,"�Է�");
		Thread LIS = new Thread(listen, "������");
		LIS.setPriority(10);
		ET.setPriority(1);
		ET.start();
		LIS.start();
	}
}
