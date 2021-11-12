package MultiThreadsStudy;

public class SubMoney implements Runnable{
	
	private BankCard card;
	public void Sub(BankCard card) {
		this.card = card;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
//			synchronized (card) {
//				if(card.getMoney()>=1000) {
//					card.withdrawMoney(1000.0);
//					System.out.println(Thread.currentThread().getName()
//							+" withdraw $1000 successfully! There are $"+card.getMoney()+" left.");
//				}
//				card.notify();
//				try {
//					card.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		System.exit(0);
			card.withdrawMoney(1000.0);
		}
	}
}
