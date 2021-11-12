package Sorting;

import java.util.Arrays;

public class ShellSorting {

	public static void main(String[] args) {
//		int[] array = {77,26,93,17,54,31,44,55,20 };
		int[] array = {59,48,75,107,86,23,37,59,65,14 };
		int length = array.length;
		int temp;
		//步长
		for(int step = length/2;step >0; step /=2) {
			//插入算法循环次数
			for(int i=step;i<length;i++) {
				//控制插入算法的比较和交换
				//移位法
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
				 * 换位法
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
