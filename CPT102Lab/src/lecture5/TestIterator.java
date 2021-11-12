package lecture5;

public class TestIterator {
	public static void main(String[] args) {
		ArrayBag<String> bag = new ArrayBag<>();
		bag.add("Jim");
		bag.add("Steaven");
		bag.add("Bob");
		bag.add("Jerry");
		for(String name:bag) {
			System.out.println(name);
		}
	}
}
