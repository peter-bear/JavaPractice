package DataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class MazeRecursionDemo2 {
	public static void main(String[] args) {
		// 构建地图
		int[][] map = new int[10][10];
		InitMap(map); //地图初始化
		System.out.println("\t地图");
		PrintMap(map);
		
		//求出最短路径
		char[] directions = {'上','下','左','右'};
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
		System.out.println("所有方向可能性与步数");
		for(Entry<String, Integer> i : dic.entrySet()) {
			System.out.println("\t"+i.getKey()+"----"+i.getValue());
		}
		
		Collection<Integer> values = dic.values();
		int smallest = Collections.min(values);
		
		System.out.println();
		System.out.println("最优的路径----步数："+smallest);
		for(Entry<String, Integer> i : dic.entrySet()) {
			if(i.getValue() == smallest) {
				System.out.println("\t"+i.getKey());
				tryWay(map, 1,1,i.getKey());
				PrintMap(map);
				InitMap(map);
			}
		}
		
		
	}
	
	//打印地图
	public static void PrintMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//初始化地图
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
	
	//统计小球走的路径距离
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
	
	//使用递归改变方向（上下左右的排列组合）
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
	
	
	//使用递归寻找出口
	public static boolean tryWay(int[][] map, int i, int j, String direction) {
        //如果到达终点，直接返回true，程序结束
		if (map[8][8] == 2) {
			return true;
		} 
        //没有到达终点
		else {
            //如果所在位置之前没有走过，之前走过标为2，也不能走
			if(map[i][j] ==0) {
                //假设能走通
				map[i][j] = 2;
				for(int a=0;a<4;a++) {
					switch (direction.charAt(a)) {
					case '上':
						//向上走得通
						if (tryWay(map, i-1, j,direction)) {
							return true;
						}
						break;
					case '下':
						//向下走得通
						if (tryWay(map, i+1, j, direction)) {
							return true;
						} 
						break;
					case '左':
						//向左走得通
						if (tryWay(map, i, j - 1, direction)) {
							return true;
						}
						break;
					case '右':
						//向右走得通
						if (tryWay(map, i, j+1, direction)) {
							return true;
						} 
						break;
					
					default:
						break;
					}
				}
				
				
                //上下左右都走不通
                //表示这个点不能走，返回上一个节点
				map[i][j] = 3;
				return false;
				
			}
            //所在位置是墙，或不能走的位置，或已经走过的地方
			else {
                //map[i][j] =1或2或3
				return false; //返回false，返回上一个节点位置
			}
		}
	}
}
