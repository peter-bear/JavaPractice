import java.util.Scanner;
public class TranslateMoney{
	private double penny=0.01;
	private double quarter=0.25;
	private double dime = 0.1;
	private double nickel =0.05;
	private double dollar;
	public TranslateMoney(){
		dollar =0;
	}
	public void money(int one, int five, int ten, int twenty_five ){
		dollar = one*penny + five*nickel + ten*dime + twenty_five*quarter;
	}
	public double getMoney() {
		return dollar;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		TranslateMoney check = new TranslateMoney();
		check.money(a,b,c,d);
		double rst =check.getMoney();
		System.out.printf("%.2f\n",rst);
		//可以用来取整
		int result = (int)rst;
		System.out.println(result);
		in.close();		
		
	}
}