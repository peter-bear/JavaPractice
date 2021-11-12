package MultiThreadsStudy;

public class BankCard{
	private double Money=0;
	private boolean flag; //��ʾ�Ƿ���Դ�Ǯ flag��ʾ��Ǯ

	//��Ǯ
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
		flag = true; //��ʾ��Ǯ��
		this.notify(); //������һ���߳�
	}

	//ȡǮ
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
		flag = false; //��ʾûǮ
		this.notify();
	}
	
	public double getMoney() {
		return this.Money;
	}
}
