package MultiThreadsStudy.ConsumerAndProductor;



public class Pro implements Runnable {
	private Container Breads;
	public void Produce(Container b) {
		this.Breads = b;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			this.Breads.add(i);

			
		}
		
	}
	
}
