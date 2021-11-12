package PointOffer;

import java.util.Arrays;

public class SwitchOddAndEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5};
		SwitchNum(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void SwitchNum(int[] arr) {
		int left=0;
		int right = arr.length-1;
		int tmp=0;
		while(left<right) {
			while((left<right)&&(arr[left]&0x1)!=0)
				left++;
			while((left<right)&&(arr[right]&0x1)==0)
				right--;
			
			if(left<right) {
				tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}

			
		}
	}

}
