package Sorting;

import java.util.Arrays;

public class RedixSorting {

	public static void main(String[] args) {
		int[] array = {77,26,93,17,54,0,107,31,44,55,20 };
		RadixSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void RadixSort(int[] array) {
		//找出最大的一位
		int Max =0;
		for(int i=0;i<array.length;i++) {
			if(array[Max] <array[i]) {
				Max =i;
			}
		}
		
		//得出最大一位的个数
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
	
	//计算一个数的几次方
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
		//创建一个桶用来记录数据
		int[][] bucket = new int[10][array.length];
		
		//创建一个数组来记录每个桶里面元素的个数
		int[] itemNum = new int[10];
		
		for(int i=0;i<array.length;i++) { 
		
			int no = array[i]/digit%10; //哪一个桶
			
			bucket[no][itemNum[no]] = array[i]+10; //避免漏掉0
			itemNum[no] +=1;
		}
		
//		for(int i=0;i<bucket.length;i++) {
//			System.out.println(Arrays.toString(bucket[i]));
//		}
		
		int index=0;
		for(int j=0;j<10;j++) {
			for(int k=0;k<bucket.length;k++) {
				if(bucket[j][k] !=0) {
					array[index] = bucket[j][k]-10; //恢复数据
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
