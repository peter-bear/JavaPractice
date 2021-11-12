package Sorting;

import java.util.Arrays;

public class SelectionSorting {

	public static void main(String[] args) {
		int[] array = {101,34,119,1};
		
		for(int i=0;i<array.length-1;i++) {
			int smallest=i;
			for(int j=i;j<array.length;j++) {
				if(array[j]< array[smallest]) {
					smallest = j;
				}
			}
			if(i!=smallest) {
				int temp = array[i];
				array[i] = array[smallest];
				array[smallest] = temp;
			}
			System.out.println("µÚ"+(i+1)+"ÂÖÑ­»·£º"+Arrays.toString(array));
		}
		
		
	}

}
