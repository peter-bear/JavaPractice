package DataStructure;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack= new ArrayStack(3);
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

class ArrayStack{
	private int MaxSize;
	private int top;
	private int[] array;
	//������
	public ArrayStack(int size) {
		MaxSize = size;
		top = -1;
		array = new int[MaxSize];
	}
	
	//�п�
	public boolean isempty() {
		return top == -1;
	}
	
	//����
	public boolean isfull() {
		return top == MaxSize -1;
	}
	
	//��ջ,ѹջ
	public void push(int value) {
		if(isfull()) {
			System.out.println("�������޷����Ԫ��:"+value);
			return;
		}
		top++;
		array[top] = value;
	} 
	
	//��ջ������
	public int pop() {
		if(isempty()) {
			throw new RuntimeException("ջΪ�գ��޷�����Ԫ��");
		}
		int value = array[top];
		top--;
		return value;
		
	}
	
	//����ջ����������
	public void print() {
		if(isempty()) {
			System.out.println("ջΪ��");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("Stack[%d] = %d\n",i,array[i]);
		}
	}
}