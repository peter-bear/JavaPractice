//import java.util.Scanner;
public class string{
	public static void main(String[] args) {
		String name = "peter bear";
		/*
		System.out.printf("my name is %10s\n",name);
		System.out.print("Your age is : ");
		Scanner age = new Scanner(System.in);
		int peter = age.nextInt();
		System.out.printf("I get your age: %d\n",peter );
		System.out.print("Please enter your name: ");
		String others = age.next();
		System.out.printf("your name is %10s",others);
		age.close();
		**/
		
		/*
		char start = name.charAt(0);
		int len = name.length();
		char end = name.charAt(len-1);
		System.out.println(start);
		System.out.print(end);
		**/
		String sub = name.substring(0,5);
		System.out.println(sub);
	}
}