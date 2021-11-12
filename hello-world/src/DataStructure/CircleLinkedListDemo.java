package DataStructure;

public class CircleLinkedListDemo {
	public static void main(String[] args) {
		CircleLinkedList list = new CircleLinkedList();
		for(int i=0;i<5;i++) {
			list.add(i);
		}
		System.out.println("\t�������");
		list.print();
		System.out.println("\tɾ��ͷ������");
		list.del(0);
		list.print();
		System.out.println("\t��������");
		list.update(new Person(3), new Person(0));
		list.print();
		System.out.println("\t�������ݣ��Ƿ����������");
		System.out.println(list.contains(3));
//		System.out.println("\tɾ���м�����");
//		list.del(3);
//		list.print();
//		System.out.println("\tɾ��β������");
//		list.del(4);
//		list.print();
	}
}

class Person{
	int num;
	Person next;
	Person(int num){
		this.num = num;
		next = null;
	}
	@Override
	public boolean equals(Object obj) {
		Person node =(Person) obj;
		return node.num == this.num;
	}
	@Override
	public String toString() {
		return num+"";
	}
	
}

class CircleLinkedList{
	private Person head;
	
	public CircleLinkedList() {
		head = null;
	}
	
	//�п�
	public boolean isempty() {
		return head == null;
	}
	
	//��
	public void add(int num) {
		Person node = new Person(num);
		//��ʼΪ��
		if(isempty()) {
			head = node;
			node.next = head;
			return;
		}
		//��ʼ��Ϊ��
		Person cur = head;
		while(cur.next!=head) {
			if(cur.equals(node)) {
				System.out.println("�������Ѵ���");
				return;
			}
			cur =cur.next;
		}
		cur.next = node;
		node.next = head;
	}
	
	//ɾ
	public void del(int num) {
		Person cur = head;
		//�п�
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		
		while(cur.next!=head) {
			if(cur.next.num == num) {
				//������β��
				if(cur.next.next == head) {
					cur.next = head;
					return;
				}
				cur.next = cur.next.next;
				return;
			}
			cur = cur.next;
		}
		//������ͷ��,��ʱָ����β��
		if(cur.next.num == num) {
			head = head.next;
			cur.next = cur.next.next;
			return;
		}
		System.out.println("δ�ҵ��������");
	}
	
	//��
	public void update(Person OldNode, Person NewNode) {
		Person cur = head;
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		//�м���β��
		while(cur.next != head) {
			if(cur.next.equals(OldNode)) {
				NewNode.next = cur.next.next;
				cur.next = NewNode;
				return;
			}
			cur =cur.next;
		}
		//������ͷ��
		if(cur.next.equals(OldNode)) {
			NewNode.next = head.next;
			head = NewNode;
			cur.next = head;
			return;
		}
		System.out.println("δ�ҵ��������");

	}
	
	//��
	public boolean contains(int num) {
		Person cur = head;
		do{
			if(cur.num == num) {
				return true;
			}
			cur=cur.next;
		}while(cur!=head) ;
		return false;
	}
	//����
	public void print() {
		Person cur = head;
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		do{
			System.out.println(cur);
			cur = cur.next;
		}while(cur!= head); 
	}
}

