package algorithm;

import java.awt.Graphics;
import java.awt.Panel;

import Graphs.Graph;

public class MazePath extends Thread {
	public static void main(String[] args) {
//		// 构建地图
//		int[][] map = PrimMazeCreating.Prim(31, 31, 1, 1);
//
//		System.out.println("\t地图");
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		tryWay(map, 1,1,map.length-2, map[0].length-2);
//		System.out.println();
//		System.out.println("\t路线");
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

	}
	
	private int[][] map;
	private int i;
	private int j;
	private int f_r;
	private int f_c;
	private Panel p;
	
	MazePath(int[][] map, int i, int j, int final_r, int final_c, Panel p){
		this.map = map;
		this.i = i;
		this.j = j;
		this.f_c = final_c;
		this.f_r = final_r;
		this.p = p;
	}

	@Override
	public void run() {
		tryWay(map, i, j, f_r, f_c, p);
	}



	private static boolean tryWay(int[][] map, int i, int j, int final_r, int final_c, Panel p) {
        //如果到达终点，直接返回true，程序结束
		if (map[final_r][final_c] == 2) {
			return true;
		} 
        //没有到达终点
		else {
            //如果所在位置之前没有走过，之前走过标为2，也不能走
			if(map[i][j] ==1) {
                //假设能走通
				map[i][j] = 2;
				
				p.repaint();
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
                //向下走得通
				if (tryWay(map, i+1, j, final_r, final_c, p)) {
					return true;
				} 
                //向右走得通
				else if (tryWay(map, i, j+1, final_r, final_c, p)) {
					return true;
				} 
                //向左走得通
				else if (tryWay(map, i, j - 1, final_r, final_c, p)) {
					return true;
				}
                //向上走得通
				else if (tryWay(map, i-1, j, final_r, final_c, p)) {
					return true;
				}
                //上下左右都走不通
				else {
                    //表示这个点不能走，返回上一个节点
					map[i][j] = 3;
					
					p.repaint();
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return false;
				}
			}
            //所在位置是墙，或不能走的位置，或已经走过的地方
			else {
                //map[i][j] =1或2或3
				return false; //返回false，返回上一个节点位置
			}
		}
	}
}
