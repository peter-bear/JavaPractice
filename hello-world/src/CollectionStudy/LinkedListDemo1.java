package CollectionStudy;

import java.util.LinkedList;

public class LinkedListDemo1 {
	public static void main(String[] args) {
		LinkedList<Students> container = new LinkedList<>();
		System.out.println("����Tom: "+container.add(new Students(20, "Tom")));
		container.add(new Students(18, "Jim"));
		//pop��container�е���Ԫ��
		System.out.println("Pop��һ��Ԫ�أ�"+container.pop());
		container.add(new Students(18, "Jim"));
		container.add(new Students(72,"Trump"));
		System.out.println("ɾ��Ԫ��Jim��"+container.remove(new Students(18, "Jim")));
		//����
		for(Object i :container) {
			System.out.println(i);
		}
	}
}
