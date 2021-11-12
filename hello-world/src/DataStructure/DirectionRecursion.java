package DataStructure;

import java.util.ArrayList;
import java.util.Iterator;

public class DirectionRecursion {
	public static void main(String[] args) {
		char[] directions = {'上','下','左','右'};
		ArrayList<String> list = new ArrayList<>(); 
		test(list, directions, new StringBuffer());
		Iterator<String> itr = list.iterator();
		int count = 0;
		while(itr.hasNext()) {
			System.out.println(itr.next());
			count+=1;
		}
		System.out.println("一共有"+count+"种可能");
		
	}
	public static void test(ArrayList<String> list,char[] directions,StringBuffer sb) {
		if(sb.length() == directions.length) {
			list.add(sb.toString());
			
			return;
		}
		for(int i=0;i<directions.length;i++) {
			if(sb.toString().indexOf(directions[i])!=-1) continue;
			sb.append(directions[i]);
			test(list, directions, sb);
			sb.deleteCharAt(sb.length()-1);
			
		}
		
	}
}
