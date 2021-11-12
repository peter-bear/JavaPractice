package DataStructure;

public class LinkedListStackDemo {
	public static void main(String[] args) {
		LinkedListStack stack= new LinkedListStack(3);
		System.out.println("\tѹջ");
		stack.push(120);
		stack.push(220);
		stack.push(221);
		stack.push(449);
		System.out.println("\t��ӡջԪ��");
		stack.print();
		try {
			System.out.println("\t����ջԪ��");
			System.out.println("������Ԫ�أ�"+stack.pop());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\t�������Ԫ��");
		stack.print();
	}

}

class StackNode{
	int value;
	StackNode next;
	public StackNode(int num) {
		value = num;
		next = null;
	}
	@Override
	public String toString() {
		return value+"";
	}
	
}
class LinkedListStack{
	private int MaxSize;
	private StackNode head;
	//������
	public LinkedListStack(int size) {
		MaxSize = size;
		head =null;
	}
	
	//������Ԫ�ظ���
	public int size() {
		int count =0;
		StackNode cur = head;
		while(cur != null) {
			count ++;
			cur = cur.next;
		}
		return count;
	}
	
	//�п�
	public boolean isempty() {
		return head == null;
	}
	
	//����
	public boolean isfull() {
		return size() == MaxSize;
	}
	
	//ѹջ
	public void push(int value) {
		StackNode node = new StackNode(value);
		if(isempty()) {
			head = node;
			return;
		}
		if(isfull()) {
			System.out.println("�������޷����Ԫ��:"+value);
			return;
		}
		StackNode cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
	}
	
	//��ջ
	public StackNode pop() {
		if(isempty()) {
			throw new RuntimeException("ջΪ�գ��޷�����Ԫ��");
		}
		
		StackNode pre = head;
		if(size()==1) {
			head = null;
			return pre;
		}
		StackNode cur = pre.next;
		while(cur.next != null) {
			pre = pre.next;
			cur = cur.next;
		}
		StackNode temp = cur;
		pre.next = null;
		return temp;
	}
	
	//���ϵ��±���
	public void print() {
		if(isempty()) {
			System.out.println("ջΪ��");
			return;
		}
		LinkedListStack container = new LinkedListStack(size());
		StackNode cur = head;
		while(cur!=null) {
			container.push(cur.value);
			cur = cur.next;
		}
		while(container.size()>0) {
			System.out.println(container.pop());
		}
	}
}
