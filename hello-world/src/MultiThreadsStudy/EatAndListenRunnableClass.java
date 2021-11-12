package MultiThreadsStudy;

public class EatAndListenRunnableClass implements Runnable{
	
	@Override
	public void run() {
		for(int i=1;i<=30;i++) {
			System.out.println("Thread ID: "+Thread.currentThread().getId()+" Thread Name: "
		+Thread.currentThread().getName()+" NO "+i+" time");
		}
	}
	
}
