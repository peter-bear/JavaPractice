package Interface;

public class Person implements Ability{
	String name;
	int age;
	Person(String name, int age){
		this.name=name;
		this.age = age;
	}
	public void eat() {
		System.out.println(this.name+" ÔÚ³Ô·¹¡­¡­");
	}
	public void sleep() {
		System.out.println(this.name+" ÔÚË¯¾õ¡­¡­");
	}
	@Override
	public void fly() {
		System.out.println(this.name+" can fly");
		
	}
	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}
}
