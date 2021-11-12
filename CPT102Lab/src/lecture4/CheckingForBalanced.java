package lecture4;

public class CheckingForBalanced {

	public static void main(String[] args) {
		String input = "{(1+2)+[3*4]}";
//		String input = "{()[]}";
		System.out.println(checking(input));
		

	}
	
	public static boolean checking(String parentheses) {
		ArrayStack<Character> stack = new ArrayStack<>();
		char[] arr =parentheses.toCharArray();
		boolean balanced = false;
		for(char i: arr) {
			if(i=='(' || i=='['||i=='{') {
				stack.push(i);
			}else if(i==')' || i==']'||i=='}'){
				char ope = stack.pop();
				if((ope == '(' && i==')') || (ope == '[' && i==']') || (ope == '{' && i=='}')) {
					balanced = true;
				}else {
					return false;
				}
			}
		}
		return balanced;
	}

}
