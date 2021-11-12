package Trees;

import java.util.LinkedList;

public class BinaryTreeDemo1 {
	public static void main(String[] args) {
		BinaryTree_1 tree = new BinaryTree_1();
		String words ="ABCDEFGH";
		for(char i : words.toCharArray()) {
			tree.add(new TreeNode_1(i));
		}
		System.out.println("ǰ�����");
		tree.preOrder();
		System.out.println("�������");
		tree.infixOrder();
		System.out.println("�������");
		tree.postOrder();
		
		System.out.println("ǰ�����");
		System.out.println(tree.preSearch(new TreeNode_1('B')));
		System.out.println("�������");
		System.out.println(tree.infixSearch(new TreeNode_1('B')));
		System.out.println("�������");
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
	
	//ǰ�����
	public void preOrder() {
		System.out.print(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	//�������
	public void infixOrder() {
		//������ݹ�
		if(this.left !=null) {
			this.left.infixOrder();
		}
		//�ߵ�������һ����ӡ,������ݵ������ڶ�����㣬��ӡ�����ڶ���
		System.out.print(this);
		
		//Ȼ��ݹ��ҽ��
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	
	//�������
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.print(this);
	}
	
	
	//ǰ�����
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
		
		//�������
		public boolean infixSearch(TreeNode_1 node) {
			boolean rst =false;
			//������ݹ�
			if(this.left !=null) {
				rst = this.left.infixSearch(node);
			}
			if(rst == true) {
				return rst;
			}
			//�ߵ�������һ����ӡ,������ݵ������ڶ�����㣬��ӡ�����ڶ���
			System.out.println(this+" "+node);
			if(this.word == node.word) {
				return true;
			}
			
			//Ȼ��ݹ��ҽ��
			if(this.right!=null) {
				rst = this.right.infixSearch(node);
			}
			return rst;
		}
		
		//�������
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
	
	//ǰ�����
	public void preOrder() {
		if(isempty()) {
			System.out.println("��Ϊ��");
			return;
		}
		this.root.preOrder();
		System.out.println();
	}
	
	//�������
	public void infixOrder() {
		if(isempty()) {
			System.out.println("��Ϊ��");
			return;
		}
		this.root.infixOrder();
		System.out.println();
	}
	
	//�������
	public void postOrder() {
		if(isempty()) {
			System.out.println("��Ϊ��");
			return;
		}
		this.root.postOrder();
		System.out.println();
	}
	
	
	//ǰ�����
	public boolean preSearch(TreeNode_1 node) {
		if(isempty()) {
			System.out.println("��Ϊ��");
			return false;
		}
		return this.root.preSearch(node);
	}
	
	//�������
	public boolean infixSearch(TreeNode_1 node) {
		if(isempty()) {
			System.out.println("��Ϊ��");
			return false;
		}
		return this.root.infixSearch(node);
	}
	
	//�������
	public boolean postSearch(TreeNode_1 node) {
		if(isempty()) {
			System.out.println("��Ϊ��");
			return false;
		}
		return this.root.postSearch(node);

	}
}
