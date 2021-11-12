package DataStructure;
//环形队列
public class QueueDemo2 {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);//实际存储数据个数-1，即3个
		queue.Add(4);
		queue.Add(5);
		queue.Add(7);
		queue.Show();
		System.out.println(queue.Pop());
//		System.out.println(queue.IsFull());
		System.out.println(queue.Pop());
		queue.Add(8);
		queue.Add(9);
//		queue.Add(7);
		queue.Show();
		System.out.println(queue.Pop());
		System.out.println(queue.Pop());
		queue.Add(10);
		queue.Add(11);
		queue.Show();
	}
}

//用数组来模拟队列
class ArrayQueue{
	private int MaxSize;//队列最大容量
	private int front;//队列头
	private int rear; //队列尾
	int[] Queue;//用于存放数据的模拟队列
	
	//创建队列
	ArrayQueue(int MaxSize){
		this.MaxSize = MaxSize;
		Queue = new int[this.MaxSize];
		this.rear =0; //指向队列尾部
		this.front =0;//指向队列头部,第一个元素
		
	}
	
	//判断队列是否为空
	public boolean IsEmpty() {
		return rear==front;
	}
	
	//判断队列是否已满
	public boolean IsFull() {
		return (rear+1)%this.MaxSize == front;
	}
	
	//添加数据
	public void Add(int value) {
		//先做一个判断
		if(IsFull()) {
			System.out.println("已满，无法加入数据");
			return;
		}
		Queue[rear] = value;
		//让rear后移
		rear = (rear+1)%this.MaxSize;
		
	}
	
	//出数据
	public int Pop() {
		//先判断是否为空
		if(IsEmpty()) {
			//通过异常来处理异常
			throw new RuntimeException("为空，无法获取数据");
			//抛出异常后，函数终止
		}
		//1. 获取拷贝front数据
		//2.front向后移，考虑取模
		//3.返回拷贝的数据
		int value = Queue[front];
		front = (front+1)%this.MaxSize;
		return value;
	}
	
	//显示队列的所有数据
	public void Show() {
		if(IsEmpty()) {
			System.out.println("队列已空");
			return;
		}
		//从front开始遍历
		for(int i=front;i<front+this.Size();i++) {
			System.out.printf("Queue[%d] = %d\n",i%this.MaxSize,Queue[i%this.MaxSize]);
		}
	}
	
	//求出有效数据个数
	public int Size() {
		return (rear+this.MaxSize-front)%this.MaxSize;
	}
	
}
