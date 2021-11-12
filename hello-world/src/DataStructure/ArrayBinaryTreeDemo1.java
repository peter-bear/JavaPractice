package DataStructure;

public class ArrayBinaryTreeDemo1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7}; //����һ��˳������
		System.out.println("ǰ�����");
		preOrder(arr, 0);
		System.out.println("\n"+"�������");
		infixOrder(arr, 0);
		System.out.println("\n"+"�������");
		postOrder(arr, 0);
		
	}
	
	//���˳��洢��������ǰ�����
	public static void preOrder(int[] arr, int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
			return;
		}
		System.out.print(arr[index]);
		//����ݹ�
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +1);
		}
		//���ҵݹ�
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +2);
		}
		
	}
	
	//�������
	public static void infixOrder(int[] arr, int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
			return;
		}
		
		//����ݹ�
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +1);
		}
		System.out.print(arr[index]);
		//���ҵݹ�
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +2);
		}
	}
	
	//�������
	public static void postOrder(int[] arr, int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
			return;
		}
		
		//����ݹ�
		if(2*index +2 < arr.length) {
			preOrder(arr, 2*index +1);
		}
	
		//���ҵݹ�
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
//	//���˳��洢��������ǰ�����
//	public void preOrder(int index) {
//		if(arr == null || arr.length == 0) {
//			System.out.println("����Ϊ��");
//			return;
//		}
//		System.out.print(arr[index]);
//		//����ݹ�
//		if(2*index +2 < arr.length) {
//			preOrder(2*index +1);
//		}
//		//���ҵݹ�
//		if(2*index +2 < arr.length) {
//			preOrder(2*index +2);
//		}
//		
//	}
//}

