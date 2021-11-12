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
		
		//�м��Ǹ���
		int pivot = array[(left+right)/2];
		
		//ֻҪ�������С���ұߵ�����,һֱѭ��
		while(l < r) {
			//��pivotС�ķ�����ߣ���pivot��ķ����ұ�
			//��pivot�����һֱ�ң�ֱ���ҵ���pivot�����ȵ�ֵ
			while(array[l] < pivot) {
				l+=1;
			}
			//��pivot�ұ��ң�ֱ���ҵ���pivotС����ȵ�ֵ
			while(array[r] > pivot) {
				r-=1;
			}
			if(l>=r) {
				break;
			}
			
			//����
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
			
			
			//��������array[l] == pivot��ֵ r--;ǰ��
			if(array[l] == pivot) {
				r -=1;
			}
			
			//��������array[r] == pivot��ֵ l++;ǰ��
			if(array[r] == pivot) {
				l +=1;
			}
			
		}
		
		if(l == r) {
			l +=1;
			r -=1;
		}
		
		//����ݹ�
		if(left < r) {
			Sort(array, left, r);
		}
		
		//���ҵݹ�
		if(l < right) {
			Sort(array, l, right);
		}
	}
	
}
