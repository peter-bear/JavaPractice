package ReviewForDataStructure;

public class TestForTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//		tree.insert(66);
//		tree.insert(33);
//		tree.insert(66);
//		tree.insert(68);
//		tree.insert(23);
//		tree.insert(78);
//		tree.infixOrder();
//		System.out.println(tree.contains(66));
//		tree.remove(33);
//		tree.infixOrder();
//		System.out.println(tree.contains(33));
//		
		
		AVLtree<Integer> tree = new AVLtree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		
		tree.infixOrder();
		tree.preOrder();
		tree.postOrder();
		
	}

}
