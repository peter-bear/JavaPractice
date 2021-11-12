package Sorting;

import java.util.Arrays;

public class QuickSorting3 {

	public static void main(String[] args) {
		int[] array = {77,26,93,17,54,31,44,55,20 };
		Sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void Sort(int[] array, int left, int right) {
		int l = left;
		int r = right;
		int pivot = array[left]; //以第一个数为基准
		while(true) {
			while(array[r] >= pivot&&l<r) {
				r-=1;
			}
			if(l<r) {
				array[l] =array[r];
				l+=1;
			}
			while(array[l] <= pivot&&l<r) {
				l +=1;
			}
			if(l<r) {
				array[r] = array[l];
				r -=1;
			}
			if(l==r) {
				array[l] = pivot;
				break;
			}
		}
		
		if(left<r) {
			Sort(array, left, r-1);
		}
		
		if(right > l) {
			Sort(array, l+1, right);
		}
	}

}
