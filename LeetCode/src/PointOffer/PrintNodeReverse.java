package PointOffer;

public class PrintNodeReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyLinkedList list = new MyLinkedList();
//		list.add(1);
//		list.add(1);
//		list.add(2);
//		list.add(2);
//		list.add(2);
//		list.add(2);
//		list.add(3);
//		list.add(3);
//		list.add(4);
//		list.add(4);
//		list.add(5);
//		printNodesReverse(list);
//		printList(list.head);
//		delSameNodes(list);
//		System.out.println("====");
//		printList(list.head);
//		PrintLastKth(list, 3);
		
		MyLinkedList list1 = new MyLinkedList();
		MyLinkedList list2 = new MyLinkedList();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(10);
		
		list2.add(2);
		list2.add(4);
		list2.add(8);
		list2.add(9);
		list2.add(11);
		list2.add(12);
		
		MergeList(list1, list2);
	}
	
	public static void delSameNodes(MyLinkedList list) {
		if(list == null || list.head == null)
			return;
		else {
			Node pre = list.head;
			Node cur = pre;
			
			while(cur != null) {
				
				if(cur.num == cur.next.num) {
					if(cur == list.head) {
						list.head = cur.next.next;
						pre = list.head;
						cur = pre;
						continue;
					}
					pre.next = cur.next.next;
					
					cur = pre.next;
				}
				else {
					cur = cur.next;
					if(cur.next==null)
						break;
				}
					
				
			}
		}
	}
	

	
	public static void printList(Node head) {
		if(head==null)
			return;
		System.out.println(head.num);
		printList(head.next);
	}
	
	public static void printNodesReverse(MyLinkedList list) {
		if(list == null || list.head == null)
			return;
		else {
			printNodesReverse(list.head);
		}
	}
	
	private static void printNodesReverse(Node head) {
		if(head == null)
			return;
		printNodesReverse(head.next);
		System.out.println(head.num);
	}
	
	public static void MergeList(MyLinkedList list1, MyLinkedList list2) {
		printList(MergeList(list1.head, list2.head));
	}
	
	private static Node MergeList(Node n1, Node n2) {
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		Node NewHead = null;
		if(n1.num < n2.num) {
			NewHead = n1;
			NewHead.next = MergeList(n1.next, n2);
		}else {
			NewHead = n2;
			NewHead.next = MergeList(n1, n2.next);
		}
		
		return NewHead;
	}
	
	public static void PrintLastKth(MyLinkedList list, int k) {
		if(list == null)
			return;
		Node pre = list.head;
		Node aft = pre;
		for(int i=0;i<k;i++) {
			pre = pre.next;
			if(pre==null && i!=k-1)
				return;
		}
		
		while(pre!=null) {
			pre = pre.next;
			aft = aft.next;
		}
		
		System.out.println(aft.num);
		 
	}
	
	public static class MyLinkedList{
		public Node head=null;
		public void add(int num) {
			if(head == null)
				head = new Node(num, null);
			else {
				Node cur = head;
				while(cur.next!=null)
					cur = cur.next;
				cur.next = new Node(num, null);
			}
		}
	}
	
	private static class Node{
		public int num;
		public Node next;
		Node(int num, Node next){
			this.num = num;
			this.next = next;
		}
	}

}
