package setStudy;

import java.util.Iterator;
import java.util.TreeSet;

public class SetIntroduction {
	public static void main(String[] args) {
		TreeSet<Students> container = new TreeSet<>();
		//ӦΪHashSet����equal��hashcode���бȽϣ�����Ҫ��дhashcode��equals
//		Students jim = new Students(18, "Jim");
		System.out.println("��ӳɹ���"+container.add(new Students(18, "Jim")));
		System.out.println("��ӳɹ���"+container.add(new Students(19, "Jone")));
		System.out.println("��ӳɹ���"+container.add(new Students(18, "Alex")));
		System.out.println("��ӳɹ���"+container.add(new Students(18, "Jim")));
		
		//����
		Iterator<Students> itr = container.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
