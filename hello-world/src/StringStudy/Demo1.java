package StringStudy;

import java.util.Arrays;

public class Demo1 {
	public static void main(String[] args) {
		String words = "hello";
		System.out.println(words);
		words = "world";
		System.out.println(words);
		String str = new String("Java");
		String str2 = new String("Java");
		System.out.println("str��str2�Ƿ���ͬһ��ַ��"+(str == str2));
		System.out.println("str��str2�Ƿ�������ȫ��ͬ"+str.equals(str2));
		System.out.println("words�ڵ�һ�����ַ�����:"+words.charAt(0));
		System.out.println("��wordsת��Ϊ������Array:"+Arrays.toString(words.toCharArray()));
		System.out.println("��wordsת��Ϊ������Array[0]:"+words.toCharArray()[0]);
		System.out.println("�ж�words���Ƿ���w:"+words.contains("w"));
		System.out.println("�ж�words���Ƿ���wd:"+words.contains("wd"));
		System.out.println("���ض�Ӧ�ַ���rd���±꣺"+words.indexOf("rd"));
		words = "hello";
		System.out.println("���ض�Ӧ�ַ���l���±꣺"+words.indexOf("l"));
		System.out.println("���ض�Ӧ�ַ���l�����±꣺"+words.lastIndexOf("l"));
		String student = " Peter Bear ";
		System.out.println("After deleting SPACE in String----"+student.trim()+"----");
		System.out.println("����ĸȫ����Ϊ��д:"+student.toUpperCase());
		System.out.println("��ԭ�����ַ����е����ݽ����滻:"+student.replace("ear", "ear is 18 years old."));
		String website = "www.peterbear.com";
		System.out.println("������ԭ�����ַ��������������ݵ��ַ�����"+student.concat("'s website: ").concat(website));
		
		
	}
}
