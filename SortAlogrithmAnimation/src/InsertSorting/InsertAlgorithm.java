package InsertSorting;

import java.awt.Panel;

public class InsertAlgorithm extends Thread{
	private int[] arr;
	private Panel p;
	public InsertAlgorithm(int[] arr, Panel p) {
		this.arr = arr;
		this.p = p;
	}

	@Override
	public void run() {
		int temp=0;
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j] < arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					p.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					break;
				}
			}
		}
	}
	
	
	
}
