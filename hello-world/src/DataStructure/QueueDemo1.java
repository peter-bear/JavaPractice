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

//��������ģ�����
class Queue{
	private int MaxSize;//�����������
	private int front;//����ͷ
	private int rear; //����β
	int[] Queue;//���ڴ�����ݵ�ģ�����
	
	//��������
	Queue(int MaxSize){
		this.MaxSize = MaxSize;
		Queue = new int[this.MaxSize];
		this.rear =-1; //ָ�����ͷ������һ��Ԫ�ص�ǰһ��λ��
		this.front =-1;//ָ�����β��
		
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean IsEmpty() {
		return rear==front;
	}
	
	//�ж϶����Ƿ�����
	public boolean IsFull() {
		return rear == MaxSize-1;
	}
	
	//�������
	public void Add(int value) {
		//����һ���ж�
		if(IsFull()) {
			System.out.println("�������޷���������");
			return;
		}
		//��rear����
		rear++;
		Queue[rear] = value;
		
	}
	
	//������
	public int Pop() {
		//���ж��Ƿ�Ϊ��
		if(IsEmpty()) {
			//ͨ���쳣�������쳣
			throw new RuntimeException("Ϊ�գ��޷���ȡ����");
			//�׳��쳣�󣬺�����ֹ
		}
		return Queue[++front];
	}
	
	//��ʾ���е���������
	public void Show() {
		if(IsEmpty()) {
			System.out.println("�����ѿ�");
			return;
		}
		for(int i=0;i<Queue.length;i++) {
			System.out.printf("Queue[%d] = %d\n",i,Queue[i]);
		}
	}
	
	
}
