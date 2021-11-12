package Search;

import java.util.Arrays;

public class FibonacciSearching {
	public static void main(String[] args) {
		int[] array = {17, 20, 26, 31, 44,44, 54, 55, 77, 93};
		System.out.println(Search(array, 44));
		
	}
	
	//得到斐波那契数列
	public static int[] fib() {
		int[] f =new int[20];
		f[0]=1;
		f[1]=1;
		for(int i=2;i<f.length;i++) {
			f[i] = f[i-1]+f[i-2];
		}
		return f;
	}
	
	//查找
	//斐波那契算法: mid = low + F(k-1) -1
	public static int Search(int[] array, int num) {
		int low =0;
		int high = array.length-1;
		int k=0; //斐波那契数列的下标
		int mid =0;
		int[] f = fib(); //获取数列
		while(high > f[k]-1) {
			k++;
		}
		int[] temp =Arrays.copyOf(array, f[k]);
		for(int i=high+1;i<temp.length;i++) {
			temp[i] = array[high];
		}
		while(low <=high) {
			mid = low+f[k-1]-1;
			if(num < temp[mid]) {
				high =mid-1;
				k--;
			}
			else if(num > temp[mid]) {
				low =mid-1;
				k-=2;
			}
			else {
				if(mid <=high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
}
