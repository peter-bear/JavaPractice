package DataStructure;


public class DoubleLinkDemo {
	public static void main(String[] args) {
		DoubleLinkList list = new DoubleLinkList();
		list.add(120,"CSSE");
		list.add(399,"ESL");
		list.add(220,"CSSE");
		list.add(399,"ESL");
		list.add(102,"CSSE");
		list.add(221,"MA");
		System.out.println("\tlist�Ĵ�С��"+list.size());
		System.out.println("\t�����ӡ");
		list.print();
		System.out.println("\t�����ӡ");
		list.Rsprint();
		System.out.println("\t��������");
		Node[] array = list.search("CSSE");
		for(Node node:array) {
			if(node!=null) {
				System.out.println(node);
			}
		}
		System.out.println("\tɾ������");
		list.del(220);
		list.print();
		System.out.println("\t��������");
		list.update(new Node(221,"MA"), new Node(113,"MA"));
		list.print();
//		System.out.println("\t������ٴ�ӡ");
		
	}
}

class Node{
	int num;
	String name;
	Node pre;
	Node next;
	Node(int num,String name){
		this.num = num;
		this.name =name;
		pre =null;
		next=null;
	}
	@Override
	public String toString() {
		return name+" "+num;
	}
	@Override
	public boolean equals(Object obj) {
		Node node = (Node)obj;
		return node.num == this.num&&node.name.equals(this.name);
	}
	
	
}

//���Դ�ͷ�ڵ�
class DoubleLinkList{
	private Node head;
	DoubleLinkList(){
		head =null;
	}
	//�п�
	public boolean isempty() {
		return head == null;
	}
	
	//��
	public void add(int num,String name) {
		Node node = new Node(num,name);
		if(isempty()) {
			head = node;
			return;
		}
		Node cur = head;
		while(cur.next!=null) {
			if(cur.equals(node)) {
				System.out.println(node+" �ڵ��Ѵ��ڣ��޷����");
				return;
			}
			cur = cur.next;
		}
		cur.next = node;
		node.pre = cur;
	}
	
	//ɾ
	//���ݱ��ɾ������
	public void del(int num) {
		Node cur = head;
		//����Ϊ��
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		//�����ڿ�ͷ
		if(cur.num == num) {
			head = cur.next;
			return;
		}
		//�������м�
		while(cur.next!=null) {
			if(cur.num == num) {
				cur.pre.next = cur.next;
				cur.next.pre = cur.pre;
				return;
			}
			cur = cur.next;
		}
		//������ĩβ
		if(cur.num == num) {
			cur.pre.next= null;
			return;
		}
		System.out.println("δ�ҵ��������");
	}
	
	//��,��������
	public void update(Node Oldnode,Node Newnode) {
		Node cur = head;
		//����Ϊ��
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		//�����ڿ�ͷ
		if(cur.equals(Oldnode)) {
			Newnode.next = cur.next;
			cur.next.pre = Newnode;
			head = Newnode;
			return;
		}
		//�������м�,������ĩβ
		while(cur!=null) {
			if(cur.equals(Oldnode)) {
				Newnode.next = cur.next;
				cur.pre.next = Newnode;
				Newnode.pre = cur.pre;
				return;
			}
			cur = cur.next;
		}
		System.out.println("δ�ҵ��������");
	}
	
	//��
	//����name��������
	public Node[] search(String name) {
		Node cur = head;
		boolean exist = false;
		Node[] array = new Node[this.size()];
		int count=0;
		//����Ϊ��
		if(isempty()) {
			System.out.println("����Ϊ��");
			return null;
		}
		while(cur!=null) {
			if(cur.name.equals(name)) {
				array[count] = cur;
				exist =true;
				count++;
			}
			cur = cur.next;
		}
		if(!exist) {
			System.out.println("δ�ҵ��������");
		}
		return array;
	}
	
	//list�Ĵ�С
	public int size() {
		int count=0;
		Node cur = head;
		while(cur!=null) {
			cur = cur.next;
			count++;
		}
		return count;
	}
	
	//������
	public void print() {
		Node cur = head;
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		while(cur!= null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}
	
	//�����
	public void Rsprint() {
		Node cur = head;
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		while(cur.next!=null) {
			cur = cur.next;
		}
		while(cur!=null) {
			System.out.println(cur);
			cur = cur.pre;
		}
	}
	
//	//����,flag�����ж������ǵ���,Ĭ��Ϊ����
//	public void sort(boolean flag) {
//		if(isempty()) {
//			System.out.println("����Ϊ��");
//			return;
//		}
//		if(flag) {
//			Node tmp = null;
//			Node cur = head;
//			while(cur!=null) {
//				
//			}
//		}
//		else {
//			
//		}
//	}
}