package BubbleSorting;

import java.awt.Panel;


public class BubbleAlgorithm extends Thread{
	private int[] arr;
	private Panel p;
	public BubbleAlgorithm(int[] arr, Panel p){
		this.arr = arr;
		this.p = p;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int temp =0;
		for(int i=arr.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					p.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
	}
}
