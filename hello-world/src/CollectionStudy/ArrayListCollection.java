package CollectionStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListCollection {
	public static void main(String[] args) {
		ArrayList<Students> container = new ArrayList<>();
		Students Jim = new Students(18, "Jim");
//		Students Tom = new Students(20, "Tom");
		System.out.println("�Ƿ�������Jim��"+container.add(Jim));
		container.add(new Students(20, "Tom"));
		System.out.println("��ȡ��һ��Ԫ�أ�"+container.get(0));
		//�ѵ�2��Ԫ������ΪAlex
		container.set(1, new Students(78, "Alex"));
		System.out.println("��2��Ԫ���ǣ�"+container.get(1));
		//container������Ԫ�ظ���
		System.out.println("Ԫ�ظ�����"+container.size());
		//��ArrayListת��Ϊ����
		Object[] array = container.toArray();
		System.out.println("��ArrayListת��Ϊ���飺"+Arrays.toString(array));
		//ɾ��Ԫ��
		System.out.println("ɾ���� "+container.remove(new Students(18, "Jim")));
		System.out.println("ɾ�������:"+container.size());
	}
}
