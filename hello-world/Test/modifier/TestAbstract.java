package modifier;

public class TestAbstract {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.speak();
		Animal bird = new Bird();
		bird.speak();
		dog.walk();
		bird.walk();
	}
}



abstract class Animal{
	public abstract void speak();
	public abstract void move();
	public void walk() {
		System.out.println("I am walking");
	}
}

class Dog extends Animal{
	@Override
	public void speak() {
		System.out.println("Wang Wang Wang¡­¡­");
		
	}

	@Override
	public void move() {
		System.out.println("Dog uses his four legs to run");
		
	}
}

class Bird extends Animal{

	@Override
	public void speak() {
		System.out.println("Yin Yin Yin¡­¡­");
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}

//
abstract class felid extends Animal{
	abstract void hunt();
}