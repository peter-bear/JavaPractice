package MultiThreadsStudy;

public class ThreadSleep {
	public static void main(String[] args) {
		EatAndListenRunnableClass eat = new EatAndListenRunnableClass();
		Thread ET = new Thread(eat, "吃饭");
		
		ET.start();
//		try {
//			ET.join();//加入当前线程并阻塞当前线程（），直到加入线程执行完毕
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Listen();
		
		
	}
	public static void Listen() {
		Thread.currentThread().setName("听歌");
		for(int i=1;i<=30;i++) {
			System.out.println("Thread ID: "+Thread.currentThread().getId()+" Thread Name: "
					+Thread.currentThread().getName()+" NO "+i+" time");
		}
		
		//			Thread.sleep(2000);
//		Thread.yield();
	}
}
