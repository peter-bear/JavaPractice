package Class_Study;

public class animal {
	private int age;
	public animal(){
		System.out.println("I am an animal.");
	}
	public animal(int age) {
		this.age = age;
		System.out.println("My age is "+ this.age);
	}
	public void roar() {
		System.out.println("I am yelling.");
	}
	
}
