package QuickSorting;

import java.awt.Panel;

public class QuickAlgorithm extends Thread{
	private int[] arr;
	private Panel p;
	
	public QuickAlgorithm(int[] arr, Panel p){
		this.arr = arr;
		this.p = p;
	}
	
	@Override
	public void run() {
		Sort(arr, 0, arr.length-1);
	}
	
	private void Sort(int[] array, int left, int right) {
		int l =left;
		int r = right;
		int temp;
		
		//中间那个数
		int pivot = array[(left+right)/2];
		
		//只要左边索引小于右边的索引,一直循环
		while(l < r) {
			//比pivot小的放在左边，比pivot大的放在右边
			//在pivot的左边一直找，直到找到比pivot大或相等的值
			while(array[l] < pivot) {
				l+=1;
			}
			//在pivot右边找，直到找到比pivot小或相等的值
			while(array[r] > pivot) {
				r-=1;
			}
			if(l>=r) {
				break;
			}
			
			//交换
			temp =array[l];
			array[l]=array[r];
			array[r] =temp;
			
			p.repaint();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//交换后发现array[l] == pivot的值 r--;前移
			if(array[l] == pivot) {
				r -=1;
			}
			
			//交换后发现array[r] == pivot的值 l++;前移
			if(array[r] == pivot) {
				l +=1;
			}
			
		}
		
		if(l == r) {
			l +=1;
			r -=1;
		}
		
		//向左递归
		if(left < r) {
			Sort(array, left, r);
		}
		
		//向右递归
		if(l < right) {
			Sort(array, l, right);
		}
	}
	
}
