
public class BinarySearchTest {

	public static void main(String[] args) {
		int[] array = { 31, 44, 54, 55,77, 93, 226 };
		System.out.println("hello");
		Search(array, 77);
	}
	
	public static void Search(int[] array, int num) {
		int left =0;
		int right = array.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(array[mid] < num) {
				left = mid;
			}else if(array[mid] > num) {
				right = mid;
			}else {
				System.out.println(array[mid]);
				break;
			}
		}
	}

}
