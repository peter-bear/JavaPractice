package AdvancedThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) throws InterruptedException {
		int num =4;
//		ExecutorService es = Executors.newFixedThreadPool(num); //�����̶��߳�
		ExecutorService es = Executors.newCachedThreadPool(); //���������̳߳أ����������ύ�߳���������
		
		Runnable run = new Runnable() {
			private int tickets = 100;
			@Override
			public void run() {
				while(true) {
					if(tickets <= 0) {
						break;
					}
					System.out.println(Thread.currentThread().getName()+"���˵�"+tickets+"��Ʊ");
					tickets--;
				}
				
			}
		};
		for(int i=0;i<num;i++) {
			es.submit(run); //���̼߳��뵽�̳߳� / �ύ����
		}
		//�ر��̳߳�
		es.shutdown();
		
	
	
	}
}
