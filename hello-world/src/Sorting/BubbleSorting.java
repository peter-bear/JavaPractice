package Sorting;

import java.util.Arrays;

public class BubbleSorting {
	public static void main(String[] args) {
//		int[] array = {3, 9, -1, 10, -2};
		int[] array = {3,2,6,4,5};
		int tmp =0;
		boolean flag=false; //flag�ж��Ƿ���������򽻻�
		for(int i=array.length-1; i>0; i--) {
			for(int j=0;j< i;j++) {
				if(array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] =tmp;
					flag = true;
				}
			}
			System.out.println("��"+(array.length-i)+"�α���");
			System.out.println(Arrays.toString(array));
			if(!flag) {
				break;
			}else {
				flag = false; //�����ж���һ����û�н��������û�У���ʾ����������
			}
		}
	}
}
