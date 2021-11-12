package Trees;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		int[] arr = {7,3,10, 12,5,1,9};
		BinarySortTree tree= new BinarySortTree();
		for(int i:arr) {
			tree.add(new Node(i));
		}
		System.out.println("删除前");
		tree.infixOrder();
		tree.delete(new Node(7));
		System.out.println("删除后");
		tree.infixOrder();
//		System.out.println((int)(Math.random()*10));
	}
	

}

class BinarySortTree{
	private Node root = null;
	
	public boolean isempty() {
		return root == null;
	}
	
	public void add(Node node) {
		if(isempty()) {
			root = node;
		}else {
			root.add(node);
		}
	}
	
	
	public void delete(Node node) {
		if(root == null) {
			System.out.println("tree is empty");
			return;
		}else if(root.left == null && root.right == null && root.num  == node.num) {
			root = null;
			return;
		}
		Node target = root.Search(node);
		if(target == null) {
			System.out.println("未找到相关结点");
			return;
		}
		
		
		Node Parent = root.Parent(node);
		if(Parent == null) {//为头节点
			Node cur = root.left;
			root = root.right;
			if(root == null) {
				root = cur;
				return;
			}
			if(root.left != null)
				root.add(cur);
			return;
		}
		if(Parent.left.num == target.num) {
			Parent.left = target.right;
			if(target.left != null)
				root.add(target.left);
		}else {
			Parent.right = target.right;
			if(target.left != null)
				root.add(target.left);
		}
		
//		System.out.println(target);
//		System.out.println(targetParent);
		
	}
	
	public void infixOrder() {
		if(isempty()) {
			System.out.println("Root is empty");
		}else {
			root.infixOrder();
			System.out.println();
		}
	}
	
}

