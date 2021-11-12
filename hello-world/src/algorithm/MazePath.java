package algorithm;

import java.awt.Graphics;
import java.awt.Panel;

import Graphs.Graph;

public class MazePath extends Thread {
	public static void main(String[] args) {
//		// ������ͼ
//		int[][] map = PrimMazeCreating.Prim(31, 31, 1, 1);
//
//		System.out.println("\t��ͼ");
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		tryWay(map, 1,1,map.length-2, map[0].length-2);
//		System.out.println();
//		System.out.println("\t·��");
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
        //��������յ㣬ֱ�ӷ���true���������
		if (map[final_r][final_c] == 2) {
			return true;
		} 
        //û�е����յ�
		else {
            //�������λ��֮ǰû���߹���֮ǰ�߹���Ϊ2��Ҳ������
			if(map[i][j] ==1) {
                //��������ͨ
				map[i][j] = 2;
				
				p.repaint();
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
                //�����ߵ�ͨ
				if (tryWay(map, i+1, j, final_r, final_c, p)) {
					return true;
				} 
                //�����ߵ�ͨ
				else if (tryWay(map, i, j+1, final_r, final_c, p)) {
					return true;
				} 
                //�����ߵ�ͨ
				else if (tryWay(map, i, j - 1, final_r, final_c, p)) {
					return true;
				}
                //�����ߵ�ͨ
				else if (tryWay(map, i-1, j, final_r, final_c, p)) {
					return true;
				}
                //�������Ҷ��߲�ͨ
				else {
                    //��ʾ����㲻���ߣ�������һ���ڵ�
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
            //����λ����ǽ�������ߵ�λ�ã����Ѿ��߹��ĵط�
			else {
                //map[i][j] =1��2��3
				return false; //����false��������һ���ڵ�λ��
			}
		}
	}
}
