package DataStructure;

import java.util.Arrays;
import java.util.Stack;

public class PostfixDemo {
	public static void main(String[] args) {
		PolanCal cal = new PolanCal("3+(7+89)*4-66+8");
		System.out.println("原式子："+cal.input);
		cal.ToPostExpression();
		System.out.println("转逆波兰后缀表达式："+cal.output);
		cal.StartCal();
	}
}

class PolanCal {
	String input;// 中缀表达式
	String output = "";// 后缀表达式
	Stack<Character> TempStack = new Stack<>(); // 用于暂时存储中缀转后缀的符号

	PolanCal(String input) {
		this.input = input;
	}

	public void ToPostExpression() {
		// 3+(7+8)*4-6
		// 378+4*+6-
		char[] words = this.input.toCharArray();
		for (int i=0;i<words.length;i++) {
			char word =words[i];
			switch (word) {
			case '+':
			case '-':
				Prio(word, 1);// 优先级判断
				break;
			case '*':
			case '/':
				Prio(word, 2);
				break;
			case '(':
				TempStack.push(word);
				break;
			case ')':
				while (!TempStack.isEmpty()) {
					char operator = TempStack.pop();
					if (operator == '(') {
						break;
					} else {
						output += operator + " ";
					}
				}
				break;
			default:
				// 读取的是数字就直接加入到output字符串中
				output += word;
				if(i<words.length-1&&!Character.isDigit(words[i+1])) {
					output +=" ";
				}
				break;
			}
		}
		// 遍历完后，将暂时栈里面的符号弹出，存入到output
		output+=" ";
		while (!TempStack.isEmpty()) {
			output += TempStack.pop();
		}

	}

	public void Prio(char oper1, int priority1) {
		while (!TempStack.isEmpty()) {
			char onTop = TempStack.pop();// 弹出位于栈顶部的符号
			if (onTop == '(') {// 如果栈顶的是前括号，就不弹出
				TempStack.push(onTop);
				break;// 将输入的符号压入栈中
			} else {
				// 要比较栈顶的符号与输入的符号哪个优先级大
				int priority2;
				if (onTop == '+' || onTop == '-') {
					priority2 = 1;
				} else {
					priority2 = 2;
				}
				// 栈顶符号优先级小于输入的优先级
				// 符号还原，不pop
				if (priority2 < priority1) {
					TempStack.push(onTop);
					break;
				} else {
					output += onTop + " ";
				}
			}
		}

		TempStack.push(oper1);
	}

	public void StartCal() {
		String[] nums = output.split(" ");
		Stack<Double> numStack = new Stack<>();
		for (String i : nums) {
			if (isNumeric(i)) {
				numStack.push(Double.valueOf(i));
			} else {
				double num1 = numStack.pop();
				double num2 = numStack.pop();
				double rst =0;
				if(i.equals("+")) {
					rst = num2+num1;
				}else if(i.equals("-")) {
					rst = num2-num1;
				}else if(i.equals("*")) {
					rst = num2*num1;
				}else if(i.equals("/")) {
					rst = num2*1.0/num1;
				}
				numStack.push(Double.valueOf(rst));
			}
		}
		System.out.println("最终计算结果："+numStack.pop());
	}
	
	public static boolean isNumeric(String str){
	    for (int i = str.length();--i>=0;){  
		     if (!Character.isDigit(str.charAt(i))){
		        return false;
	        }
	    }
	    return true;
	}

}