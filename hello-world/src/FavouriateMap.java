//import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.awt.Color;
import java.util.Set;
public class FavouriateMap{
	public static void main(String[] args) {
		Map<String, Color> colors = new HashMap<String, Color>();
		colors.put("Juliet", Color.BLUE);
		colors.put("Remeo", Color.GREEN);
		colors.put("Adam",Color.RED);
		colors.put("Eve", Color.YELLOW);
		
		Set<String> KeySet = colors.keySet();
		System.out.println(colors.keySet());
		for (String Key : KeySet) {
			Color value = colors.get(Key);
			System.out.println(Key +":"+value);
			
		}
	}
}