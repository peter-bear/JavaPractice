package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class DijkstraAlgorithm2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"A","B","C","D","E","F","G"};
		int[][] matrix = {
				{0,5,7,0,0,0,2},
				{5,0,0,9,0,0,3},
				{7,0,0,0,8,0,0},
				{0,9,0,0,0,4,0},
				{0,0,8,0,0,5,4},
				{0,0,0,4,5,0,6},
				{2,3,0,0,4,6,0}
		};
	
		Dijkstra(matrix, 2);
	}
	
	/*��������������Ϊ��
	 * �ж�������not preNode
	 * 	�ı�Dis��Pre����
	 * 		С�����о���
	 * 	ѹ������
	 * 		not visited �� ���ڶ�����
	 * 
	 * ������һ����󣬽��˵��Ϊisvisited
	 * */
    
    //index is the start vertex, matrix is the adjacent matrix(graph)
	public static void Dijkstra(int[][] matrix, int index) {
        Graph graph = new Graph(matrix[0].length); //��ʼ��һ��Graph��
        graph.SetDis(index, 0); //index��Ŀ�궥�㣬���Ըö��㵽����ľ���Ϊ0
        LinkedList<Integer> list = new LinkedList<>(); //�洢����Ķ���
        int[] ContainList = new int[matrix[0].length];

        //�ѵ�һ������ѹ�����
        list.push(index);
        ContainList[index] = 1;

        //��ʱ����
        int dis=0;
        int temp =0;

        //�������������Ƕ���Ϊ��
        while(!list.isEmpty()) {
            temp = list.pop(); //�Ӷ�����popһ��Ԫ��
            ContainList[temp] =0;
            //Ѱ�����Ԫ�������Ķ���
            for(int i=0;i<matrix[temp].length;i++) {
                //�ж������������Ķ��㲻�����Լ���preNode,ͬʱҪ���������Ķ���
                if(matrix[temp][i]!=0 && graph.GetPreNode(i)!=temp) {
                    //��ȡ��ʱ��·������
                    dis = matrix[temp][i]+graph.GetDis(temp);
                    //����������С�����еĳ���
                    if(dis<graph.GetDis(i)) {
                        //��ԭ����ĳ��Ƚ����滻
                        graph.SetPreNode(i, temp);
                        //�޸�preNode
                        graph.SetDis(i, dis);

                        //�ܹ���ѹ����е�������û�����ʹ��Ҳ��ڶ�����
                        if(!graph.GetVisited(i) && ContainList[i]==0) {
                            list.push(i);
                            ContainList[i] =1;
                        }
                    }
                }
            }
            //һ��������ɱ����󣬽�������Ϊ�ѷ���
            graph.SetVisited(temp, true);
        }
        
        graph.ShowDis();
        
		
	}
	
	
	
	
	private static class Graph{
		private boolean[] isVisited; //�洢�Ƿ񱻷���
		private int[] PreNode; //ǰ��㼯��
		private int[] Dis; //�洢��ÿ���������̾���
		private final static int infinity = Integer.MAX_VALUE; //����
		
		public Graph(int len){
            //��ʼ������
			isVisited = new boolean[len];
			PreNode = new int[len];
			Dis = new int[len];

			//����ÿ�������ǰһ�����㶼�������Լ�
			for(int i=0;i<len;i++) {
				PreNode[i] = -1;
				Dis[i] = infinity; //���迪ʼ��ÿ���������̾���Ϊ����
		
			}
			
		}

		//չʾ��̾���
		public void ShowDis() {
			System.out.println(Arrays.toString(Dis));
		}
		
    	//չʾǰ����
		public void ShowPreNode() {
			System.out.println(Arrays.toString(PreNode));
		}
		
    	//չʾ���ʵ����
		public void ShowVisited() {
			System.out.println(Arrays.toString(isVisited));
		}
		
	    //��ȡĳ�����㵽Ŀ�����̾���
		public int GetDis(int n) {
			return Dis[n];
		}
		
    	//����ĳ���㵽Ŀ�����̾���
		public void SetDis(int n, int m) {
			Dis[n] =m;
		}
		
    	//��ȡǰ���ʶ���
		public int GetPreNode(int n) {
			return PreNode[n];
		}
		
    	//����ǰ���ʶ���
		public void SetPreNode(int n, int m) {
			PreNode[n] =m;
		}
		
    	//��ȡ����ķ���״̬
		public boolean GetVisited(int n) {
			return isVisited[n];
		}
		
    	//���ö���ķ���״̬
		public void SetVisited(int n, boolean rst) {
			isVisited[n] = rst;
		}	
	}

}
