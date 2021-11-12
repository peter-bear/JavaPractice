
public class FloatNumber {
	public static void main(String[] args) {
		float num = 100000000.0f;
		float num2 =10.0f;
		for(int i=0;i<7;i++) {
			num += 1.5;
			num2 +=1.5;
			System.out.printf("num: %f, actual num: %f\n",num, num2 );
		}
	}
}
