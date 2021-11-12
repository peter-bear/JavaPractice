package ReviewForDataStructure;


public class TestForArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListDemo<Integer> list = new ArrayListDemo<>();
		list.add(66);
		list.add(33);
		list.add(66);
		list.add(68);
		list.add(23);
		list.add(78);
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}

}
