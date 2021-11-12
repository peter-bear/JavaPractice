package Search;

public class InsertSearching {
	public static void main(String[] args) {
		int[] array = {17, 20, 26, 31, 44,44, 54, 55, 77, 93};
		System.out.println(search(array, 1, 0, array.length-1));
		
	}
	
	//µİ¹é°æ±¾
	public static boolean search(int[] array, int num, int left, int right) {
		int index = left+(right-left)*(num-array[left])/(array[right]-array[left]);
		if(left>right || index<0) {
			return false;
		}
		if(array[index] > num) {
			return search(array, num, left, index-1);
		}
		else if(array[index] < num) {
			return search(array, num, index+1, right);
		}
		else
		{
			return true;
		}
	}
	
}
