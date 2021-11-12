package Sorting;

import java.util.Arrays;

public class QuickSorting2 {
	public static void main(String[] args) {
//		int[] array = {59,48,75,107,86,23,37,59,65,14 };
		int[] array = {77,26,93,17,54,31,44,55,20 };
		QuickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void QuickSort(int[] array, int left, int right) {
		int l =left;
		int r =right;
		int temp;
		int pivot = array[(left+right)/2];
		while(l<r) {
			//左边往右走
			while(array[l]<pivot) {
				l+=1;
			}
			//右边往左走
			while(array[r]>pivot) {
				r -=1;
			}
			if(l>=r) {
				break;
			}
			
			temp =array[l];
			array[l]=array[r];
			array[r] = temp;
			
			//交换后发现array[l] == pivot的值 r--;前移
			if(array[l] == pivot) {
				r -=1;
			}
			
			//交换后发现array[r] == pivot的值 l++;前移
			if(array[r] == pivot) {
				l +=1;
			}
			
		}
		
		if(left<r) {
			QuickSort(array, left, r-1);
		}
		if(right>r) {
			QuickSort(array, l+1, right);
		}
	}
}
