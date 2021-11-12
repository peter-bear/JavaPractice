

public class animal {
	private int age;
	public animal(){
		System.out.println("I am an animal.");
	}
	public int getAge() {
		return age;
	}
	public animal(int age) {
		this();
		this.age = age;
		
	}
	
	public void printAge() {
		System.out.println("My age is "+ this.age);
	}
	
	public void printAge(int year) {
		this.age += year;
		System.out.println("After "+year+" years. My age is "+this.age);
	}
	public void roar() {
		System.out.println("I am yelling.");
		this.Hungry();
	}
	public void Hungry() {
		System.out.println("I am hungry!!");
	}

}
