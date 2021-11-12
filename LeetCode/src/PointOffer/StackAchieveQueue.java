package PointOffer;

import java.util.Stack;

public class StackAchieveQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Character> q = new MyQueue<>();
		q.appendTail('a');
		q.appendTail('b');
		q.appendTail('c');
		System.out.println(q.deleteHead());
		System.out.println(q.deleteHead());
		System.out.println(q.deleteHead());
	}
	
	private static class MyQueue<E>{
		private Stack<E> A;
		private Stack<E> B;
		public MyQueue() {
			// TODO Auto-generated constructor stub
			this.A = new Stack<>();
			this.B = new Stack<>();
		}
		
		public void appendTail(E element) {
			A.push(element);
		}
		
		public E deleteHead() {
			if(B.isEmpty()) {
				if(A.isEmpty())
					return null;
				while(!A.empty()) {
					B.push(A.pop());
				}
			}
			return B.pop();
		}
		
	}

}
