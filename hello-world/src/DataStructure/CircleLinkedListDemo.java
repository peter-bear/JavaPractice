package DataStructure;

public class CircleLinkedListDemo {
	public static void main(String[] args) {
		CircleLinkedList list = new CircleLinkedList();
		for(int i=0;i<5;i++) {
			list.add(i);
		}
		System.out.println("\t添加数据");
		list.print();
		System.out.println("\t删除头部数据");
		list.del(0);
		list.print();
		System.out.println("\t更改数据");
		list.update(new Person(3), new Person(0));
		list.print();
		System.out.println("\t查找数据，是否包含此数据");
		System.out.println(list.contains(3));
//		System.out.println("\t删除中间数据");
//		list.del(3);
//		list.print();
//		System.out.println("\t删除尾部数据");
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
	
	//判空
	public boolean isempty() {
		return head == null;
	}
	
	//增
	public void add(int num) {
		Person node = new Person(num);
		//开始为空
		if(isempty()) {
			head = node;
			node.next = head;
			return;
		}
		//开始不为空
		Person cur = head;
		while(cur.next!=head) {
			if(cur.equals(node)) {
				System.out.println("此数据已存在");
				return;
			}
			cur =cur.next;
		}
		cur.next = node;
		node.next = head;
	}
	
	//删
	public void del(int num) {
		Person cur = head;
		//判空
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		
		while(cur.next!=head) {
			if(cur.next.num == num) {
				//数据在尾部
				if(cur.next.next == head) {
					cur.next = head;
					return;
				}
				cur.next = cur.next.next;
				return;
			}
			cur = cur.next;
		}
		//数据在头部,此时指针在尾部
		if(cur.next.num == num) {
			head = head.next;
			cur.next = cur.next.next;
			return;
		}
		System.out.println("未找到相关数据");
	}
	
	//改
	public void update(Person OldNode, Person NewNode) {
		Person cur = head;
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		//中间与尾部
		while(cur.next != head) {
			if(cur.next.equals(OldNode)) {
				NewNode.next = cur.next.next;
				cur.next = NewNode;
				return;
			}
			cur =cur.next;
		}
		//数据在头部
		if(cur.next.equals(OldNode)) {
			NewNode.next = head.next;
			head = NewNode;
			cur.next = head;
			return;
		}
		System.out.println("未找到相关数据");

	}
	
	//查
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
	//遍历
	public void print() {
		Person cur = head;
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		do{
			System.out.println(cur);
			cur = cur.next;
		}while(cur!= head); 
	}
}

