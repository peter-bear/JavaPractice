package DataStructure;

import java.util.AbstractList;

public class LinkedListStackDemo2<E>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStackDemo2<Integer> stack= new LinkedListStackDemo2<>();
		System.out.println("\tÑ¹Õ»");
		stack.push(120);
		stack.push(220);
		stack.push(221);
		stack.push(449);
		
		System.out.println("ShowAll");
		stack.ShowAll();
		
		System.out.println("Size");
		System.out.println(stack.Size);
		
		System.out.println("³öÕ»");
		System.out.println(stack.pop());
		
		System.out.println("Size");
		System.out.println(stack.Size);
		
		System.out.println("Peek");
		System.out.println(stack.peek());

	}
	
	private Node<E> head=null;
	private int Size=0;
	
//	Return the Size of this Queue
	public int size() {
		return Size;
	}
	
//	Return whether this queue is Empty
	public boolean isEmpty() {
		return head == null;
	}
	
//	Add new item into the queue
	public void push(E item) {
		if(isEmpty()) {
			head = new Node<>(item);
			Size++;
			return;
		}
		
		head = new Node<>(item, head);
		Size++;
	}
	
//	Return the top data
	public Node<E> peek() {
		if(isEmpty())
			return null;
		return new Node<>(head.data);
	}
	
//	Return the top data
	public Node<E> pop(){
		Node<E> temp = head;
		if(!isEmpty()) {
			head = head.next;
			Size--;
		}
		return temp;
	}
	
//	Show all the items in the stack
	public void ShowAll() {
		ShowAll(head);
	}
	
//	Internal Method For Showing the items
	private void ShowAll(Node<E> root) {
		if(root == null)
			return;
		else {
			System.out.println(root);
			ShowAll(root.next);
		}
	}
	
	private static class Node<E>{
		E data;
		Node<E> next;
		public Node(E d) {
			data =d;
			next =null;
		}
		
		public Node(E d, Node<E> n) {
			data =d;
			next =n;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[ data: "+data+" ]";
		}
		
		
	}
	

}
