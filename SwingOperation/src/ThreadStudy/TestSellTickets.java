package ThreadStudy;

public class TestSellTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sellor person = new sellor();
		Thread thread1 = new Thread(person);
		Thread thread2 = new Thread(person);
		thread1.setName("Jim");
		thread2.setName("Bon");
		
		thread1.start();
		thread2.start();
	}

}

class sellor implements Runnable{
	private int tickets = 100;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
				synchronized (this) {
					if(tickets <=1){
						System.out.println("Tickets Empty");
						break;
					}
					System.out.println(Thread.currentThread().getName()+" sell "+(--tickets)+" th tickets");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		}
		
	}
	
}