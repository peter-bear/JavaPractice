package Search;

import java.util.Arrays;

public class BinarySearching {
	public static void main(String[] args) {
		int[] array = {17, 20, 26, 31, 44,44, 54, 55, 77, 93};
//		System.out.println(search(array, 31, 0, array.length-1));
		System.out.println(search(array, 1));
	}

//·ÇµÝ¹é°æ±¾
	public static boolean search(int[] array, int num) {
		int left =0;
		int right = array.length-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(array[mid] == num) {
				return true;
			}
			else if(array[mid] > num) {
				right = mid -1;
			}
			else {
				left = mid+1;
			}
		}
		return false;
	}
	
	
	
//µÝ¹é°æ±¾
//	public static boolean search(int[] array, int num, int left, int right) {
//		int index = (left+right)/2;
//		if(left>right) {
//			return false;
//		}
//		print(array, left, right);
//		if(array[index] > num) {
//			return search(array, num, left, index-1);
//		}
//		else if(array[index] < num) {
//			return search(array, num, index+1, right);
//		}
//		else
//		{
//			
//			return true;
//		}
//		
//		
//	}
	
//	public static boolean search(int[] array, int num) {
//		int index = array.length/2;
//		if(array.length >=1){
//			if(array[index] > num) {
//				int[] left = Arrays.copyOfRange(array,0,index);
//				return search(left, num);
//			}
//			else if(array[index] < num) {
//				int[] right = Arrays.copyOfRange(array, index+1, array.length);
//				return search(right, num);
//			}
//			else if(array[index] == num) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	public static void print(int[] arr, int left, int right) {
		for(int i=left;i<=right;i++) {
			System.out.printf(arr[i]+" ");
		}
		System.out.println();
	}
}
