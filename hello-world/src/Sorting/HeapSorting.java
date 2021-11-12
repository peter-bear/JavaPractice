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

		// �������Ϲ����󶥶�,iָ���ǵ���λ���м�Ľ��Ԫ��
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

	// �����󶥶�
	public static void heap(int[] arr, int index, int len) {
		int temp = arr[index]; // ��temp������˵�ֵ

		// forѭ��ֻҪkֵ��С��len��ʱ�򣬲��ܿ�ʼ��������
		// bigger = bigger*2+1 ָ�������
		for (int bigger = 2 * index + 1; bigger < len; bigger = bigger * 2 + 1) {
			// ���������бȽϣ����С��ң�Ĭ����ߴ����ұ�
			// ����ұߴ�����ߣ����ұ���ֵʱ
			// �ұ���index*2 +2 = bigger +1
			if (bigger + 1 < len && arr[bigger] < arr[bigger + 1]) {
				bigger++; // ��������ұ�
			}

			// �����ʱ��߻����ұ��и�����������м����
			if (arr[bigger] > temp) {
				// �м����������������λ��
				arr[index] = arr[bigger];
				// ��index����������ԭ�����±꣬�������²��ұȽ�
				index = bigger;
			} else {
				break;
			}
		}

		// ����ٽ�����С����
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
