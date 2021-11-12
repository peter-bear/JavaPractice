package DataStructure;


 
public class QueueDemo1 {
	public static void main(String[] args) {
		Queue queue = new Queue(3);
		queue.Add(4);
		queue.Add(5);
		queue.Add(7);
		System.out.println(queue.Pop());
		System.out.println(queue.IsFull());
		System.out.println(queue.Pop());
		queue.Show();
		
		
	}
}

//用数组来模拟队列
class Queue{
	private int MaxSize;//队列最大容量
	private int front;//队列头
	private int rear; //队列尾
	int[] Queue;//用于存放数据的模拟队列
	
	//创建队列
	Queue(int MaxSize){
		this.MaxSize = MaxSize;
		Queue = new int[this.MaxSize];
		this.rear =-1; //指向队列头部，第一个元素的前一个位置
		this.front =-1;//指向队列尾部
		
	}
	
	//判断队列是否为空
	public boolean IsEmpty() {
		return rear==front;
	}
	
	//判断队列是否已满
	public boolean IsFull() {
		return rear == MaxSize-1;
	}
	
	//添加数据
	public void Add(int value) {
		//先做一个判断
		if(IsFull()) {
			System.out.println("已满，无法加入数据");
			return;
		}
		//让rear后移
		rear++;
		Queue[rear] = value;
		
	}
	
	//出数据
	public int Pop() {
		//先判断是否为空
		if(IsEmpty()) {
			//通过异常来处理异常
			throw new RuntimeException("为空，无法获取数据");
			//抛出异常后，函数终止
		}
		return Queue[++front];
	}
	
	//显示队列的所有数据
	public void Show() {
		if(IsEmpty()) {
			System.out.println("队列已空");
			return;
		}
		for(int i=0;i<Queue.length;i++) {
			System.out.printf("Queue[%d] = %d\n",i,Queue[i]);
		}
	}
	
	
}
