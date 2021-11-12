package SelectSorting;

import java.awt.Panel;

public class SelectAlgorithm extends Thread{
	private int[] arr;
	private Panel p;
	public SelectAlgorithm(int[] arr, Panel p) {
		this.arr = arr;
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<arr.length-1;i++) {
			int smallest =i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j] < arr[smallest])
					smallest = j;
			}
			
			if(i != smallest) {
				int temp = arr[i];
				arr[i] = arr[smallest];
				arr[smallest] = temp;
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
