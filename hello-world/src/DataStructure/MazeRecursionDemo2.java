package DataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class MazeRecursionDemo2 {
	public static void main(String[] args) {
		// ������ͼ
		int[][] map = new int[10][10];
		InitMap(map); //��ͼ��ʼ��
		System.out.println("\t��ͼ");
		PrintMap(map);
		
		//������·��
		char[] directions = {'��','��','��','��'};
		ArrayList<String> list = new ArrayList<>();
		Search(list, directions, new StringBuffer());
		
		HashMap<String, Integer> dic = new HashMap<>();
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			String move = itr.next();
			tryWay(map, 1,1,move);
			dic.put(move, Count(map));
			InitMap(map);
		}
		System.out.println();
		System.out.println("���з���������벽��");
		for(Entry<String, Integer> i : dic.entrySet()) {
			System.out.println("\t"+i.getKey()+"----"+i.getValue());
		}
		
		Collection<Integer> values = dic.values();
		int smallest = Collections.min(values);
		
		System.out.println();
		System.out.println("���ŵ�·��----������"+smallest);
		for(Entry<String, Integer> i : dic.entrySet()) {
			if(i.getValue() == smallest) {
				System.out.println("\t"+i.getKey());
				tryWay(map, 1,1,i.getKey());
				PrintMap(map);
				InitMap(map);
			}
		}
		
		
	}
	
	//��ӡ��ͼ
	public static void PrintMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//��ʼ����ͼ
	public static void InitMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] =0;
			}
		}
		for (int a = 0; a < map[0].length; a++) {
			map[0][a] = 1;
			map[map.length - 1][a] = 1;
		}
		for (int b = 0; b < map.length; b++) {
			map[b][0] = 1;
			map[b][map[0].length - 1] = 1;
		}
		map[1][5] = 1;
		map[2][5] = 1;
		map[3][5] = 1;
		map[3][1] = 1;
		map[3][2] = 1;
		map[3][3] = 1;
		map[5][3] = 1;
		map[5][4] = 1;
		map[5][5] = 1;
		map[5][6] = 1;
		map[5][7] = 1;
		map[5][8] = 1;
	}
	
	//ͳ��С���ߵ�·������
	public static int Count(int[][] map) {
		int cnt=0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] ==2 ||map[i][j] ==3) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	//ʹ�õݹ�ı䷽���������ҵ�������ϣ�
	public static void Search(ArrayList<String> list,char[] directions,StringBuffer sb) {
		if(sb.length() == directions.length) {
			list.add(sb.toString());
			
			return;
		}
		for(int i=0;i<directions.length;i++) {
			if(sb.toString().indexOf(directions[i])!=-1) continue;
			sb.append(directions[i]);
			Search(list, directions, sb);
			sb.deleteCharAt(sb.length()-1);
			
		}
		
	}
	
	
	//ʹ�õݹ�Ѱ�ҳ���
	public static boolean tryWay(int[][] map, int i, int j, String direction) {
        //��������յ㣬ֱ�ӷ���true���������
		if (map[8][8] == 2) {
			return true;
		} 
        //û�е����յ�
		else {
            //�������λ��֮ǰû���߹���֮ǰ�߹���Ϊ2��Ҳ������
			if(map[i][j] ==0) {
                //��������ͨ
				map[i][j] = 2;
				for(int a=0;a<4;a++) {
					switch (direction.charAt(a)) {
					case '��':
						//�����ߵ�ͨ
						if (tryWay(map, i-1, j,direction)) {
							return true;
						}
						break;
					case '��':
						//�����ߵ�ͨ
						if (tryWay(map, i+1, j, direction)) {
							return true;
						} 
						break;
					case '��':
						//�����ߵ�ͨ
						if (tryWay(map, i, j - 1, direction)) {
							return true;
						}
						break;
					case '��':
						//�����ߵ�ͨ
						if (tryWay(map, i, j+1, direction)) {
							return true;
						} 
						break;
					
					default:
						break;
					}
				}
				
				
                //�������Ҷ��߲�ͨ
                //��ʾ����㲻���ߣ�������һ���ڵ�
				map[i][j] = 3;
				return false;
				
			}
            //����λ����ǽ�������ߵ�λ�ã����Ѿ��߹��ĵط�
			else {
                //map[i][j] =1��2��3
				return false; //����false��������һ���ڵ�λ��
			}
		}
	}
}
