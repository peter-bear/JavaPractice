package CollectionStudy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo2 {
	public static void main(String[] args) {
		Students Tom = new Students(18, "Tom");
		Students Jimmy = new Students(22, "Jimmy");
		Collection<Students> container = new ArrayList<Students>();
		container.add(Tom);
		container.add(Jimmy);
//		container.add(Jimmy);
//		container.add(new Students(22, "Jimmy"));
		System.out.println(container.contains(Jimmy));
		//±éÀú 1
		for(Object student : container) {
			System.out.println(student);
		}
		System.out.println("\t----Line-----");
		//±éÀú 2
		Iterator<Students> itr = container.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
