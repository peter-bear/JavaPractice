package setStudy;

import java.util.HashSet;

public class HashSetStudy {
	public static void main(String[] args) {
		HashSet<String> container = new HashSet<>();
		container.add("tim");
		container.add("Ketty");
		container.add("Yellow");
		System.out.println("HashSet中的内容："+container.toString());
		System.out.println("HashSet的大小："+container.size());
		System.out.println("此HashSet中是否含有Ketty数据："+container.contains("Ketty"));
		
	}
}
