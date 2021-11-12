package lecture5;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class NaturalOrderTest {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(66);
		list.add(33);
		list.add(66);
		list.add(68);
		list.add(23);
		list.add(78);
		
		LinkedList<Node> list2 = new LinkedList<>();
		for(Integer i:list) {
			list2.add(new Node(i));
		}
//		Node node = new Node(23);
		Collections.sort(list2, new ComparatorClass());
		System.out.println(list2);
		
	}
	
	
}

class Node implements Comparable<Node> {
	int num;
	Node(int num){
		this.num = num;
	}
	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		int num2 = arg0.num;
		return num - num2;
	}
	@Override
	public String toString() {
		return num+"";
	}
	
	
	
}


class ComparatorClass implements Comparator<Node>{

	@Override
	public int compare(Node arg0, Node arg1) {
		// TODO Auto-generated method stub
		return arg1.num-arg0.num;
	}
	
}

class MyList implements Iterable<MyList>{

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}