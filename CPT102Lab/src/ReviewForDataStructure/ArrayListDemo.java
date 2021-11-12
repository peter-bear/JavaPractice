package ReviewForDataStructure;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListDemo<E> implements Iterable<E>{
	private int length=0;
	private int Init_Capacity=10;
	private int MaxSize;
	private E data[];
	public ArrayListDemo() {
		// TODO Auto-generated constructor stub
		data = (E [])new Object[Init_Capacity];
		this.MaxSize = Init_Capacity;
	}
	
	public ArrayListDemo(int capacity) {
		data =(E [])new Object[capacity];
		this.MaxSize = capacity;
	}
	
	public void add(E element) {
		
		ensureCapacity();
		
		data[length]=element;
		length ++;
	}
	
	public boolean isEmpty() {
		return getSize() ==0;
	}
	
	public boolean delete(E element) {
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		for(int i=0;i<length;i++) {
			if(data[i].equals(element)) {
				data[i]= data[data.length-1];
				data[data.length-1] = null;
				return true;
			}
		}
		return false;
	}
	
	public int getSize() {
		return length;
	}
	
	private void ensureCapacity() {
		if(this.length >= (MaxSize-1)) {
			E[] temp = (E [])new Object[(this.MaxSize+1)*2];
			System.arraycopy(data, 0,temp , 0, this.MaxSize);
			data = temp;
		}
	}
	

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListDemo.ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<E>{
		
		private int current=0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current < length;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return data[current++];
		}
		
	}
	
	


}
