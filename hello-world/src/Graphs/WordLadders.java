package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordLadders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new HashMap<>();
//		map.put("five", "fire");
//		map.put("hire", "fire");
//		map.put("here", "hire");
//		map.put("hero", "here");
		List<String> li = new LinkedList<String>();
		li.add("zero");
		li.add("five");
		map.put("zero", li);
		
		System.out.println(findChain(map, "zero","five"));
		
	}
	
	public static List<String> findChain(Map<String, List<String>> adjacentWords, String first, String second){
		Map<String, String> previousWord = new HashMap<String, String>();
		LinkedList<String> q = new LinkedList<>();
		
		q.addLast(first);
		while(!q.isEmpty()) {
			String current = q.removeFirst();
			List<String> adj = adjacentWords.get(current);
			
			if(adj!=null) {
				for(String adjWord :adj) {
					if(previousWord.get(adjWord) ==null) {
						previousWord.put(adjWord, current);
						q.addLast(adjWord);
					}
				}
			}
		}
		
		previousWord.put(first, null);
		
		return getChainFromPreviousMap(previousWord, first, second);
		
	}
	
	public static List<String> getChainFromPreviousMap(Map<String, String> prev, String first, String second) {
		LinkedList<String> result =null;
		
		if(prev.get(second)!=null) {
			result = new LinkedList<>();
			for(String str=second; str!=null; str = prev.get(str)) {
				result.addFirst(str);
			}
		}
		
		return result;
	}

}
