package lecture4;

public class InfixCalculatorDemo {

	public static void main(String[] args) {
		String equation = "(6+4)-12.1*(15-20)/38";
//		System.out.println("hello");
		System.out.println(get(equation));
	}
	
	public static double get(String input) {
//		System.out.println(input);
		ArrayStack<Double> nums = new ArrayStack<>();
		ArrayStack<Character> oper = new ArrayStack<>();
		char[] equation = input.toCharArray();
		String temp="";
		String parent="";
		for(int i=0;i<equation.length;i++) {
			if(equation[i] =='(') {
				while(equation[i] != ')') {
					parent+=equation[i];
					i++;
				}
//				System.out.println(parent.substring(1, parent.length()));
				
				nums.push(get(parent.substring(1, parent.length())));
				parent="";
				continue;
			}
			if(Character.isDigit(equation[i]) || equation[i] =='.')
				temp += equation[i];
			else {
				if(!temp.equals("")) {
					nums.push(Double.valueOf(temp));
					temp ="";
				}
				oper.push(equation[i]);
			}
		}
//		if(!temp.equals(""))
			nums.push(Double.valueOf(temp));
//		nums.show();
//		for(int i=0;i<11;i++)
//			System.out.println(oper.pop());
//		System.out.println(travel_stack(nums,oper));
//		System.out.println(nums.pop());
		
		return travel_stack(nums,oper);
	}
	
	public static double travel_stack(ArrayStack<Double> nums, ArrayStack<Character> oper) {
		while(!oper.isEmpty()) {	
//			oper.show();
//			nums.show();
			char symble = oper.pop();
			char temp = 0;
			if(oper.size()>0) {
				temp=oper.peek();
//				System.out.println(symble+" "+temp);
			}
				

			//to switch the places
			
			if(oper.size() >0 && priority(symble)< priority(temp)) {
					temp = oper.pop();
					double num1 = nums.pop();
					double num2 = nums.pop();
					double num3 = nums.pop();
					nums.push(num1);
					nums.push(num3);
					nums.push(num2);
					oper.push(symble);
					oper.push(temp);
					symble = oper.pop();
					double num4 = nums.pop();
					double num5 = nums.pop();
//					System.out.println(num1+" "+num2);
					nums.push(cal(symble,num4, num5));
					num4 = nums.pop();
					num5 = nums.pop();
					nums.push(num4);
					nums.push(num5);
					continue;
				}

			
			double num1 = nums.pop();
//			System.out.println(num1);
			double num2 = nums.pop();
//			System.out.println(num1+" "+num2);
			nums.push(cal(symble,num1, num2));
			
		}
		return nums.pop();
		
	}
	
	public static int priority(char ope) {
		if (ope == '*' || ope == '/') {
			return 1;
		} 
		else if (ope == '+' || ope == '-') {
			return 0;
		} 
		else {
			return -1;
		}
	}
	
	public static double cal(char oper, double num1, double num2) {
		double rst=0.0;
		switch (oper) {
		case '+':
			rst = num1 +num2;
			break;
		case '-':
			rst = num2 - num1;
			break;
		case '*':
			rst = num2 * num1;
			break;
		case '/':
			rst = num2 / num1;
			break;

		default:
			break;
		}
		return rst;
	}

}
