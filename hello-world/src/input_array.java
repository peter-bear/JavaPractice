import java.util.Scanner;
public class input_array{
	public static void main(String[] args) {
		final int LENGTH = 10;
		double[] array = new double[LENGTH]; 
		Scanner in = new Scanner(System.in);
		int currentSize =0;
		System.out.print("Please enter the number: ");
		while (in.hasNextDouble()&& currentSize < array.length) {
			System.out.print("Please enter the number: ");
			double num = in.nextDouble();
			array[currentSize]=num;
			currentSize++;
		}
		double max = array[0];
		for(int i=0;i<currentSize;i++) {
			if (array[0]<array[i]) {
				max = array[i];
			}
		}
		for(int j=0;j<currentSize;j++) {
			System.out.print(array[j]);
			if(array[j] == max){
				System.out.printf(" <== largest\n");
				}
			System.out.println();
			}
		in.close();
		}
	}