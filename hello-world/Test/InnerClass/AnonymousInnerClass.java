package InnerClass;

import Interface.Ability;

public class AnonymousInnerClass {
	public static void main(String[] args) {
		Ability SuperMan = new Ability(){

			@Override
			public void swim() {
				// TODO Auto-generated method stub
				System.out.println("I can swim");
			}

			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("I can fly");
				
			}
			
		};
		SuperMan.swim();
		SuperMan.fly();
	}
}

