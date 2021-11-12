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
		System.out.println("\tlist的大小："+list.size());
		System.out.println("\t正序打印");
		list.print();
		System.out.println("\t逆序打印");
		list.Rsprint();
		System.out.println("\t查找数据");
		Node[] array = list.search("CSSE");
		for(Node node:array) {
			if(node!=null) {
				System.out.println(node);
			}
		}
		System.out.println("\t删除数据");
		list.del(220);
		list.print();
		System.out.println("\t更改数据");
		list.update(new Node(221,"MA"), new Node(113,"MA"));
		list.print();
//		System.out.println("\t排序后再打印");
		
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

//不自带头节点
class DoubleLinkList{
	private Node head;
	DoubleLinkList(){
		head =null;
	}
	//判空
	public boolean isempty() {
		return head == null;
	}
	
	//增
	public void add(int num,String name) {
		Node node = new Node(num,name);
		if(isempty()) {
			head = node;
			return;
		}
		Node cur = head;
		while(cur.next!=null) {
			if(cur.equals(node)) {
				System.out.println(node+" 节点已存在，无法添加");
				return;
			}
			cur = cur.next;
		}
		cur.next = node;
		node.pre = cur;
	}
	
	//删
	//根据编号删除数据
	public void del(int num) {
		Node cur = head;
		//数据为空
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		//数据在开头
		if(cur.num == num) {
			head = cur.next;
			return;
		}
		//数据在中间
		while(cur.next!=null) {
			if(cur.num == num) {
				cur.pre.next = cur.next;
				cur.next.pre = cur.pre;
				return;
			}
			cur = cur.next;
		}
		//数据在末尾
		if(cur.num == num) {
			cur.pre.next= null;
			return;
		}
		System.out.println("未找到相关数据");
	}
	
	//改,更改数据
	public void update(Node Oldnode,Node Newnode) {
		Node cur = head;
		//数据为空
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		//数据在开头
		if(cur.equals(Oldnode)) {
			Newnode.next = cur.next;
			cur.next.pre = Newnode;
			head = Newnode;
			return;
		}
		//数据在中间,数据在末尾
		while(cur!=null) {
			if(cur.equals(Oldnode)) {
				Newnode.next = cur.next;
				cur.pre.next = Newnode;
				Newnode.pre = cur.pre;
				return;
			}
			cur = cur.next;
		}
		System.out.println("未找到相关数据");
	}
	
	//查
	//根据name查找数据
	public Node[] search(String name) {
		Node cur = head;
		boolean exist = false;
		Node[] array = new Node[this.size()];
		int count=0;
		//数据为空
		if(isempty()) {
			System.out.println("链表为空");
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
			System.out.println("未找到相关数据");
		}
		return array;
	}
	
	//list的大小
	public int size() {
		int count=0;
		Node cur = head;
		while(cur!=null) {
			cur = cur.next;
			count++;
		}
		return count;
	}
	
	//正遍历
	public void print() {
		Node cur = head;
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		while(cur!= null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}
	
	//逆遍历
	public void Rsprint() {
		Node cur = head;
		if(isempty()) {
			System.out.println("链表为空");
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
	
//	//排序,flag用于判定正序还是倒序,默认为正序
//	public void sort(boolean flag) {
//		if(isempty()) {
//			System.out.println("链表为空");
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