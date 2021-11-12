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
		System.out.println("str与str2是否在同一地址："+(str == str2));
		System.out.println("str与str2是否内容完全相同"+str.equals(str2));
		System.out.println("words在第一个的字符串是:"+words.charAt(0));
		System.out.println("将words转化为数组后的Array:"+Arrays.toString(words.toCharArray()));
		System.out.println("将words转化为数组后的Array[0]:"+words.toCharArray()[0]);
		System.out.println("判断words中是否含有w:"+words.contains("w"));
		System.out.println("判断words中是否含有wd:"+words.contains("wd"));
		System.out.println("返回对应字符串rd的下标："+words.indexOf("rd"));
		words = "hello";
		System.out.println("返回对应字符串l的下标："+words.indexOf("l"));
		System.out.println("返回对应字符串l最后的下标："+words.lastIndexOf("l"));
		String student = " Peter Bear ";
		System.out.println("After deleting SPACE in String----"+student.trim()+"----");
		System.out.println("将字母全部改为大写:"+student.toUpperCase());
		System.out.println("将原来的字符串中的内容进行替换:"+student.replace("ear", "ear is 18 years old."));
		String website = "www.peterbear.com";
		System.out.println("返回在原来的字符串后面增添内容的字符出："+student.concat("'s website: ").concat(website));
		
		
	}
}
