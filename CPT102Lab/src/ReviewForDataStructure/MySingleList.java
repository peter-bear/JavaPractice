package ReviewForDataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySingleList<E> implements Iterable<E>{
	public MySingleList() {
		doClear();
	}
	
	public void clear() {
		doClear();
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void add(E element) {
		add(size(), element);
	}
	
	public void add(int idx, E element) {
		addAfter(getNode(idx, 0, size()),element);
	}
	
	public E getData(int idx) {
		return getNode(idx+1, 0, size()).data;
	}
	
	public E remove() {
		return remove(size()-1);
	}
	
	public E remove(int idx) {
		Node<E> pre = getNode(idx, 0, size());
		Node<E> node = getNode(idx+1, 0, size());
		pre.next = node.next;
		theSize--;
		return node.data;
	}
	
	private static class Node<E>{
		public Node<E> next;
		public E data;
		public Node(E data, Node<E> nx){
			this.data = data;
			this.next = nx;
		}
	}
	
	private class MyListIterator implements Iterator<E>{
		Node<E> current = beginMaker.next;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != endMaker;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			
			E nextItem = current.data;
			current  = current.next;
//			System.out.println("\n----"+nextItem);
			return nextItem;
		}
		
	}
	
	private void addAfter(Node<E> p, E element) {
		p.next = new Node<E>(element,p.next);
		theSize++;
	}
	
	/**
	 * always get the pointed node
	 * @param idx
	 * @param lower
	 * @param upper
	 * @return
	 */
	private Node<E> getNode(int idx, int lower, int upper) {
		if(idx<lower || idx > upper) {
			throw new NullPointerException();
		}
		
		Node<E> p=beginMaker;
		
		for(int i=0;i<idx;i++) {
			p=p.next;
		}
		
		return p;
	}
	
	private void doClear() {
		endMaker = new Node<E>(null, null);
		beginMaker = new Node<E>(null, endMaker);
		
		theSize =0;
	}
	
	private Node<E> beginMaker;
	private Node<E> endMaker;
	private int theSize=0;
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyListIterator();
	}
	
}
