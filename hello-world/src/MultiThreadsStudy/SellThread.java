package MultiThreadsStudy;

public class SellThread implements Runnable{

	
	//售票亭各卖100张票
	//	private Tickets seller = new Tickets();
//	@Override
//	public void run() {
//		for(int i=0;i<100;i++) {
//			seller.SellTicket();
//			System.out.println(Thread.currentThread().getName()+"卖出第"+seller.getTickets()+" 张票");
//		}
//		
//	}
	private int tickets =1; 
	@Override
	public void run() {
		while(true) {
			synchronized (this) {
				if(tickets>100) {
					break;
				}
				System.out.println(Thread.currentThread().getName()+"卖出第"+this.tickets+" 张票");
				this.tickets += 1;
			}
			
		}
		
	}
}
