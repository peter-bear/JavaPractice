package DataStructure;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack= new ArrayStack(3);
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

class ArrayStack{
	private int MaxSize;
	private int top;
	private int[] array;
	//构造器
	public ArrayStack(int size) {
		MaxSize = size;
		top = -1;
		array = new int[MaxSize];
	}
	
	//判空
	public boolean isempty() {
		return top == -1;
	}
	
	//判满
	public boolean isfull() {
		return top == MaxSize -1;
	}
	
	//入栈,压栈
	public void push(int value) {
		if(isfull()) {
			System.out.println("已满，无法添加元素:"+value);
			return;
		}
		top++;
		array[top] = value;
	} 
	
	//出栈，弹出
	public int pop() {
		if(isempty()) {
			throw new RuntimeException("栈为空，无法弹出元素");
		}
		int value = array[top];
		top--;
		return value;
		
	}
	
	//遍历栈，从上往下
	public void print() {
		if(isempty()) {
			System.out.println("栈为空");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("Stack[%d] = %d\n",i,array[i]);
		}
	}
}