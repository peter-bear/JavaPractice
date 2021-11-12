package java_class_study;

public class Rabbit {
	public static void main(String[] args) {
//		long[] sum = new long[52];
//		sum[0]=1;
//		sum[1]=1;
//		for (int i=2; i<=51; i++) {
//			sum[i] = sum[i-2]+sum[i-1];
//			System.out.println("第"+i+"个月的兔子有"+sum[i]+"对");
//		}
		long a = 1;
		long b = 1;
		long c = 0;
		//首先在控制台打印出数列中第一个数和第二个数的值
		System.out.print(a + "\t" + b + "\t");
		//建立一个for循环，用于循环输出数列中第三位至第十位的数字
		for (int i = 3; i <= 20; i++) {
			//第三个数即为c，a+b等于c的值
			c = a + b;
			//将第一个加数a赋值为数列中的第二个数b的值
			a = b;
			//将第二个加数b赋值为数列中的第三个数c的值
			b = c;
			//在第二次循环打印时，将打印数列中的第四个数为：b + c = b + (a + b) 
			System.out.print(c + "\t");

		}

	}
}
