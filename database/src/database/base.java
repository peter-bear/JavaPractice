package database;
import java.util.ArrayList;
public class base {
	private ArrayList<Item> database = new ArrayList<>();
	public void add(Item item) {
		database.add(item);
	}
	public void list() {
		for(Item i:database) {
			i.print();
			System.out.println();
		}
	}
	public static void main(String[] args) {
		base list = new base();
		list.add(new CD("one",1,"abc"));
		list.add(new DVD("two",2,"efg"));
		list.list();
	}
}
