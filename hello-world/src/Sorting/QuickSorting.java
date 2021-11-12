package Sorting;

import java.util.Arrays;

public class QuickSorting {
	public static void main(String[] args) {
		int[] array = {59,48,75,107,86,23,37,59,65,14 };
		Sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	//����һ�����飬��ߵ��������ұߵ�����
	public static void Sort(int[] array, int left, int right) {
		int l =left;
		int r = right;
		int temp;
		
		//�м��Ǹ���
		int pivot = array[(left+right)/2];
		
		//ֻҪ�������С���ұߵ�����,һֱѭ��
		while(l < r) {
			//��pivotС�ķ�����ߣ���pivot��ķ����ұ�
			//��pivot�����һֱ�ң�ֱ���ҵ���pivot�����ȵ�ֵ
			while(array[l] < pivot) {
				l+=1;
			}
			//��pivot�ұ��ң�ֱ���ҵ���pivotС����ȵ�ֵ
			while(array[r] > pivot) {
				r-=1;
			}
			if(l>=r) {
				break;
			}
			
			//����
			temp =array[l];
			array[l]=array[r];
			array[r] =temp;
			
			//��������array[l] == pivot��ֵ r--;ǰ��
			if(array[l] == pivot) {
				r -=1;
			}
			
			//��������array[r] == pivot��ֵ l++;ǰ��
			if(array[r] == pivot) {
				l +=1;
			}
			
		}
		
		if(l == r) {
			l +=1;
			r -=1;
		}
		
		//����ݹ�
		if(left < r) {
			Sort(array, left, r);
		}
		
		//���ҵݹ�
		if(l < right) {
			Sort(array, l, right);
		}
	}
}
