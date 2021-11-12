package AdvancedThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) throws InterruptedException {
		int num =4;
//		ExecutorService es = Executors.newFixedThreadPool(num); //创建固定线程
		ExecutorService es = Executors.newCachedThreadPool(); //创建缓存线程池，根据我们提交线程数量决定
		
		Runnable run = new Runnable() {
			private int tickets = 100;
			@Override
			public void run() {
				while(true) {
					if(tickets <= 0) {
						break;
					}
					System.out.println(Thread.currentThread().getName()+"卖了第"+tickets+"张票");
					tickets--;
				}
				
			}
		};
		for(int i=0;i<num;i++) {
			es.submit(run); //将线程加入到线程池 / 提交任务
		}
		//关闭线程池
		es.shutdown();
		
	
	
	}
}
