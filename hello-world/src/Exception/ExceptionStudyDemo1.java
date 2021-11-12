package Exception;

import java.util.Scanner;

public class ExceptionStudyDemo1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Num1: ");
			int num = input.nextInt();
			System.out.print("Num2: ");
			int num2 = input.nextInt();
			divide(num, num2);
//			double rst = num*1.0/num2;
//			System.out.println("Num1 / Num2 = "+rst);
		}
//		catch(CustomException a) {
//			System.out.println("You cannot divide zero!");
//		}
		catch(ArithmeticException a) {
			System.out.println(a.getMessage());
		}
		finally {
			input.close();
		}
	}
	//CustomException
	public static void divide(int num, int num2) throws ArithmeticException{
//		if(num2 == 0) {
//			throw new CustomException();
//		}
		System.out.println("Num1 / Num2 = "+num/num2);
	}
}
