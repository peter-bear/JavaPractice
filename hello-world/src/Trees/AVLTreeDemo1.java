package Trees;

public class AVLTreeDemo1 {
	public static void main(String[] args) {
		AVLtree tree = new AVLtree();
//		int[] arr = {4,3,6,5,7,8};
//		int[] arr = {10,12,8,9,7,6};
//		int[] arr = {10,11,7,6,8,9};
		int[] arr= {1,2,3,4,5,6};
		for(int i:arr) {
			tree.add(new Node(i));
		}
//		System.out.println("ɾ��ǰ");
//		System.out.printf("���ĸ߶ȣ�%d\n",tree.height());
//		tree.infixOrder();
//		tree.delete(new Node(7));
//		System.out.println("ɾ����");
//		tree.infixOrder();
		System.out.printf("���ĸ߶ȣ�%d\n",tree.height());
		System.out.printf("�����������߶ȣ�%d\n",tree.leftHeight());
		System.out.printf("�����������߶ȣ�%d\n",tree.rightHeight());
		tree.infixOrder();
		tree.preOrder();
		tree.postOrder();
	}
}

class AVLtree{
	private Node root = null;
	
	public boolean isempty() {
		return root == null;
	}

	public int height() {
		return root.height();
	}
	
	public int leftHeight() {
		return root.leftHeight();
	}
	
	public int rightHeight() {
		return root.rightHeight();
	}

	//����ת
	public Node leftRotate(Node head) {
		Node head_node = new Node(head.num);
		head_node.left = head.left;
		head_node.right = head.right.left;
		
		Node right_node = new Node(root.right.num);
		right_node.right = head.right.right;
		right_node.left = head_node;
		head = right_node;
		return head;
	}
	
	//����ת
	public Node rightRotate(Node head) {
		Node head_node = new Node(head.num);
		head_node.right = head.right;
		head_node.left = head.left.right;
		
		Node left_node = new Node(head.left.num);
		left_node.left = head.left.left;
		left_node.right = head_node;
		head = left_node;
		return head;
	}
	
	
	//��ӽڵ�
	public void add(Node node) {
		if(isempty()) {
			root = node;
		}else {
			root.add(node);
		}
		if(rightHeight() -leftHeight() >1) {
			//���������������߶ȴ������������ĸ߶�
			if(root.left != null &&root.left.leftHeight() - root.left.rightHeight()>0) {
				//������ת
				root.right = rightRotate(root.right);
			}
			root = leftRotate(root);
		}else if(leftHeight() - rightHeight() >1) {
			//���������������߶ȴ������������ĸ߶�
			if(root.left != null &&root.left.rightHeight() - root.left.leftHeight()>0) {
				//������ת
				root.left = leftRotate(root.left);
			}
			root = rightRotate(root);
		}
	}
	
	
	//ɾ��
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
			System.out.println("δ�ҵ���ؽ��");
			return;
		}
		
		
		Node Parent = root.Parent(node);
		if(Parent == null) {//Ϊͷ�ڵ�
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
	
	public void preOrder() {
		if(isempty()) {
			System.out.println("Root is empty");
		}else {
			root.preOrder();
			System.out.println();
		}
	}
	
	public void postOrder() {
		if(isempty()) {
			System.out.println("Root is empty");
		}else {
			root.postOrder();
			System.out.println();
		}
	}
}

class Node{
	int num;
	Node left;
	Node right;
	public Node(int num) {
		super();
		this.num = num;
	}
	
	public int leftHeight() {
		return this.left == null ? 0:this.left.height();
	}
	
	public int rightHeight() {
		return this.right == null ? 0:this.right.height();
	}
	
	public int height() {
		return Math.max(this.left == null ? 0: this.left.height(), this.right == null? 0: this.right.height())+1;
	}
	
	public void add(Node node) {
		
		if(this.num > node.num) {
			if(this.left == null) {
				this.left = node; 
				return;
			}else {
				//�������
				this.left.add(node);
			}
			
		}else {
			if(this.right == null) {
				this.right = node;
				return;
			}else {
				//���ұ���
				this.right.add(node);
			}
		}
	}
	
	public Node Search(Node node) {
		if(this.num == node.num) {
			return this;
		}
		if(node.num <this.num) {
			if(this.left == null) {
				return null;
			}
			return this.left.Search(node);
		}else {
			if(this.right == null) {
				return null;
			}
			return this.right.Search(node);
		}
	}
	
	public Node Parent(Node node) {
		if(this.left != null && this.left.num == node.num|| this.right != null && this.right.num == node.num) {
			return this;
		}else {
			if(this.left != null && node.num < this.left.num ) {
				return this.left.Parent(node);
			}else if( this.right != null&&node.num > this.right.num ) {
				return this.right.Parent(node);
			}else {
				return null;//û�и����
			}
		}
		
	}
	
	
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.print(this+" ");
		
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	
	public void preOrder() {
		System.out.print(this+" ");
		if(this.left != null) {
			this.left.preOrder();
		}
		
		
		
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	public void postOrder() {
		
		if(this.left != null) {
			this.left.postOrder();
		}
		
		
		
		if(this.right != null) {
			this.right.postOrder();
		}
		
		System.out.print(this+" ");
	}
	
	@Override
	public String toString() {
		return num+"";
	}
	
}