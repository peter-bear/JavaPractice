package DataStructure;

public class MazeRecursionDemo {
	public static void main(String[] args) {
		// ������ͼ
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
		System.out.println("\t��ͼ");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		tryWay(map, 1,1);
		System.out.println();
		System.out.println("\t·��");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean tryWay(int[][] map, int i, int j) {
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
                //�����ߵ�ͨ
				if (tryWay(map, i+1, j)) {
					return true;
				} 
                //�����ߵ�ͨ
				else if (tryWay(map, i, j+1)) {
					return true;
				} 
                //�����ߵ�ͨ
				else if (tryWay(map, i, j - 1)) {
					return true;
				}
                //�����ߵ�ͨ
				else if (tryWay(map, i-1, j)) {
					return true;
				}
                //�������Ҷ��߲�ͨ
				else {
                    //��ʾ����㲻���ߣ�������һ���ڵ�
					map[i][j] = 3;
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
