import java.util.*;
public class practice_2_1 {
	public void f() {}
	public int i;
	public static void main(String[] args) {
		System.out.print("Today is ");
		System.out.println(new Date());
		System.out.println("----------------");
		System.getProperties().list(System.out);
	    System.out.println(System.getProperty("user.name"));
	    //System.out.println(System.getProperty("java.library.path"));

	}
}
