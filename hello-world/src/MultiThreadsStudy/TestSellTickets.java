package MultiThreadsStudy;

public class TestSellTickets {
	public static void main(String[] args) {
		//售票亭各卖100张票
		//		SellThread Place_A = new SellThread();
//		SellThread Place_B = new SellThread();
		SellThread Place = new SellThread();
		new Thread(Place,"售票亭 A ").start();
		new Thread(Place,"售票亭 B ").start();
	}
}
