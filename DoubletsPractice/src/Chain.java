import java.util.Iterator;
import java.util.LinkedHashSet;

public class Chain implements Iterable<String>{
	
	
	private LinkedHashSet<String> words;
	private String last;
	
	public Chain() {
		words = new LinkedHashSet<>();
		last = "";
	}
	
	public boolean contains(String word) {
		return words.contains(word);
	}
	
	public Chain addLast(String word) {
		Chain longerChain = new Chain();
		longerChain.last = word;
		this.words.add(word);
		longerChain.words = new LinkedHashSet<>(this.words);
		return longerChain;
	}
	
	public String getLast() {
		return last;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return words.iterator();
	}
	
	public int length() {
		return words.size();
	}
}
