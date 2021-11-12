package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, HashSet<String>> radios = new HashMap<>();
		HashSet<String> k1 = new HashSet<>();
		k1.add("北京");
		k1.add("上海");
		k1.add("天津");
		
		HashSet<String> k2 = new HashSet<>();
		k2.add("广州");
		k2.add("北京");
		k2.add("深圳");
		
		HashSet<String> k3 = new HashSet<>();
		k3.add("成都");
		k3.add("上海");
		k3.add("杭州");
		
		HashSet<String> k4 = new HashSet<>();
		k4.add("上海");
		k4.add("天津");
		
		HashSet<String> k5 = new HashSet<>();
		k5.add("杭州");
		k5.add("大连");
		
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
				temp.retainAll(allAreas); //选取交集
				
				//必须交集大于0 或者 交集的大小大于最大的大小
				if( temp.size() >0 && (MaxKey == null || temp.size() > radios.get(MaxKey).size())) {
					MaxKey = key; //才能赋值
				}
			}
			
			//当最大赋值不为NULL时，把答案添加进去，移除对应的地区
			if(MaxKey != null) {
				result.add(MaxKey);
				allAreas.removeAll(radios.get(MaxKey));
			}
			
		}
		
		System.out.println(result);

	}

}
