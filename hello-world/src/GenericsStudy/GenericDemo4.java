package GenericsStudy;

import java.util.List;
import java.util.ArrayList;

public class GenericDemo4 {
	public static void main(String[] args) {
//		List<String> sentence = new ArrayList<>();
		List<Number> sequence = new ArrayList<>();
//		sentence.add("Hello");
//		sentence.add("World");
		sequence.add(1);
		sequence.add(2);
//		getDate(sentence);
		sequence.add(1.4);
		sequence.add(7.9f);
		getDate(sequence);
	}
	public static void getDate(List<? extends Number> data) {
		for(Object i : data) {
			System.out.println(i);
		}
	}
}
