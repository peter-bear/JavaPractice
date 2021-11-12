//import java.util.Scanner;
public class if_statement{
	public static void main(String[] args) {
		/*
		System.out.print("Your choice: ");
		Scanner chic = new Scanner(System.in);
		int floor = chic.nextInt();
		if (floor >=13) {System.out.printf("Your actual floor is %d",floor-1);}
		else {System.out.printf("Your actual floor is %d",floor);}
		chic.close();
		**/
		String name1 = "peter";
		String name2 = "peter";
		if (name1.equals(name2)) {
			System.out.print("equal");
		}
		else {
			System.out.print("Not equal");;
		}
	}
}