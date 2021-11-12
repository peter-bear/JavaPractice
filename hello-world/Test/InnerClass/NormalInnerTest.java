package InnerClass;

import InnerClass.OuterClass.InnerClass;

public class NormalInnerTest {
	public static void main(String[] args) {
//		OuterClass outer = new OuterClass();
//		InnerClass inner = outer.new InnerClass();
		InnerClass inner = new OuterClass().new InnerClass();
		inner.print();
	}
}

class OuterClass{
	private String words="Outer Class";
	class InnerClass{
		public void print() {
			System.out.println(OuterClass.this.words);
			new OuterClass().print();
			System.out.println("Inner Class: Hello World");
		}
	}
	public void print() {
		System.out.println(words+": Hello World");
	}
}
