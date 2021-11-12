package Trees;

public class TestForRedBlackTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		RedBlackTree2<Integer, String> tree = new RedBlackTree2<>();
//		tree.add(1, "A");
//		tree.add(2, "B");
//		tree.add(3, "B");
//		tree.remove(1);
//		tree.printTreeLevel();
		System.out.println("Start");
		RedBlackTree tree = new RedBlackTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(7);
		tree.inOrder();
		System.out.println();
		tree.Delete(3);
//		tree.Delete(2);
//		tree.Delete(7);
//		tree.Delete(1);
		tree.inOrder();
	}

}
