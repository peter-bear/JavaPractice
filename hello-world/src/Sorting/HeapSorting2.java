package Sorting;

import java.util.Arrays;

public class HeapSorting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 35, 10, 25, 15, 30, 40, 20, 50, 45 };
//		Integer[] arr= {7,3,4,6};
		HeapSorting(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * internal method for heapsort
	 * @param i the index of an item in the heap
	 * @return the index of the left child
	 */
	private static int leftChild(int i) {
		return 2*i +1;
	}
	
	/**
	 * Internal method for heapsort that is used in deleteMax and buildHeap
	 * @param <AnyType> anyType is a generic type
	 * @param a an array of comparable items
	 * @param i the position from which to precolate down
	 * @param n the logic size of the binary heap
	 */
	private static <AnyType extends Comparable <? super AnyType>> void precDown(AnyType[] a, int i, int n) {
		int child;
		AnyType temp;
		for(temp =a[i]; leftChild(i) < n;i=child) {
			child = leftChild(i);
			//找出三个中最大的
			if(child != n-1 && a[child].compareTo(a[child+1])<0) //判断左边小于右边
				child++;
			if(temp.compareTo(a[child])<0) //判断父结点是否小于子节点
				a[i] =a[child];
			else {
				break;
			}
		}
		a[i] =temp;
	}
	
	/**
	 * 
	 * @param <AnyType>
	 * @param a an array of Comparable items
	 * @param b the top item of the heap
	 * @param c the bottom item of the heap
	 */
	private static <AnyType extends Comparable<? super AnyType>> void SwapReference (AnyType[] a, int b, int c) {
		AnyType temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	} 
	
	/**
	 * Standard heapsort
	 * @param <AnyType>
	 * @param a an array of Comparable items
	 */
	public static <AnyType extends Comparable<? super AnyType>> void HeapSorting(AnyType[] a) {
		for(int i=a.length/2; i >=0 ;i--) { /*Build Heap*/
			precDown(a, i, a.length);
		}
		
		for(int i=a.length-1; i>0;i--) {
			SwapReference(a, 0, i); /*Delete the Max*/
			precDown(a, 0, i);
		}
		
	}

}
