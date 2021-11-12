package InnerClass;


class Outer{
	private static String inf = "Hello World";
	private String inf2 = "GoodBye World";
	//静态内部类
	public static class Inner{
		private static void print() {
			System.out.println("\t静态成员变量： "+inf);
			//无法直接调用非静态变量
//			System.out.println(inf2);
			Outer out = new Outer();
			System.out.println("\t非静态成员变量： "+out.inf2);
		}
		public void print2() {
			System.out.println("\t非静态方法调用静态成员变量： "+inf);
		}
	}
	//普通内部类
	public  class Inner2{
		public void print() {			
			System.out.println("\t静态成员变量： "+inf);
			System.out.println("\t非静态成员变量： "+inf2);
		}
		//不能创建静态方法
	}
	//外部类能够创建非静态方法
	public void print() {
		Inner innerDemo = new Inner();
		System.out.println("静态内部类的静态方法： ");
		Inner.print();
		System.out.println("静态内部类的非静态方法： ");
		innerDemo.print2();
	}
	//外部类可以创建静态方法

	
}
public class InnerClassDemo1 {
	public static void main(String[] args) {
		//实例化静态内部类
		Outer.Inner StaticInnerDemo =new Outer.Inner();
		//实例化普通内部类
//		Outer.Inner2 NormalInnerDemo = new Outer.Inner2();
		Outer shell = new Outer();
		shell.print();
		Outer.Inner2 NormalInnerDemo = shell.new Inner2();
		System.out.println("静态内部类的非静态方法： ");
		StaticInnerDemo.print2();
		System.out.println("普通内部类的方法： ");
		NormalInnerDemo.print();
	}
}
