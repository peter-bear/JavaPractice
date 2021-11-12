package MultiThreadsStudy;

public class AddMoney implements Runnable{
	private BankCard card;
	public void Add(BankCard card) {
		this.card = card;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
//			synchronized (card) {
//				if(card.getMoney()<=0) {
//					card.depositMoney(1000.0);
//					System.out.println(Thread.currentThread().getName()
//							+" deposit $1000 successfully! There are $"+card.getMoney()+" left.");
//				}
//				card.notify();
//				try {
//					card.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//			
//		System.exit(0);
		card.depositMoney(1000.0);
		}
	}
}
