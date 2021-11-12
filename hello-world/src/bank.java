public class bank{
	private double balance;
	
	bank(){
		balance = 0;
	}
	bank(double initialBalance) {
		balance = initialBalance;
	}
	void deposit(double amount) {
		balance += amount;
	}
	void withdraw(double amount) {
		balance -= amount;
	}
	double getBalance() {
		return balance;
	}
	public static void main(String[] args) 
	{
		bank henrry = new bank(200);
		henrry.deposit(1000);
		henrry.withdraw(300);
		double result = henrry.getBalance();
		System.out.println(result);
		//创建第2个对象
		bank jim = new bank();
		jim.deposit(2000);
		jim.withdraw(600);
		result = jim.getBalance();
		System.out.println(result);
				
	}
}