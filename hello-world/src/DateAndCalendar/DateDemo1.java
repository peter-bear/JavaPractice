package DateAndCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {
	public static void main(String[] args) {
		Date date = new Date();
//		System.out.println(date.toString());
//		System.out.println(date.toLocaleString());
//		SimpleDateFormat Df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//		System.out.println(Df.format(date));
		long start = System.currentTimeMillis();
		while(true) {
			long end = System.currentTimeMillis();
			if((end-start)>10000) {
				System.out.println("world");
				break;
			}
			System.out.println("hello");
		}
	}
}
