package Trees;

import java.util.LinkedList;

public class BinaryTreeDemo1 {
	public static void main(String[] args) {
		BinaryTree_1 tree = new BinaryTree_1();
		String words ="ABCDEFGH";
		for(char i : words.toCharArray()) {
			tree.add(new TreeNode_1(i));
		}
		System.out.println("前序遍历");
		tree.preOrder();
		System.out.println("中序遍历");
		tree.infixOrder();
		System.out.println("后序遍历");
		tree.postOrder();
		
		System.out.println("前序查找");
		System.out.println(tree.preSearch(new TreeNode_1('B')));
		System.out.println("中序查找");
		System.out.println(tree.infixSearch(new TreeNode_1('B')));
		System.out.println("后序查找");
		System.out.println(tree.postSearch(new TreeNode_1('B')));
		
	}
	
	
}

class TreeNode_1{
	char word;
	TreeNode_1 left;
	TreeNode_1 right;
	TreeNode_1(char word){
		this.word = word;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return word+"";
	}
	
	//前序遍历
	public void preOrder() {
		System.out.print(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	//中序遍历
	public void infixOrder() {
		//先向左递归
		if(this.left !=null) {
			this.left.infixOrder();
		}
		//走到左边最后一个打印,走完回溯到倒数第二个结点，打印倒数第二个
		System.out.print(this);
		
		//然后递归右结点
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	
	//后序遍历
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.print(this);
	}
	
	
	//前序遍历
		public boolean preSearch(TreeNode_1 node) {
			boolean rst =false;
			System.out.println(this+" "+node);
			if(this.word == node.word) {
				return true;
			}
			
			if(this.left != null) {
				rst = this.left.preSearch(node);
			}
			
			if(rst == true) {
				return rst;
			}
			
			if(this.right != null) {
				rst = this.right.preSearch(node);
			}
			
			
			return rst;
		}
		
		//中序遍历
		public boolean infixSearch(TreeNode_1 node) {
			boolean rst =false;
			//先向左递归
			if(this.left !=null) {
				rst = this.left.infixSearch(node);
			}
			if(rst == true) {
				return rst;
			}
			//走到左边最后一个打印,走完回溯到倒数第二个结点，打印倒数第二个
			System.out.println(this+" "+node);
			if(this.word == node.word) {
				return true;
			}
			
			//然后递归右结点
			if(this.right!=null) {
				rst = this.right.infixSearch(node);
			}
			return rst;
		}
		
		//后序遍历
		public boolean postSearch(TreeNode_1 node) {
			boolean rst = false;
			if(this.left != null) {
				rst = this.left.postSearch(node);
			}
			if(rst == true) {
				return rst;
			}
			if(this.right != null) {
				rst = this.right.postSearch(node);
			}
			System.out.println(this+" "+node);
			if(this.word == node.word) {
				rst = true;
			}
			
			return rst;
		}
	
}


class BinaryTree_1{
	private TreeNode_1 root;
	BinaryTree_1(){
		root = null;
	}
	BinaryTree_1(TreeNode_1 root){
		this.root =root;
	}
	
	public boolean isempty() {
		return root == null;
	}
	
	
	
	public void add(TreeNode_1 node) {
		if(isempty()) {
			root = node;
			return;
		}
		LinkedList<TreeNode_1> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode_1 cur = queue.pop();
			if(cur.left == null) {
				cur.left = node;
				return;
			}else {
				queue.add(cur.left);
			}
			if(cur.right == null) {
				cur.right = node;
				return;
			}else {
				queue.add(cur.right);
			}
		}
	}
	
	//前序遍历
	public void preOrder() {
		if(isempty()) {
			System.out.println("树为空");
			return;
		}
		this.root.preOrder();
		System.out.println();
	}
	
	//中序遍历
	public void infixOrder() {
		if(isempty()) {
			System.out.println("树为空");
			return;
		}
		this.root.infixOrder();
		System.out.println();
	}
	
	//后序遍历
	public void postOrder() {
		if(isempty()) {
			System.out.println("树为空");
			return;
		}
		this.root.postOrder();
		System.out.println();
	}
	
	
	//前序查找
	public boolean preSearch(TreeNode_1 node) {
		if(isempty()) {
			System.out.println("树为空");
			return false;
		}
		return this.root.preSearch(node);
	}
	
	//中序查找
	public boolean infixSearch(TreeNode_1 node) {
		if(isempty()) {
			System.out.println("树为空");
			return false;
		}
		return this.root.infixSearch(node);
	}
	
	//后序查找
	public boolean postSearch(TreeNode_1 node) {
		if(isempty()) {
			System.out.println("树为空");
			return false;
		}
		return this.root.postSearch(node);

	}
}
