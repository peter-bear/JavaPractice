import java.util.Scanner;
public class switch2{
	public static void main(String[] args) {
		System.out.print("NUM: ");
		Scanner num = new Scanner(System.in);
		int digit = num.nextInt();
		String digitName;
		switch (digit) {
		case 1: digitName = "one"; break;
		case 2: digitName = "two"; break;
		case 3: digitName = "three"; break;
		case 4: digitName = "four"; 
		case 5: digitName = "five";
		case 6: digitName = "six"; break;
		case 7: digitName = "seven"; break;
		case 8: digitName = "eight"; break;
		case 9: digitName = "nine"; break;
		default: digitName = "I cannot distinguish this number"; break;
		}
		System.out.print(digitName);
		num.close();
	}
}