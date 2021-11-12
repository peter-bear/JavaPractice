package Sorting;

import java.util.Arrays;

public class MergeSorting {
	public static void main(String[] args) {
//		int[] array = {59,48,75,107,86,23,37,59,65,14 };
		int[] array = {77,26,93,17,54,31,44,55,20 };
		MergeSort(array);
		System.out.println(Arrays.toString(array));
		
	}
	
	public static void MergeSort(int[] arr) {
		int[] arr2 = Divide(arr);
		for(int i=0;i<arr2.length;i++) {
			arr[i]=arr2[i];
		}
	}
	
	public static int[] Divide(int[] arr) {
		int pivot = (arr.length)/2;
		if(pivot>=1) {
			int[] left = new int[pivot];
			int[] right = new int[arr.length-pivot];
			for(int i=0;i<left.length;i++) {
				left[i] = arr[i];
			}
			for(int j=0;j<right.length;j++) {
				right[j]=arr[pivot+j];
			}
			
//			System.out.println(Arrays.toString(left));
//			System.out.println(Arrays.toString(right));
//			System.out.println("---");
			left = Divide(left);
			right = Divide(right);
		
			return Conquer(left, right);
		}
//		System.out.println(Arrays.toString(arr));
		return arr;
	
	}
	
	
	public static int[] Conquer(int[] arr1, int[] arr2) {
		int[] temp = new int[arr1.length+arr2.length];
		int cur =0;
		int left =0;
		int right =0;
		while(true) {
			if(arr1[left]<arr2[right]) {
				temp[cur] = arr1[left];
				cur++;
				left++;
			}
			else if(arr1[left] > arr2[right]) {
				temp[cur] = arr2[right];
				cur++;
				right++;
			}
			else {
				temp[cur] =arr1[left];
				cur++;
				left++;
				temp[cur] = arr2[right];
				cur++;
				right++;
			}
			if(left>=arr1.length) {
				for(int i=right;i<arr2.length;i++) {
					temp[cur] = arr2[i];
					cur++;
				}
				break;
			}
			else if(right>=arr2.length){
				for(int i=left;i<arr1.length;i++) {
					temp[cur] = arr1[i];
					cur++;
				}
				break;
			}
		}
		
		return temp;
	}
	
}
