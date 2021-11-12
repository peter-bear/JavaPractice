package CollectionStudy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection<Object> container1 = new ArrayList<>();
		container1.add("apple");
		container1.add(1);
//		container1.add(3);
//		container1.remove("apple");
//		container1.clear();
//		System.out.println(container1.contains("apple"));
		//增强for
		System.out.println("----增强For----");
		for(Object i :container1) {
			System.out.println(i);
		}
		//迭代器
		System.out.println("----Iterator----");
		Iterator<Object> itr = container1.iterator();  
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	} 
}
