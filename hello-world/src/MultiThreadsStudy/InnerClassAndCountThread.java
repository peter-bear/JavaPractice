package MultiThreadsStudy;

//Use InnerClass to achieve Multithread
//利用内部类来实现多线程
public class InnerClassAndCountThread {
	public static void main(String[] args) {
		class Counter extends Thread{
			Counter(String name){
				super(name);
			}
			@Override
			public void run() {
				for(int i=1;i<=100;i++) {
					System.out.println("Thread ID: "+this.getId()+" Thread Name: "+this.getName()+" Number "+i);
				}
			}
		} 
		Counter num1 = new Counter("Counter 1");
		Counter num2 = new Counter("Counter 2");
		num1.start();
		num2.start();
	}
}
