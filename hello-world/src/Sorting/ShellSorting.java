package Sorting;

import java.util.Arrays;

public class ShellSorting {

	public static void main(String[] args) {
//		int[] array = {77,26,93,17,54,31,44,55,20 };
		int[] array = {59,48,75,107,86,23,37,59,65,14 };
		int length = array.length;
		int temp;
		//����
		for(int step = length/2;step >0; step /=2) {
			//�����㷨ѭ������
			for(int i=step;i<length;i++) {
				//���Ʋ����㷨�ıȽϺͽ���
				//��λ��
				temp = array[i];
				int j =i;
				if(array[j] < array[j-step]) {
					while(j>=step && temp<array[j-step]) {
						array[j] = array[j - step];
						j-=step;
					}
				}
				
	            array[j] = temp;
	            
				
				/**
				 * ��λ��
				for(int j=i;j>=step;j-=step) {
					if(array[j]<array[j-step]) {
						temp = array[j];
						array[j] = array[j-step];
						array[j-step] = temp;
					}
					else
						break;
				}
				*/
			}
			System.out.println(Arrays.toString(array));
		}
		
				

	}

}
