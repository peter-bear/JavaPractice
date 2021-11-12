package ReviewForDataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<E> implements Iterable<E>{

	
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		doClear();
	}
	
	public void clear() {
		doClear();
	}
	
	private void doClear() {
		beginMaker = new Node<E>(null, null, null);
		endMaker = new Node<E>(null, beginMaker, null);
		beginMaker.next = endMaker;
		
		theSize = 0;
		
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean add(E x) {
		add(size(), x);
		return true;
	}
	
	public void add(int idx, E x) {
		addBefore(getNode(idx, 0, size()),x);
	}
	
	public E get(int idx) {
		return getNode(idx).data;
	}
	
	public E Set(int idx, E newVal) {
		Node<E> p = getNode(idx);
		E oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	
	public E remove(int idx) {
		return remove(getNode(idx));
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyLinkedList.LinkedListIterator();
	}
	
	
	private int theSize=0;
	private Node<E> beginMaker;
	private Node<E> endMaker;
	
	
	
	private void addBefore(Node<E> p, E x) {
		Node<E> newNode = new Node<>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize ++;
	}
	
	private E remove(Node<E> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		return p.data;
	}
	
	private Node<E> getNode(int idx){
		return getNode(idx, 0, size()-1);
	}
	
	private Node<E> getNode(int idx, int lower, int upper){
		Node<E> p;
		if(idx<lower || idx > upper)
			throw new IndexOutOfBoundsException();
		if(idx<size()/2) {
			p=beginMaker.next;
			for(int i=0;i<idx;i++)
				p=p.next;
		}else {
			p=endMaker;
			for(int i=size();i>idx;i--)
				p=p.prev;
		}
		return p;
	}
	
	private static class Node<E>{
		public E data;
		public Node<E> prev;
		public Node<E> next;
		public Node(E d, Node<E> p, Node<E> n){
			data = d;
			prev = p;
			next = n;
		}
	}
	
	private class LinkedListIterator implements Iterator<E> {
		private Node<E> current = beginMaker.next;
//		private boolean okToRemove = false;
		
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
			current = current.next;
//			okToRemove = true;
			return nextItem;
		}
		
	}
	

}
