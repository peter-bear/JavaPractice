package DataStructure;
//���ζ���
public class QueueDemo2 {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);//ʵ�ʴ洢���ݸ���-1����3��
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

//��������ģ�����
class ArrayQueue{
	private int MaxSize;//�����������
	private int front;//����ͷ
	private int rear; //����β
	int[] Queue;//���ڴ�����ݵ�ģ�����
	
	//��������
	ArrayQueue(int MaxSize){
		this.MaxSize = MaxSize;
		Queue = new int[this.MaxSize];
		this.rear =0; //ָ�����β��
		this.front =0;//ָ�����ͷ��,��һ��Ԫ��
		
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean IsEmpty() {
		return rear==front;
	}
	
	//�ж϶����Ƿ�����
	public boolean IsFull() {
		return (rear+1)%this.MaxSize == front;
	}
	
	//�������
	public void Add(int value) {
		//����һ���ж�
		if(IsFull()) {
			System.out.println("�������޷���������");
			return;
		}
		Queue[rear] = value;
		//��rear����
		rear = (rear+1)%this.MaxSize;
		
	}
	
	//������
	public int Pop() {
		//���ж��Ƿ�Ϊ��
		if(IsEmpty()) {
			//ͨ���쳣�������쳣
			throw new RuntimeException("Ϊ�գ��޷���ȡ����");
			//�׳��쳣�󣬺�����ֹ
		}
		//1. ��ȡ����front����
		//2.front����ƣ�����ȡģ
		//3.���ؿ���������
		int value = Queue[front];
		front = (front+1)%this.MaxSize;
		return value;
	}
	
	//��ʾ���е���������
	public void Show() {
		if(IsEmpty()) {
			System.out.println("�����ѿ�");
			return;
		}
		//��front��ʼ����
		for(int i=front;i<front+this.Size();i++) {
			System.out.printf("Queue[%d] = %d\n",i%this.MaxSize,Queue[i%this.MaxSize]);
		}
	}
	
	//�����Ч���ݸ���
	public int Size() {
		return (rear+this.MaxSize-front)%this.MaxSize;
	}
	
}
