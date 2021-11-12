package Interface;

public class TestPerson {
	public static void main(String[] args) {
		Person jim = new Person("Jim",20);
		jim.fly();
		Ability baby = new Person("baby", 30);
//		if(baby instanceof Person) {
//			System.out.println(true);
//		}
		baby.fly();
	}
}
