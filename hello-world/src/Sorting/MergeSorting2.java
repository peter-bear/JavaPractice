package Sorting;

import java.util.Arrays;

public class MergeSorting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 35, 10, 25, 15, 30, 40, 20, 50, 45 };
		MergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * Internal method that makes recurisive calls
	 * @param <AnyType>
	 * @param a an array of Comparable items
	 * @param tempArr an array to place the merged result
	 * @param left the left-most index of the subarray
	 * @param right the right-most index of the subarray
	 */
	/*Divide*/
	private static <AnyType extends Comparable<? super AnyType>> void MergeSort(AnyType[] a, AnyType[] tempArr, int left, int right) {
		if(left<right) {
			int center =(left+right)/2;
			MergeSort(a, tempArr, left, center);
			MergeSort(a, tempArr, center+1, right);
			merge(a, tempArr, left, center+1, right);
		}
	}
	
	/**
	 * 
	 * @param <AnyType>
	 * @param a an array of Comparable items
	 * @param tempArr an array to place the merged result
	 * @param leftPos the left-most index of the subArray
	 * @param rightPos the index of the start of the second subArray
	 * @param rightEnd the right-most index of the subArray
	 */
	/*Conquer*/
	private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tempArr, int leftPos, int rightPos, int rightEnd) {
		// TODO Auto-generated method stub
		int leftEnd = rightPos-1;
		int tempPos = leftPos;
		int numElements = rightEnd - leftPos+1;
		/*Main Loop*/
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if(a[leftPos].compareTo(a[rightPos])<=0)
				tempArr[tempPos++] = a[leftPos++];
			else {
				tempArr[tempPos++] = a[rightPos++];
			}
		}
		
		/**
		 * copy the rest
		 */
		while(leftPos<=leftEnd)
			tempArr[tempPos++] = a[leftPos++];
		
		while(rightPos<=rightEnd)
			tempArr[tempPos++] = a[rightPos++];
		
		/*Copy the tempArray*/
		for(int i=0;i<numElements;i++, rightEnd--)
			a[rightEnd] = tempArr[rightEnd];
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void MergeSort(AnyType[] a) {
		AnyType[] tempArr = (AnyType[]) new Comparable[a.length];
		MergeSort(a, tempArr, 0, a.length-1);
	}

}
