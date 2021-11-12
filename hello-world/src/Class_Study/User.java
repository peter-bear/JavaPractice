package Class_Study;
import java.util.Scanner; 
public class User {
	private String name;
	private int identity;
	private int CardNo;
	private String passward;
	private int Phone;
	private double balance;
	public User(String name, int identity, int CardNo, int phone, String passward) {
		this.name = name;
		this.identity = identity;
		this.CardNo = CardNo;
		this.passward = passward;
		this.Phone = phone;
	}
	public void ResetPassward() {
		Scanner in = new Scanner(System.in);
		System.out.print("Your past passward: ");
		String OriginPass = in.next();
		while(OriginPass.equals(this.passward) == false){
			System.out.println("We are sending a checking message to your phone. ");
			System.out.print("What is the message?  :");
			String Check = in.next();
			if (Check.equals("1234")) {
				break;
			}
			else {
				System.out.println("Do you want to continue? (Y/N)");
				if(in.next() == "N") {
					break;
				}
			}
		}
		System.out.print("Ok! Please type in your new passward:");
		String NewPassward = in.next();
		this.passward = NewPassward;
//	in.close();
	}
	public void RestPhone() {
		Scanner in = new Scanner(System.in);
		System.out.print("Your name: ");
		String name = in.next();
		System.out.print("Your ID: ");
		int ID = in.nextInt();
		System.out.print("Your passward: ");
		String Passward = in.next();
		if (name.equals(this.name) && ID == this.identity && Passward.equals(this.passward)) {
			System.out.print("Thanks! Your new phone number: ");
			this.Phone = in.nextInt();
		}
		else {
			System.out.println("Your information is incorrect!!");
			System.out.println("Please ask our worker to help you.");
		}
		in.close();
	}
}
