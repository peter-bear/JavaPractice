package Interface;

public class Person implements Ability{
	String name;
	int age;
	Person(String name, int age){
		this.name=name;
		this.age = age;
	}
	public void eat() {
		System.out.println(this.name+" �ڳԷ�����");
	}
	public void sleep() {
		System.out.println(this.name+" ��˯������");
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
