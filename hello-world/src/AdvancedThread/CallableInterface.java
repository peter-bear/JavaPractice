package AdvancedThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableInterface {
	public static void main(String[] args) {
		Callable<Integer> call = new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				int sum =2;
//				System.out.println(2);
				for(int i=3;i<=100;i++) {
					if(Isprime(i)) {
//						System.out.println(i);
						sum += i;
					}
				}
				return sum;
				}
			private Boolean Isprime(int num) {
				for(int i=2;i<num;i++) {
					if(num%i == 0) {
						return false;
					}
				}
				return true;
			}
			
		};
		FutureTask<Integer> task = new FutureTask<>(call);
		Thread count = new Thread(task);
		count.start();
		try {
			System.out.println(task.get().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
