package java_class_study;
class A {
	A(){
		System.out.println("A's construction function");
	}
	public void func1() {
		System.out.println("A func1 is calling");
	}
	public void func2() {
		func1();
	}
}

class B extends A {
	B(int a){
		System.out.println("---->"+a);
	}
	public void func1() {
		System.out.println("   B func1 is calling");
	}
	public void func3() {
		System.out.println("B func3 is calling");
	}
}

class C {

	public static void main(String[] args) {
            B b = new B(1);
            b.func1();
//            a.func2();
//            a.func3();
	}	
}