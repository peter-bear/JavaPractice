package DataStructure;

public class MazeRecursionDemo {
	public static void main(String[] args) {
		// 构建地图
		int[][] map = new int[10][10];
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
		System.out.println("\t地图");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		tryWay(map, 1,1);
		System.out.println();
		System.out.println("\t路线");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean tryWay(int[][] map, int i, int j) {
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
                //向下走得通
				if (tryWay(map, i+1, j)) {
					return true;
				} 
                //向右走得通
				else if (tryWay(map, i, j+1)) {
					return true;
				} 
                //向左走得通
				else if (tryWay(map, i, j - 1)) {
					return true;
				}
                //向上走得通
				else if (tryWay(map, i-1, j)) {
					return true;
				}
                //上下左右都走不通
				else {
                    //表示这个点不能走，返回上一个节点
					map[i][j] = 3;
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
