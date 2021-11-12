package CollectionStudy;

import java.util.LinkedList;

public class LinkedListDemo1 {
	public static void main(String[] args) {
		LinkedList<Students> container = new LinkedList<>();
		System.out.println("增添Tom: "+container.add(new Students(20, "Tom")));
		container.add(new Students(18, "Jim"));
		//pop从container中弹出元素
		System.out.println("Pop第一个元素："+container.pop());
		container.add(new Students(18, "Jim"));
		container.add(new Students(72,"Trump"));
		System.out.println("删除元素Jim："+container.remove(new Students(18, "Jim")));
		//遍历
		for(Object i :container) {
			System.out.println(i);
		}
	}
}
