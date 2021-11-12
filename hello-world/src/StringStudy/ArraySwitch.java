package StringStudy;

import java.util.Arrays;

public class ArraySwitch {
	public static void main(String[] args) {
		int[] list = {3, 4, 2, 9, 8, 1};
		System.out.println("起初:"+ Arrays.toString(list));
		System.out.print("遍历:");
		for(int i:list) {
			System.out.println("\t"+i);
		}
		Switch(list);
		System.out.println("转换后:"+Arrays.toString(list));
		Arrays.sort(list);
		System.out.println("排序："+Arrays.toString(list));
	}
	private static void Switch(int[] array) {
		int j = array.length-1;
		for(int i=0;i< array.length/2; i++) {
			if (array[i] > array[j]){
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
			j -=1;
		}
	}
}
