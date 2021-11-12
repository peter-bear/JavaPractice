package MultiThreadsStudy.ConsumerAndProductor;



public class Cons implements Runnable {
	private Container Breads;
	public void Eat(Container b) {
		this.Breads = b;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			this.Breads.sub(i);
		}
		
	}

}
