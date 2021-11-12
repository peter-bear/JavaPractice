package Sorting;

import java.util.Arrays;

public class QuickSorting4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {77,26,93,17,54,31,44,55,20 };
		quicksort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void quicksort(int[] a) {
		quicksort(a, 0, a.length-1);
	}
	
	private static void swapReference(int[] a, int n, int m) {
		int temp = a[n];
		a[n] = a[m];
		a[m] = temp;
	}
	
	private static int median3(int[] a, int left, int right) {
		int center =(left+right)/2;
		if(a[center] < a[left])
			swapReference(a, left, center);
		if(a[right] < a[left])
			swapReference(a, left, right);
		if(a[right]<a[center])
			swapReference(a, center, right);
		
		swapReference(a, center, right-1);
		return a[right-1];
	}
	
	private static final int CUTOFF =10;
	
	private static void quicksort(int[] a, int left, int right) {
		if(left + CUTOFF <= right) {
			int pivot = median3(a, left, right);
			
			int i = left;
			int j = right-1;
			while(true) {
				while(a[i] < pivot) {
					i++;
				}
					
				while(a[j]>pivot) {
					j--;
				}
					
				
				if(i<j)
					swapReference(a, i, j);
				else {
					break;
				}
				

			}
			
			swapReference(a, i, right-1);
			
			quicksort(a, left, i-1);
			quicksort(a, i+1, right);
		
			
		}else {
			InsertSorting.insertsort(a, left, right);
		}
	}

}
