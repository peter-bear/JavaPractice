package DataStructure;

public class LinkedListStackDemo {
	public static void main(String[] args) {
		LinkedListStack stack= new LinkedListStack(3);
		System.out.println("\t压栈");
		stack.push(120);
		stack.push(220);
		stack.push(221);
		stack.push(449);
		System.out.println("\t打印栈元素");
		stack.print();
		try {
			System.out.println("\t弹出栈元素");
			System.out.println("弹出的元素："+stack.pop());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\t弹出后的元素");
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
	//构造器
	public LinkedListStack(int size) {
		MaxSize = size;
		head =null;
	}
	
	//容器中元素个数
	public int size() {
		int count =0;
		StackNode cur = head;
		while(cur != null) {
			count ++;
			cur = cur.next;
		}
		return count;
	}
	
	//判空
	public boolean isempty() {
		return head == null;
	}
	
	//判满
	public boolean isfull() {
		return size() == MaxSize;
	}
	
	//压栈
	public void push(int value) {
		StackNode node = new StackNode(value);
		if(isempty()) {
			head = node;
			return;
		}
		if(isfull()) {
			System.out.println("已满，无法添加元素:"+value);
			return;
		}
		StackNode cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
	}
	
	//出栈
	public StackNode pop() {
		if(isempty()) {
			throw new RuntimeException("栈为空，无法弹出元素");
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
	
	//从上到下遍历
	public void print() {
		if(isempty()) {
			System.out.println("栈为空");
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
