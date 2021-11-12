package ReviewForDataStructure;

public class TestForMyList {
	public static void main(String[] args) {
		MySingleList<Integer> list = new MySingleList<>();
		list.add(66);
		list.add(33);
		list.add(66);
		list.add(68);
		list.add(23);
		list.add(78);
		list.add(6,99);
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(list.getData(0));
		list.remove(5);
//		list.remove(6);
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();

	}
}
