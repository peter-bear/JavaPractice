package MultiThreadsStudy;

public class SellThread implements Runnable{

	
	//��Ʊͤ����100��Ʊ
	//	private Tickets seller = new Tickets();
//	@Override
//	public void run() {
//		for(int i=0;i<100;i++) {
//			seller.SellTicket();
//			System.out.println(Thread.currentThread().getName()+"������"+seller.getTickets()+" ��Ʊ");
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
				System.out.println(Thread.currentThread().getName()+"������"+this.tickets+" ��Ʊ");
				this.tickets += 1;
			}
			
		}
		
	}
}
