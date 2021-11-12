package DataStructure;

public class ArrayBinaryTreeDemo1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7}; //定义一个顺序数组
		System.out.println("前序遍历");
		preOrder(arr, 0);
		System.out.println("\n"+"中序遍历");
		infixOrder(arr, 0);
		System.out.println("\n"+"后序遍历");
		postOrder(arr, 0);
		
	}
	
	//完成顺序存储二叉树的前序遍历
	public static void preOrder(int[] arr, int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		System.out.print(arr[index]);
		//向左递归
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +1);
		}
		//向右递归
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +2);
		}
		
	}
	
	//中序遍历
	public static void infixOrder(int[] arr, int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		
		//向左递归
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +1);
		}
		System.out.print(arr[index]);
		//向右递归
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +2);
		}
	}
	
	//后序遍历
	public static void postOrder(int[] arr, int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		
		//向左递归
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +1);
		}
	
		//向右递归
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +2);
		}
		
		System.out.print(arr[index]);
	}
	
}

//class ArrBinaryTree{
//	private int[] arr;
//
//	public ArrBinaryTree(int[] arr) {
//		super();
//		this.arr = arr;
//	}
//	
//	//完成顺序存储二叉树的前序遍历
//	public void preOrder(int index) {
//		if(arr == null || arr.length == 0) {
//			System.out.println("数组为空");
//			return;
//		}
//		System.out.print(arr[index]);
//		//向左递归
//		if(2*index +2 < arr.length) {
//			preOrder(2*index +1);
//		}
//		//向右递归
//		if(2*index +2 < arr.length) {
//			preOrder(2*index +2);
//		}
//		
//	}
//}

