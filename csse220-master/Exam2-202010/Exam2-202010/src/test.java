import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		changeArray(a, 0);
		System.out.println(Arrays.toString(a));
	}
	
	public static void changeArray(int[] a, int i) {
		if(i>=a.length)
			return;
		a[i] = -1;
		changeArray(a, i+1);
					
	}

}
