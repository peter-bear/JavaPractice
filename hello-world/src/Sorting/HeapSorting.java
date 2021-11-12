package Sorting;

import java.util.Arrays;

public class HeapSorting {

	public static void main(String[] args) {
		int[] arr = { 35, 10, 25, 15, 30, 40, 20, 50, 45 };
//		int[] arr = {101,34,119,1};
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void Sort(int[] arr) {
		int temp;

		// 由下往上构建大顶堆,i指的是倒数位于中间的结点元素
		for (int i = arr.length / 2 - 1; i > -1; i--) {
			heap(arr, i, arr.length);
		}

		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			heap(arr, 0, j);
		}
	}

	// 建立大顶堆
	public static void heap(int[] arr, int index, int len) {
		int temp = arr[index]; // 用temp储存最顶端的值

		// for循环只要k值即小于len的时候，才能开始遍历数组
		// bigger = bigger*2+1 指向左遍历
		for (int bigger = 2 * index + 1; bigger < len; bigger = bigger * 2 + 1) {
			// 三个数进行比较，左、中、右，默认左边大于右边
			// 如果右边大于左边，且右边有值时
			// 右边是index*2 +2 = bigger +1
			if (bigger + 1 < len && arr[bigger] < arr[bigger + 1]) {
				bigger++; // 更大的是右边
			}

			// 如果此时左边或者右边中更大的数大于中间的数
			if (arr[bigger] > temp) {
				// 中间的数与最大的数交换位置
				arr[index] = arr[bigger];
				// 用index记下最大的数原来的下标，方便向下查找比较
				index = bigger;
			} else {
				break;
			}
		}

		// 最后再交换最小的数
		arr[index] = temp;

	}

//	public static void Sort(int[] arr, int index, int len) {
//		int left = 2*index +1;
//		int right = 2*index +2;
//		int bigger = left;
//		int temp;
//		if(left < arr.length) {
//			Sort(arr, left, len);
//		}
//		if(right < arr.length) {
//			Sort(arr, right, len);
//		}
//		
//		if(left < arr.length && right < arr.length) {
//			if(arr[right] >= arr[left]) {
//				bigger =right;
//			}
//			if(arr[index] < arr[bigger]) {
//				temp = arr[index];
//				arr[index] = arr[bigger];
//				arr[bigger] = temp;
//			}
//		}
//				
//		temp = arr[len-1];
//		arr[len-1] = arr[0];
//		arr[0] = temp;
//		
//	}

}
