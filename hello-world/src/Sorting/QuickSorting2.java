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
			//���������
			while(array[l]<pivot) {
				l+=1;
			}
			//�ұ�������
			while(array[r]>pivot) {
				r -=1;
			}
			if(l>=r) {
				break;
			}
			
			temp =array[l];
			array[l]=array[r];
			array[r] = temp;
			
			//��������array[l] == pivot��ֵ r--;ǰ��
			if(array[l] == pivot) {
				r -=1;
			}
			
			//��������array[r] == pivot��ֵ l++;ǰ��
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
