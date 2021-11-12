package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, HashSet<String>> radios = new HashMap<>();
		HashSet<String> k1 = new HashSet<>();
		k1.add("����");
		k1.add("�Ϻ�");
		k1.add("���");
		
		HashSet<String> k2 = new HashSet<>();
		k2.add("����");
		k2.add("����");
		k2.add("����");
		
		HashSet<String> k3 = new HashSet<>();
		k3.add("�ɶ�");
		k3.add("�Ϻ�");
		k3.add("����");
		
		HashSet<String> k4 = new HashSet<>();
		k4.add("�Ϻ�");
		k4.add("���");
		
		HashSet<String> k5 = new HashSet<>();
		k5.add("����");
		k5.add("����");
		
		radios.put("k1", k1);
		radios.put("k2", k2);
		radios.put("k3", k3);
		radios.put("k4", k4);
		radios.put("k5", k5);
		
		HashSet<String> allAreas = new HashSet<>();
		allAreas.addAll(k1);
		allAreas.addAll(k2);
		allAreas.addAll(k3);
		allAreas.addAll(k4);
		allAreas.addAll(k5);
		
		ArrayList<String> result = new ArrayList<>();
		
		String MaxKey = null;
		while(!allAreas.isEmpty()) {
			for(String key:radios.keySet()) {
				HashSet<String> temp = radios.get(key);
				temp.retainAll(allAreas); //ѡȡ����
				
				//���뽻������0 ���� �����Ĵ�С�������Ĵ�С
				if( temp.size() >0 && (MaxKey == null || temp.size() > radios.get(MaxKey).size())) {
					MaxKey = key; //���ܸ�ֵ
				}
			}
			
			//�����ֵ��ΪNULLʱ���Ѵ���ӽ�ȥ���Ƴ���Ӧ�ĵ���
			if(MaxKey != null) {
				result.add(MaxKey);
				allAreas.removeAll(radios.get(MaxKey));
			}
			
		}
		
		System.out.println(result);

	}

}
