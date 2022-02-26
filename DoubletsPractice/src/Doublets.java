import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Doublets Class!
 * @author Qingyuan Jiao & Yao Xiong
 */
public class Doublets {
	private LinksInterface links;
	private Set<String> visited;
	private ChainManager manager;
	
	public Doublets(LinksInterface links) {
		this.links = links;
		this.visited = new HashSet<>();
		this.manager = null;
	}

	public static void main(String[] args) {
		System.out.println("It might take a while to prepare the dictionary. Please be patient...");
		Doublets doublets;
		try {
			doublets = new Doublets(new Links("../DoubletsData/english.cleaned.all.35.txt"));
			Scanner scanner = new Scanner(System.in);
			System.out.print("Welcome to Doublets, a game of \"verbal torture\"");
			while (true) {
				System.out.print("\nEnter starting word: ");
				String startWord = scanner.nextLine();
				System.out.print("Enter ending word: ");
				String endWord = scanner.nextLine();
				System.out.print("Enter chain manager (s: stack, q:queue, p: priority queue, x: exit)");
				String managerType = scanner.nextLine();

				Chain answer = null;
				if (managerType.equals("s")) {
					doublets.manager = new StackChainManager();
					answer = doublets.findChain(startWord, endWord, doublets.manager);
				} else if (managerType.equals("q")) {
					doublets.manager = new QueueChainManager();
					answer = doublets.findChain(startWord, endWord, doublets.manager);
				} else if (managerType.equals("x")) {
					System.out.print("Goodbye!");
					scanner.close();
					break;
				} else {
					System.out.print("The instruction you entered is not valid. Please try again");
				}

				if (doublets.links.getCandidates(startWord) == null) {
					System.out.printf("The word \"%s\" is not valid. Please try again.", startWord);
					continue;
				} 

				if (answer == null) {
					System.out.printf("There is no chain from \"%s\" to \"%s\"", startWord, endWord);
					continue;
				}

				System.out.println("Solution: " + answer.toString());
				System.out.println("Solution length: " + answer.length());
				System.out.println("Chains examined: " + doublets.manager.getNumberOfNexts());
				System.out.println("Max chain manager size: " + doublets.manager.maxSize());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Finds the chain between two words.
	 * @param start The word to start with.
	 * @param end The word to end with.
	 * @param manager the ChainManager to use.
	 * @return The Chain found. 
	 * 			It would be null if the start word is not in dictionary or no chain is found.
	 */
	public Chain findChain(String start, String end, ChainManager manager) {
		visited.clear(); //empty the visited set everytime before starting a search 

		if (start.length() != end.length()) {
			return null;
		}

		if (links.getCandidates(start) == null) { //start word not in dictionary
			return null;
		}

		Chain startChain = new Chain();
		startChain = startChain.addLast(start);
		visited.add(start);
		manager.add(startChain);


		while (!manager.isEmpty()) {
			Chain currChain = manager.next();
			String currWord = currChain.getLast();

			if (currWord.equals(end)) { //chain found
				return currChain;
			} 
			
			for (String nextWord: links.getCandidates(currWord)) {
				if (!visited.contains(nextWord)) {
					Chain newChain = currChain.addLast(nextWord);
					manager.add(newChain);
					visited.add(nextWord);
				}
			}
			
			
		}
		return null;
	}

}
