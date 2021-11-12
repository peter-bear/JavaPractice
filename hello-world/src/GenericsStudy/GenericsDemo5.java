package GenericsStudy;

public class GenericsDemo5 {
	public static <T extends Number> double add(T num1, T num2) {
		double sum=0.0;
		sum = num1.doubleValue() + num2.doubleValue();
		return sum;
	}
	public static void main(String[] args) {
		System.out.println("double 类型相加：5.5 + 6.7 ="+add(5.5, 6.7));
		System.out.println("int 类型相加：5 + 7 ="+add(5, 7));
		System.out.println("double 与 int 类型相加：5.5+6 ="+add(5.5, 6));
	}
}
