package lab2;

//import java.util.LinkedList;

public class ArrayStackTest {

	public static void main(String[] args) {
//		LinkedList<Character> list = new LinkedList<>();
		ArrayStack<Character> stack = new ArrayStack<>();
		char[] arr = "abcdef".toCharArray();
		System.out.println("Push elements");
		for(char a:arr) {
			System.out.print(a+" ");
			stack.push(a);
		}
		
		System.out.println("\nPoP elements");
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
		
//		System.out.println("\nUse LinkedList To Implement This Question");
////		System.out.println("Use LinkedList ");
//		for(char a:arr) {
//			System.out.print(a+" ");
//			list.add(a);
//		}
//		
//		while(!list.isEmpty())
//			System.out.print(list.pop()+" ");
//		

	}

}
