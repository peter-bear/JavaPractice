import java.util.Arrays;

public class array2{
	public static double[] add(double[] values) {
		for(int i=0;i<values.length;i++) {
			values[i] += 1;
		}
		return values;
	}
	public static void main(String[] args) {
		double[] values = {2,3,4,5};
//		double total = 0; 
//		for (double element : values)
//		{
//		 total = total + element;
//		}
//		double one = values[0];
//		double two = values[1];
//		for(double value: values) {
//			System.out.println(value);
//		}
		System.out.println(Arrays.toString(add(values)));

	}
}