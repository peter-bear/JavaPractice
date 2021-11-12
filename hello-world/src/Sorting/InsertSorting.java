package Sorting;

import java.util.Arrays;

public class InsertSorting {

	public static void main(String[] args) {
		int[] array = { 93, 54, 77, 31, 44, 226, 55 };
//		int temp;
//		//换位法
//		for (int i = 1; i < array.length; i++) {
//			for (int j = i; j > 0; j--) {
//				if (array[j] < array[j - 1]) {
//					temp = array[j];
//					array[j] = array[j - 1];
//					array[j - 1] = temp;
//				}else {
//					break;
//				}
//			}
////移位法
////			temp = array[i];
////			int j =i;
////			while(j>0 && temp<array[j-1]) {
////				array[j] = array[j - 1];
////				j--;
////			}
////			
////			if (j != i) {
////                array[j] = temp;
////            }
//			System.out.println("第" + i + "轮：" + Arrays.toString(array));
//		}
		
		insertsort(array, 0, array.length);
		System.out.println(Arrays.toString(array));

	}
	
	public static void insertsort(int[] array, int left, int right) {
		int temp;
		for (int i = left+1; i < right; i++) {
			for (int j = i; j > left; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}else {
					break;
				}
			}
		}
	}
}
