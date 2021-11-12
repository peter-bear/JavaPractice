import java.util.ArrayList;
public class arraylist{
	public static void main(String[] args) {
		ArrayList<String> list =  new ArrayList<>();
		list.add("peter");
		list.add("Jim");
		String x = list.get(1);
		System.out.println(x);
		System.out.println(list.size());
		ArrayList<Double> list2 = new ArrayList<>();
		for (double i=0 ; i<3 ; i+=0.5) {
			list2.add(i);
		}
		System.out.println(list2);
	}
}