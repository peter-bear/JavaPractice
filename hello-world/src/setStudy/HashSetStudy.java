package setStudy;

import java.util.HashSet;

public class HashSetStudy {
	public static void main(String[] args) {
		HashSet<String> container = new HashSet<>();
		container.add("tim");
		container.add("Ketty");
		container.add("Yellow");
		System.out.println("HashSet�е����ݣ�"+container.toString());
		System.out.println("HashSet�Ĵ�С��"+container.size());
		System.out.println("��HashSet���Ƿ���Ketty���ݣ�"+container.contains("Ketty"));
		
	}
}
