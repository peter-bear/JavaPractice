package setStudy;

import java.util.Iterator;
import java.util.TreeSet;

public class SetIntroduction {
	public static void main(String[] args) {
		TreeSet<Students> container = new TreeSet<>();
		//应为HashSet是以equal与hashcode进行比较，所以要重写hashcode与equals
//		Students jim = new Students(18, "Jim");
		System.out.println("添加成功："+container.add(new Students(18, "Jim")));
		System.out.println("添加成功："+container.add(new Students(19, "Jone")));
		System.out.println("添加成功："+container.add(new Students(18, "Alex")));
		System.out.println("添加成功："+container.add(new Students(18, "Jim")));
		
		//遍历
		Iterator<Students> itr = container.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
