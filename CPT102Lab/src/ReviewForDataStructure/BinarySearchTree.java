package ReviewForDataStructure;

import java.util.Comparator;

public class BinarySearchTree<E extends Comparable<E>>{
	private BinaryNode<E> root;
	private Comparator<E> cmp;
	
	/**
	 * Binary Tree Node, referring left_node and right_node
	 * can store one element(Any Type)  
	 * @author 23881
	 *
	 * @param <E>
	 */
	private static class BinaryNode<E> {
		E data;
		BinaryNode<E> left_Node;
		BinaryNode<E> right_Node;
		
		public BinaryNode(E element) {
			this(element, null, null);
		}
		
		public BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
			data = element;
			left_Node = left;
			right_Node =right;
		}

//		@Override
//		public int compareTo(BinaryNode<E> o) {
//			// TODO Auto-generated method stub
//			return data.hashCode() - o.data.hashCode();
//		}
		
		
	}
	
	public BinarySearchTree(){
		this(null);
	}
	
	public BinarySearchTree(Comparator<? super E> c){
		root = null;
		cmp = (Comparator<E>) c;
	}
	
	public void MakeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean contains(E x) {
		return contains(x, root);
	}
	
	public E findMin() {
		if(isEmpty())
			throw new NullPointerException();
		return findMin(root).data;
	}
	
	public E findMax() {
		if(isEmpty())
			throw new NullPointerException();
		return findMax(root).data;
	}
	
	public void insert(E x) {
		root = Insert(x, root);
	}
	
	public void remove(E x) {
		root = remove(x, root);
	}
	
	public void infixOrder() {
		inOrder(root);
		System.out.println();
	}
	
	private void inOrder(BinaryNode<E> rt) {
		if(rt.left_Node!= null)
			inOrder(rt.left_Node);
		System.out.printf(rt.data+" ");
		if(rt.right_Node!=null)
			inOrder(rt.right_Node);
	}
	
	private int MyCompare(E e1, E e2) {
		if(cmp != null)
			return cmp.compare(e1, e2);
		else {
			return e1.compareTo(e2);
		}
	}
	
	/**
	 * Internal Method to find whether tree contains the item 
	 * @param x
	 * @param rt
	 * @return true means find, false means not find 
	 */
	private boolean contains(E x, BinaryNode<E> rt) {
		if(rt == null)
			return false;
		int compareResult = MyCompare(x, rt.data);
		if(compareResult < 0)
			return contains(x, rt.left_Node);
		else if(compareResult >0)
			return contains(x, rt.right_Node);
		else
			return true;
	}
	
	/* Recrusive implementation of findMin and nonrecrusive implementation of findMax for binary search tree */
	private BinaryNode<E> findMax(BinaryNode<E> rt){
		if(rt !=null)
			while(rt.right_Node != null)
				rt = rt.right_Node;
		return rt;
	}
	
	/**
	 * Internal Method to find the smallest item in a subtree;
	 * @param rt the node that roots the subtree
	 * @return node containing the smallest item;
	 */
	private BinaryNode<E> findMin(BinaryNode<E> rt){
		if(rt == null)
			return null;
		else if(rt.left_Node == null)
			return rt;
		return findMin(rt.left_Node); //使用递归,直到找到最左边
		
	}
	
	/**
	 * Internal method to insert into a subtree
	 * @param x the item to insert
	 * @param rt the node that roots the subtree
	 * @return the new root of the subtree
	 */
	private BinaryNode<E> Insert(E x, BinaryNode<E> rt){
		if(rt ==null)
			return new BinaryNode<>(x, null, null);
		
		int compareResult = x.compareTo(rt.data);
		if(compareResult <0)
			rt.left_Node = Insert(x,rt.left_Node);
		else if(compareResult >0)
			rt.right_Node = Insert(x, rt.right_Node);
		
		return rt;
	}
	
	/**
	 * Internal method to remove from a subtree
	 * @param x the item to remove
	 * @param rt the node that roots the subtree
	 * @return the new root of the subtree
	 */
	private BinaryNode<E> remove(E x, BinaryNode<E> rt){
		if(rt ==null)
			return rt;
		
		int compareResult = x.compareTo(rt.data);
		
		if(compareResult <0)
			rt.left_Node = remove(x, rt.left_Node);
		else if(compareResult >0)
			rt.right_Node = remove(x, rt.right_Node);
		
		//two children
		else if(rt.left_Node != null && rt.right_Node != null) {
			rt.data = findMin(rt.right_Node).data; //直接替换
			rt.right_Node = remove(rt.data, rt.right_Node);
		}
		//find the node
		else {
			rt = (rt.left_Node != null) ? rt.left_Node : rt.right_Node;
		}
		return rt;
	}


	
	
}
