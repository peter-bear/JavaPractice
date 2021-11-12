package Class_Study;

public class TestForAnimal {
	public static void main(String[] args) {
		Dog dog = new Dog();
//		dog.roar();
	}
}


class Dog extends animal{
	Dog(){
		super(3);
		System.out.println("I am a dog.");
	}
	//∑Ω∑®÷ÿ–¥override
	public void roar() {
		super.roar();
		System.out.println("I am hungry. I need meat");
	}
	
	public void run() {
		System.out.println("I can use four legs to run!!");
	}
}

