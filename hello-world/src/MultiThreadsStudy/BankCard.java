package MultiThreadsStudy;

public class BankCard{
	private double Money=0;
	private boolean flag; //表示是否可以存钱 flag表示有钱

	//存钱
	public synchronized void depositMoney(double money) {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		this.Money += money;
		System.out.println(Thread.currentThread().getName()+
				" deposit $1000 successfully! There are $"+this.Money+" left.");
		flag = true; //表示有钱，
		this.notify(); //唤醒另一个线程
	}

	//取钱
	public synchronized void withdrawMoney(double money) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		this.Money -= money;
		System.out.println(Thread.currentThread().getName()
				+" withdraw $1000 successfully! There are $"+this.getMoney()+" left.");
		flag = false; //表示没钱
		this.notify();
	}
	
	public double getMoney() {
		return this.Money;
	}
}
