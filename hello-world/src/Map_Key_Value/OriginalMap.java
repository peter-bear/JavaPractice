package Map_Key_Value;

import java.util.HashMap;
import java.util.Map.Entry;

public class OriginalMap {
	public static void main(String[] args) {
		HashMap<Students, String> container = new HashMap<>();
//		Students Jim = new Students(18, "Jim");
//		container.put(Jim, "CSSE120");
		container.put(new Students(18, "Jim"), "CSSE120");
		container.put(new Students(20, "John"), "CSSE220");
		container.put(new Students(17, "Alex"), "MA112");
		container.put(new Students(20, "Eric"), "ESL102");
		System.out.print("��ȡ Students(18, \"Jim\") ��ֵ��");
		System.out.println(container.get(new Students(18, "Jim")));//get value
		//ʹ��KeySet����
		System.out.println("\tKeySet����");
		for(Students i:container.keySet()) {
			System.out.println(i.getName()+"----"+container.get(i));
		}
		//ʹ��EntrySet����
		System.out.println("\tEntrySet����");
//		Set<Map.Entry<Students, String>> entrys = container.entrySet();
		
		for(Entry<Students, String> i : container.entrySet()) {
			System.out.println(i.getKey().getName()+"----"+i.getValue());
		}
	}
}
