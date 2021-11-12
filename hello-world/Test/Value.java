
public class Value {
	public static void main(String[] args) {
		B b =new B();
		b.print();
	}
}
class A{
	int value =10;
}

class B extends A{
	int value = 20;
	public void print() {
		int value =30;
		System.out.println(value);
		System.out.println(this.value);
		System.out.println(super.value);
	}
}
