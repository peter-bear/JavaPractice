package PointOffer;

public class BinaryTreeProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(CheckInclude());
//		MirrorTree();
		System.out.println(IsSymetric());
	}
	
	
	
	/*
	 * °üº¬¶þ²æÊ÷
	 */
	public static boolean CheckInclude() {
		BinaryNode[] heads=CreateBinaryTree();
		PrintTree(heads[0]);
		System.out.println();
		PrintTree(heads[1]);
		System.out.println();
		
		return HasSubTree(heads[0], heads[1]);
	}
	
	private static boolean HasSubTree(BinaryNode head1, BinaryNode head2) {
		boolean rst = false;
		if(head1!=null && head2!=null) {
			if(Equal(head1.value, head2.value)) {
				rst = CheckTree(head1, head2);
			}
			
			if(!rst)
				rst = HasSubTree(head1.left, head2);
			if(!rst)
				rst = HasSubTree(head1.right, head2);
			
		}

		
		return rst;
	}
	
	private static boolean CheckTree(BinaryNode head1, BinaryNode head2) {
		if(head2 == null)
			return true;
		if(head1==null)
			return false;
		if(!Equal(head1.value, head2.value))
			return false;
		
		return CheckTree(head1.left, head2.left) && CheckTree(head1.right, head2.right);
	}
	
	
	private static boolean Equal(double num1, double num2) {
		if(num1-num2 <0.0000001 && num1-num2 >-0.0000001)
			return true;
		else {
			return false;
		}
	}
	
	
	
	
	
	/*
	 * ¾µÏñ¶þ²æÊ÷
	 */
	public static void MirrorTree() {
		BinaryNode head = CreateBinaryTree2();
		PrintTree(head);
		MirrorTree(head);
		System.out.println();
		PrintTree(head);
	}
	
	private static void MirrorTree(BinaryNode head) {
		if(head == null)
			return;
		if(head.left ==null && head.right==null)
			return;
		BinaryNode tmp = head.left;
		head.left = head.right;
		head.right = tmp;
		
		if(head.left !=null)
			MirrorTree(head.left);
		
		if(head.right != null)
			MirrorTree(head.right);
	}
	
	//¾µÏñ¶þ²æÊ÷
	private static BinaryNode CreateBinaryTree2() {
		BinaryNode head = new BinaryNode(8);
		head.left = new BinaryNode(6, new BinaryNode(5), new BinaryNode(7));
		head.right = new BinaryNode(10, new BinaryNode(9), new BinaryNode(11));
		
		return head;
	}
	
	
	
	//ÅÐ¶ÏÊ÷µÄ×Ó½á¹¹
	private static BinaryNode[] CreateBinaryTree() {
		BinaryNode[] heads = new BinaryNode[2];
		BinaryNode head1 = new BinaryNode(6.0);
		head1.left = new BinaryNode(7.0, new BinaryNode(5.0, new BinaryNode(6.0), null), new BinaryNode(3.0));
		head1.right = new BinaryNode(8.0, new BinaryNode(9.0), new BinaryNode(2.0));
		
		BinaryNode head2 = new BinaryNode(8.0, new BinaryNode(9.0), new BinaryNode(2.0));
		
		heads[0] = head1;
		heads[1] = head2;
		
		return heads;
	}
	
	
	public static boolean IsSymetric() {
		BinaryNode head = CreateBinaryTree3();
		if(head == null)
			return false;
		return IsSymetric(head.left, head.right);
	}
	
	private static boolean IsSymetric(BinaryNode left, BinaryNode right) {
		if(left == null && right == null)
			return true;
		
		if(left == null || right == null)
			return false;
		if(!Equal(left.value, right.value))
			return false;
		
		return IsSymetric(left.left, right.right)&& IsSymetric(left.right, right.left);
		
	}
	
	
	//ÅÐ¶Ï¶Ô³Æ¶þ²æÊ÷
	private static BinaryNode CreateBinaryTree3() {
		BinaryNode head = new BinaryNode(8);
		head.left = new BinaryNode(6, new BinaryNode(5), new BinaryNode(7));
		head.right = new BinaryNode(6, new BinaryNode(7), new BinaryNode(5));
		
		return head;
	}
	
	
	private static void PrintTree(BinaryNode head) {
		System.out.print(head.value+" ");
		if(head.left!=null)
			PrintTree(head.left);
		if(head.right!=null)
			PrintTree(head.right);
	}

	
	private static class BinaryNode{
		double value;
		BinaryNode left;
		BinaryNode right;
		BinaryNode(double v){
			value = v;
			left =null;
			right = null;
		}
		
		BinaryNode(double v, BinaryNode l, BinaryNode r){
			value = v;
			left =l;
			right = r;
		}
	}

}
