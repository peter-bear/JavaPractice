public class array1{
	private static int[] score = {90,91,92,93,94};
	private static int Length = score.length;
	public void addscore(int[] Value, int a) {
		for(int i=0;i<a;i++) {
			score[i]+=1;
		}
	}
	public static void main(String[] args) {
		array1 student = new array1();
		student.addscore(score,Length);
//		for(int i=0;i<Length;i++) {
//			System.out.println(score[i]);
//		}
		//for-each½á¹¹
		for(int i : score) {
			System.out.println(i);
		}
		/*
		final int LENGTH = 10;
		double data[] = new double[LENGTH];
		**/
		/*
		String[] friend = {"Tim","John","Bob"};
		final int LENGTH = friend.length;
		for(int i=0; i < LENGTH; i++) {
			//data[i] = i;
			System.out.println(friend[i]);
		}
		**/
		
	}
}