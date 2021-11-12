package Sorting;

import java.util.Arrays;

public class RedixSorting {

	public static void main(String[] args) {
		int[] array = {77,26,93,17,54,0,107,31,44,55,20 };
		RadixSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void RadixSort(int[] array) {
		//�ҳ�����һλ
		int Max =0;
		for(int i=0;i<array.length;i++) {
			if(array[Max] <array[i]) {
				Max =i;
			}
		}
		
		//�ó����һλ�ĸ���
		int count=0;
		int temp =array[Max];
		while(temp>0) {
			temp /= 10;
			count++;
		}
		for(int j=0;j<count;j++) {
			busket(array, pow(10,j));
		}
		
		
	}
	
	//����һ�����ļ��η�
	public static int pow(int num, int exp) {
		if(exp==0) {
			return 1;
		}
		for(int i=0;i<exp-1;i++) {
			num *= num;
		}
		return num;
	}
	
	public static void busket(int[] array, int digit) {
		//����һ��Ͱ������¼����
		int[][] bucket = new int[10][array.length];
		
		//����һ����������¼ÿ��Ͱ����Ԫ�صĸ���
		int[] itemNum = new int[10];
		
		for(int i=0;i<array.length;i++) { 
		
			int no = array[i]/digit%10; //��һ��Ͱ
			
			bucket[no][itemNum[no]] = array[i]+10; //����©��0
			itemNum[no] +=1;
		}
		
//		for(int i=0;i<bucket.length;i++) {
//			System.out.println(Arrays.toString(bucket[i]));
//		}
		
		int index=0;
		for(int j=0;j<10;j++) {
			for(int k=0;k<bucket.length;k++) {
				if(bucket[j][k] !=0) {
					array[index] = bucket[j][k]-10; //�ָ�����
					bucket[j][k] =0;
					index++;
				}
				else {
					break;
				}
			}
			itemNum[j] =0;
		}
		index =0;
		
		
	}
	

}
