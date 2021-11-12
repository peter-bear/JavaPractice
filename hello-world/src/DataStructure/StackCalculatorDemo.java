package DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class StackCalculatorDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("please input the operation equation: ");
		String expression = input.next();
		Calculator cal = new Calculator();
		cal.process(expression);
		input.close();
	}
}

class NumNode {
	double value;
	NumNode next;

	public NumNode(double num) {
		value = num;
		next = null;
	}

	@Override
	public String toString() {
		return value + "";
	}

}

class Stack {
	private NumNode head = null;

	// 容器中元素个数
	public int size() {
		int count = 0;
		NumNode cur = head;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}

	// 判空
	public boolean isempty() {
		return head == null;
	}

	// 压栈
	public void push(double value) {
		NumNode node = new NumNode(value);
		if (isempty()) {
			head = node;
			return;
		}

		NumNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
	}

	// 出栈
	public NumNode pop() {
		if (isempty()) {
			throw new RuntimeException("栈为空，无法弹出元素");
		}

		NumNode pre = head;
		if (size() == 1) {
			head = null;
			return pre;
		}
		NumNode cur = pre.next;
		while (cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}
		NumNode temp = cur;
		pre.next = null;
		return temp;
	}

	// 查看倒数第2个元素，但是不弹出
	public NumNode peek() {
		if (isempty()) {
			throw new RuntimeException("栈为空，无法弹出元素");
		}

		NumNode pre = head;
		if (size() == 1) {
			return pre;
		}
		NumNode cur = pre.next;
		while (cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}
		return pre;
	}

	// 从上到下遍历
	public void print() {
		if (isempty()) {
			System.out.println("栈为空");
			return;
		}
		Stack container = new Stack();
		NumNode cur = head;
		while (cur != null) {
			container.push(cur.value);
			cur = cur.next;
		}
		while (container.size() > 0) {
			System.out.println(container.pop());
		}
	}

}

class Calculator {
	public void process(String question) {
//		String question = "7*88+6*6-5/10";
		// 将输入的字符串转为数组
		char[] array = question.toCharArray();

//		System.out.println(Arrays.toString(array));

		// 创建2个栈，一个用于存储符号，另一个用于存储数字
		Stack operStack = new Stack();
		Stack numStack = new Stack();
		// number字符串用于存储多位数字的字符
		String number = "";
		// for循环遍历一遍
		for (char i : array) {
			// 通过字符判断是否为数字，
			if (Character.isDigit(i)) {
				number += i;
			} else {
				numStack.push(Integer.valueOf(number));
				number = "";
				operStack.push(i);
			}
		}
		// 由于最后一个是数字，for循环最后一遍未压入数字栈，需要手动压入
		numStack.push(Integer.valueOf(number));

		// 当最后一个符号栈遍历完，运算结束
		while (!operStack.isempty()) {
			char nextOpe = (char) operStack.peek().value;
			// 判断优先级
			if (priority(nextOpe) == 1) {
//				System.out.println("数字");
//				numStack.print();
//				System.out.println("符号");
//				operStack.print();
				double num1 = numStack.pop().value;
				double num2 = numStack.pop().value;
				double num3 = numStack.pop().value;
				double ope1 = operStack.pop().value;
				// 看下一个是否是‘-’号，
				if ((char) ope1 == '-') {
					// 更改符号，改变数字正负
					ope1 = (int) '+';
					num1 *= -1;
				}
				double ope2 = operStack.pop().value;

				numStack.push(num1);
				numStack.push(num3);
				numStack.push(num2);
				operStack.push(ope1);
				operStack.push(ope2);
			}
			double num1 = numStack.pop().value;
			double num2 = numStack.pop().value;
			char ope = (char) operStack.pop().value;
			Double rst = cal(num1, num2, ope);
			numStack.push(rst);
		}
		System.out.println("答案是：" + numStack.pop());

	}

	// 计算过程，使用switch case
	public double cal(double num1, double num2, char ope) {
		double rst = 0;
		switch (ope) {
		case '*':
			rst = num2 * num1;
			break;
		case '/':
			rst = num2 * 1.0 / num1;
			break;
		case '+':
			rst = num2 + num1;
			break;
		case '-':
			rst = num2 - num1;
			break;

		default:
			break;
		}
		return rst;
	}

//优先级判断
	public int priority(char ope) {
		if (ope == '*' || ope == '/') {
			return 1;
		} else if (ope == '+' || ope == '-') {
			return 0;
		} else {
			return -1;
		}
	}

}