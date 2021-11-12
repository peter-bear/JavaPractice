package MultiThreadsStudy;

public class BankTest {
	public static void main(String[] args) {
		BankCard card = new BankCard();
		AddMoney Jim = new AddMoney();
		Jim.Add(card);
		SubMoney Jack = new SubMoney();
		Jack.Sub(card);
		new Thread(Jim,"Jim").start();
		new Thread(Jack,"Jack").start();
	}
}
