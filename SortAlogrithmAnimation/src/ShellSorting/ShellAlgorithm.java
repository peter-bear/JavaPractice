package ShellSorting;

import java.awt.Panel;

public class ShellAlgorithm extends Thread{
	private int[] arr;
	private Panel p;
	
	public ShellAlgorithm(int[] arr, Panel p) {
		this.arr = arr;
		this.p = p;
	}

	@Override
	public void run() {
		int length = arr.length;
		int temp=0;
		for(int step = length/2; step >0 ;step /=2) {
			for(int i=step;i<length;i++) {
				temp=arr[i];
				int j=i;
				if(arr[j]<arr[j-step]) {
					while(j>=step && temp<arr[j-step]) {
						arr[j] =arr[j-step];
						j -=step;
					}
				}
				arr[j] = temp; 
				if(i != j)
					draw();
			}
			
		}
	}
	
	private void draw() {
		p.repaint();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
