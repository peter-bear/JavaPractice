package java_class_study;
import java.util.Scanner;
public class CountInputNumber {
	public static void main(String[] args) {
		System.out.print("Input your numbers:");
		Scanner input = new Scanner(System.in);
		String nums = input.next();
		String[] numbers = nums.split("+");
		int sum=0;
//		for(int i=0; i< nums.length();i++) {
//			if(Character.isDigit(numbers[i])) {
//				sum += 
//			}
//		}
		System.out.println(numbers);
		input.close();
	}
	
}
