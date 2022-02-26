import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The Links class.
 * Initializes all the possible links and store them in a map for future use.
 */
public class Links implements LinksInterface {
	private HashMap<String, HashSet<String>> map;
	private HashSet<String> dictionary;
	
	public Links(String filename) throws FileNotFoundException {
		map = new HashMap<>();
		dictionary = new HashSet<>();
		
		Scanner scanner = new Scanner(new File(filename));
		while(scanner.hasNext()) {
			dictionary.add(scanner.next());
		}
		scanner.close();
		
		for(String word : dictionary) {
			addNeighbors(word);
		}
		
		
		
	}
	
	/**
	 * go through the whole dictionary to find appropriate words for one word
	 * @param word the key word we use to find other appropraiate words
	 */
	private void addNeighbors(String word) {
		HashSet<String> neighbors = new HashSet<>();
		for(int k=0;k<word.length();k++) 
			addNeighborsAtPosition(k, word, neighbors);
		map.put(word, neighbors);
	}
	
	 private void addNeighborsAtPosition(int k, String word, HashSet<String> neighbors) {
		// TODO Auto-generated method stub
		for(char ch='a'; ch <= 'z'; ch++) {
			if(ch == word.charAt(k))
				continue;
			
			String newWord = word.substring(0, k) + ch + word.substring(k+1);
			if(dictionary.contains(newWord))
				neighbors.add(newWord);
		}
	}

	/**
     * Gets all valid candidates of a word as a set. That is, all the words that differ from 
     * the original word by only one char. They also need to have the same length.
     * @return Set of all valid candidates that meets the criteria.
     */
	@Override
	public Set<String> getCandidates(String word) {
		// TODO Auto-generated method stub
		return map.get(word);
	}

	/**
     * Returns true if the given word is in the dictionary, false otherwise.
     * @return True if the given word is in the dictionary, false otherwise.
     */
	@Override
	public boolean exists(String word) {
		// TODO Auto-generated method stub
		return map.containsKey(word);
	}

}
