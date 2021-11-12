import java.util.HashMap;
import java.util.Set;
public class FindFreq{
	public static char Search(String[] strings) {
		HashMap<Character,Integer> map= new HashMap<Character,Integer>();
		int fre=0;
		for(String current:strings) {
			char head = current.charAt(0);
			if (map.containsKey(head)) {
				fre+=1;
			}
			map.put(head, fre);
		}
		Set <Character> setMap = map.keySet();
		char largest = '!';
		int highest=0;
		for(char key:setMap) {
			if(map.get(key)>highest) {
				largest = key;
			}
		}
		
		return largest;
		
	}
	public static void main(String[] args) {
		String[] words = {"ant","bug","bunt"};
		char rst = Search(words);
		if (rst == '!') {
			System.out.println("No word has highest beginning frequency!");
		}
		else{
			System.out.println(rst);
		}
	}
}