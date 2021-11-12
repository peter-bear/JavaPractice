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

	// ������Ԫ�ظ���
	public int size() {
		int count = 0;
		NumNode cur = head;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}

	// �п�
	public boolean isempty() {
		return head == null;
	}

	// ѹջ
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

	// ��ջ
	public NumNode pop() {
		if (isempty()) {
			throw new RuntimeException("ջΪ�գ��޷�����Ԫ��");
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

	// �鿴������2��Ԫ�أ����ǲ�����
	public NumNode peek() {
		if (isempty()) {
			throw new RuntimeException("ջΪ�գ��޷�����Ԫ��");
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

	// ���ϵ��±���
	public void print() {
		if (isempty()) {
			System.out.println("ջΪ��");
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
		// ��������ַ���תΪ����
		char[] array = question.toCharArray();

//		System.out.println(Arrays.toString(array));

		// ����2��ջ��һ�����ڴ洢���ţ���һ�����ڴ洢����
		Stack operStack = new Stack();
		Stack numStack = new Stack();
		// number�ַ������ڴ洢��λ���ֵ��ַ�
		String number = "";
		// forѭ������һ��
		for (char i : array) {
			// ͨ���ַ��ж��Ƿ�Ϊ���֣�
			if (Character.isDigit(i)) {
				number += i;
			} else {
				numStack.push(Integer.valueOf(number));
				number = "";
				operStack.push(i);
			}
		}
		// �������һ�������֣�forѭ�����һ��δѹ������ջ����Ҫ�ֶ�ѹ��
		numStack.push(Integer.valueOf(number));

		// �����һ������ջ�����꣬�������
		while (!operStack.isempty()) {
			char nextOpe = (char) operStack.peek().value;
			// �ж����ȼ�
			if (priority(nextOpe) == 1) {
//				System.out.println("����");
//				numStack.print();
//				System.out.println("����");
//				operStack.print();
				double num1 = numStack.pop().value;
				double num2 = numStack.pop().value;
				double num3 = numStack.pop().value;
				double ope1 = operStack.pop().value;
				// ����һ���Ƿ��ǡ�-���ţ�
				if ((char) ope1 == '-') {
					// ���ķ��ţ��ı���������
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
		System.out.println("���ǣ�" + numStack.pop());

	}

	// ������̣�ʹ��switch case
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

//���ȼ��ж�
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