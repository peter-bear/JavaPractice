package MultiThreadsStudy;

//ͨ���̳�Thread�����߳�

public class Count extends Thread{
	Count(){
		
	}
	Count(String name){
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++) {
			System.out.println("Thread ID: "+this.getId()+" Thread Name: "+this.getName()+" Number "+i);
		}
	}
	
}
