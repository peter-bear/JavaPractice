package MultiThreadsStudy;

public class TestSellTickets {
	public static void main(String[] args) {
		//��Ʊͤ����100��Ʊ
		//		SellThread Place_A = new SellThread();
//		SellThread Place_B = new SellThread();
		SellThread Place = new SellThread();
		new Thread(Place,"��Ʊͤ A ").start();
		new Thread(Place,"��Ʊͤ B ").start();
	}
}
