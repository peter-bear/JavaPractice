class StringTest{
	static int i = 47;
}
public class exercise_7 {
	static void increment(){StringTest.i++;}
	static int j = 47;
	public static void main(String[] args) {
		exercise_7 Increase = new exercise_7();
		Increase.increment();
		System.out.println(StringTest.i);
		exercise_7.increment();
		System.out.println(StringTest.i);
		increment();
		System.out.println(StringTest.i);
		StringTest.i = 47;
		System.out.println(StringTest.i);
		System.out.println("-----next-----");
		
		exercise_7 a = new exercise_7();
		exercise_7 b = new exercise_7();
		System.out.println(a.j+"=="+b.j);
		exercise_7.j ++;
		System.out.println(a.j+"=="+b.j);
		
	}
}
