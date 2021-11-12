public class hello_world
{
	public static void main(String[] args) 
	{
//		System.out.println("hello world");
		int i =1;
		Integer num = new Integer(i);
		String word = num.toString();
		System.out.println(word.getClass());
		System.out.println(Integer.valueOf(word).getClass());
//		System.out.println(y);
	}
}