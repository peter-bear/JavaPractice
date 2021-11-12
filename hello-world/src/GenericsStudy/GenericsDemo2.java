package GenericsStudy;

public class GenericsDemo2 {
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;//假设X为初始最大值
		if(y.compareTo(max)>0) {
			max = y;
		}
		if(z.compareTo(max)>0) {
			max = z;
		}
		return max;
	}
	public static void main(String args[]) {
		System.out.printf("%d, %d and %d中最大的数为 %d\n",3, 4, 5, maximum(3, 4, 5) );
		System.out.printf("%.1f, %.1f and %.1f中最大的数为%.1f\n",6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
		System.out.printf("%s, %s and %s中最大的是%s\n", "pear", "apple", "orange", maximum("pear","apple","orange"));
	}
}
