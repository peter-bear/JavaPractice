package MultiThreadsStudy;

public class ThreadSleep {
	public static void main(String[] args) {
		EatAndListenRunnableClass eat = new EatAndListenRunnableClass();
		Thread ET = new Thread(eat, "�Է�");
		
		ET.start();
//		try {
//			ET.join();//���뵱ǰ�̲߳�������ǰ�̣߳�����ֱ�������߳�ִ�����
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Listen();
		
		
	}
	public static void Listen() {
		Thread.currentThread().setName("����");
		for(int i=1;i<=30;i++) {
			System.out.println("Thread ID: "+Thread.currentThread().getId()+" Thread Name: "
					+Thread.currentThread().getName()+" NO "+i+" time");
		}
		
		//			Thread.sleep(2000);
//		Thread.yield();
	}
}
