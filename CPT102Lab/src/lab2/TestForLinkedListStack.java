package lab2;


public class TestForLinkedListStack {
	public static void main(String[] args) {
		LinkedListStack<Character> stack = new LinkedListStack<>();
		char[] arr = "abcdef".toCharArray();
		System.out.println("Push elements");
		for(char a:arr) {
			System.out.print(a+" ");
			stack.push(a);
		}
		
		System.out.println("\nPop elements");
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
		
	}
}
