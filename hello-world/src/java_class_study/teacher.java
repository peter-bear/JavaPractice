package java_class_study;

public class teacher {
	private String name;
	private int age;
	public teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void call() {
		System.out.println(this.name);
		System.out.println(this.age);
	}
}
