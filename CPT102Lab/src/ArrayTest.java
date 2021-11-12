import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5};
//		System.out.println(Arrays.toString(copy(arr)));
//		Node n = new Node(arr);
//		arr[0] =0;
//		System.out.println(Arrays.toString(n.data));
//		modify(arr);
//		System.out.println(Arrays.toString(arr));
//		Node head = null;

		System.out.println("start");
//		print(head);
		
//		ArrayTest test = new ArrayTest();
//		for(int i:arr) {
////			System.out.println(i);
//			test.add(i);
//		}
//		System.out.println("print");
//		test.print();
		Node head=null;
		Node n1 = new Node(1, null);
		Node n2 = new Node(2, null);
//		test(n1, 2);
//		System.out.println(n1.data);
		
		head = n1;
		n2 = head;
		
		n1 = new Node(2, null);
		head = new Node(3, null);
		System.out.println(head.data);
		System.out.println(n2.data);
	}
	
	public static void test(Node n, int d) {
//		n.next = new Node(d, null);
		n.data = d;
	}
	
	private Node head=null;
	private int count;
	ArrayTest(){
		head =null;
		count =0;
	}
	
	public void add(int d) {
//		if(count == 0) {
//			head = new Node(d, null);
//		}
//		else {
//			add(head,count, d);
//		}
//		count++;
		
		if(head ==null) {
			head = new Node(d, null);
			return;
		}
			
		add(head, d);
	}
	
	public void print() {
		print(head);
	}
	
	private void add(Node root, int d) {
		
		if(root.next == null) {
			root.next = new Node(d, null);
		}else {
			add(root.next, d);
		}
	}
	
	private void add(Node root,int c, int d) {
		if(c == 1) {
			root.next = new Node(d, root.next);
		}else {
			add(root.next,c-1, d);
		}
	}
	
	private void print(Node root) {
		
//		if(root == null) {
//			return;
//		}else {
//			System.out.println(root.data);
//			print(root.next);
//		}
		
		while(root!=null) {
			System.out.println(root.data);
			root = root.next;
		}
	}
	
	public static int[] copy(int[] a) {
		int[] ss = a;
		ss[0] = 0;
		return ss;
	}
	
	public static void modify(int[] a) {
		int[] ss = a;
		ss[0] = 0;
	}
	
	private static class Node {
		int data;
		Node next;
		
		
		Node(int d, Node n){
			data = d;
			next =n;
		}
		

	}

}
