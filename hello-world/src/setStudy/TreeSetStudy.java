package setStudy;

import java.util.TreeSet;

public class TreeSetStudy {
	public static void main(String[] args) {
		TreeSet<String> container = new TreeSet<>();
//		container.add(6);
		container.add("Hello");
		container.add("xyz");
		container.add("world");
		container.add("hello");
		container.add("99");
		System.out.println(container.toString());
	}
}
