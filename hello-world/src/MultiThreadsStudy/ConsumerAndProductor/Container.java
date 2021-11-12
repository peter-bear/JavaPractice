package MultiThreadsStudy.ConsumerAndProductor;

public class Container {
	private int index=0;
	private Bread[] breads = new Bread[5];
	public synchronized void add(int id) {
		if(index >= 4) {
			try {
				
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breads[this.index] =new Bread(id);
		System.out.println("Produce Bread : "+id);
		index++;
		this.notify();
	}
	public synchronized void sub(int id) {
		if(index <=0) {
			
			try {
				
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breads[this.index] = null;
		System.out.println("Consume Bread : "+id);
		index--;
		this.notify();
	}
}
