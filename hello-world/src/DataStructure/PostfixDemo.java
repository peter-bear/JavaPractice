package DataStructure;

import java.util.Arrays;
import java.util.Stack;

public class PostfixDemo {
	public static void main(String[] args) {
		PolanCal cal = new PolanCal("3+(7+89)*4-66+8");
		System.out.println("ԭʽ�ӣ�"+cal.input);
		cal.ToPostExpression();
		System.out.println("ת�沨����׺���ʽ��"+cal.output);
		cal.StartCal();
	}
}

class PolanCal {
	String input;// ��׺���ʽ
	String output = "";// ��׺���ʽ
	Stack<Character> TempStack = new Stack<>(); // ������ʱ�洢��׺ת��׺�ķ���

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
				Prio(word, 1);// ���ȼ��ж�
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
				// ��ȡ�������־�ֱ�Ӽ��뵽output�ַ�����
				output += word;
				if(i<words.length-1&&!Character.isDigit(words[i+1])) {
					output +=" ";
				}
				break;
			}
		}
		// ������󣬽���ʱջ����ķ��ŵ��������뵽output
		output+=" ";
		while (!TempStack.isEmpty()) {
			output += TempStack.pop();
		}

	}

	public void Prio(char oper1, int priority1) {
		while (!TempStack.isEmpty()) {
			char onTop = TempStack.pop();// ����λ��ջ�����ķ���
			if (onTop == '(') {// ���ջ������ǰ���ţ��Ͳ�����
				TempStack.push(onTop);
				break;// ������ķ���ѹ��ջ��
			} else {
				// Ҫ�Ƚ�ջ���ķ���������ķ����ĸ����ȼ���
				int priority2;
				if (onTop == '+' || onTop == '-') {
					priority2 = 1;
				} else {
					priority2 = 2;
				}
				// ջ���������ȼ�С����������ȼ�
				// ���Ż�ԭ����pop
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
		System.out.println("���ռ�������"+numStack.pop());
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