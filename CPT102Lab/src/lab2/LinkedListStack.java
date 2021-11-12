package lab2;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListStack<E> implements Cloneable{
	private LinkedList<E> data;
	
	/**
	 * Use linkedList to implement stack
	 */
	LinkedListStack(){
		data = new LinkedList<>();
	}
	
	/**
	 * this method can help us clone the stack
	 */
	public LinkedListStack<E> clone(){
		LinkedListStack<E> answer;
		try {
			answer = (LinkedListStack<E>) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("This class does not implement Cloneable");
		}
		answer.data = (LinkedList<E>) data.clone();
		return answer;
	}
	
	/**
	 * 
	 * @return whether the data linkedList is empty
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	/**
	 * have a look at but not remove
	 * @return the top item of the stack
	 * 
	 */
	public E peek() {
		if(data.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return data.get(data.size()-1);
	}
	
	/**
	 * remove the top one
	 * @return the top element of this stack
	 */
	public E pop() {
		if(data.isEmpty())
			throw new EmptyStackException();
		E info = data.get(size()-1);
		data.remove(info);
		return info;
	}
	
	/**
	 * 
	 * @return the size of this stack
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * 
	 * @param item the element user input
	 */
	public void push(E item) {
		data.add(item);
	}
}
