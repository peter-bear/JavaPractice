package CollectionStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListCollection {
	public static void main(String[] args) {
		ArrayList<Students> container = new ArrayList<>();
		Students Jim = new Students(18, "Jim");
//		Students Tom = new Students(20, "Tom");
		System.out.println("是否增添了Jim："+container.add(Jim));
		container.add(new Students(20, "Tom"));
		System.out.println("获取第一个元素："+container.get(0));
		//把第2个元素设置为Alex
		container.set(1, new Students(78, "Alex"));
		System.out.println("第2个元素是："+container.get(1));
		//container包含的元素个数
		System.out.println("元素个数："+container.size());
		//将ArrayList转化为数组
		Object[] array = container.toArray();
		System.out.println("将ArrayList转化为数组："+Arrays.toString(array));
		//删除元素
		System.out.println("删除： "+container.remove(new Students(18, "Jim")));
		System.out.println("删除后个数:"+container.size());
	}
}
