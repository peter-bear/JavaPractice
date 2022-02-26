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
	
	/*结束条件：队列为空
	 * 判断条件：not preNode
	 * 	改变Dis与Pre条件
	 * 		小于已有距离
	 * 	压入条件
	 * 		not visited 且 不在队列中
	 * 
	 * 遍历完一个点后，将此点改为isvisited
	 * */
    
    //index is the start vertex, matrix is the adjacent matrix(graph)
	public static void Dijkstra(int[][] matrix, int index) {
        Graph graph = new Graph(matrix[0].length); //初始化一个Graph类
        graph.SetDis(index, 0); //index是目标顶点，所以该顶点到自身的距离为0
        LinkedList<Integer> list = new LinkedList<>(); //存储顶点的队列
        int[] ContainList = new int[matrix[0].length];

        //把第一个顶点压入队列
        list.push(index);
        ContainList[index] = 1;

        //暂时变量
        int dis=0;
        int temp =0;

        //结束的条件就是队列为空
        while(!list.isEmpty()) {
            temp = list.pop(); //从队列中pop一个元素
            ContainList[temp] =0;
            //寻找与此元素相连的顶点
            for(int i=0;i<matrix[temp].length;i++) {
                //判断条件，相连的顶点不能是自己的preNode,同时要与其相连的顶点
                if(matrix[temp][i]!=0 && graph.GetPreNode(i)!=temp) {
                    //获取此时的路径长度
                    dis = matrix[temp][i]+graph.GetDis(temp);
                    //如果这个长度小于已有的长度
                    if(dis<graph.GetDis(i)) {
                        //对原顶点的长度进行替换
                        graph.SetPreNode(i, temp);
                        //修改preNode
                        graph.SetDis(i, dis);

                        //能够被压入队列的条件：没被访问过且不在队列中
                        if(!graph.GetVisited(i) && ContainList[i]==0) {
                            list.push(i);
                            ContainList[i] =1;
                        }
                    }
                }
            }
            //一个顶点完成遍历后，将其设置为已访问
            graph.SetVisited(temp, true);
        }
        
        graph.ShowDis();
        
		
	}
	
	
	
	
	private static class Graph{
		private boolean[] isVisited; //存储是否被访问
		private int[] PreNode; //前结点集合
		private int[] Dis; //存储到每个顶点的最短距离
		private final static int infinity = Integer.MAX_VALUE; //常量
		
		public Graph(int len){
            //初始化变量
			isVisited = new boolean[len];
			PreNode = new int[len];
			Dis = new int[len];

			//假设每个顶点的前一个顶点都是他们自己
			for(int i=0;i<len;i++) {
				PreNode[i] = -1;
				Dis[i] = infinity; //假设开始到每个顶点的最短距离为无穷
		
			}
			
		}

		//展示最短距离
		public void ShowDis() {
			System.out.println(Arrays.toString(Dis));
		}
		
    	//展示前顶点
		public void ShowPreNode() {
			System.out.println(Arrays.toString(PreNode));
		}
		
    	//展示访问的情况
		public void ShowVisited() {
			System.out.println(Arrays.toString(isVisited));
		}
		
	    //获取某个顶点到目标的最短距离
		public int GetDis(int n) {
			return Dis[n];
		}
		
    	//设置某顶点到目标的最短距离
		public void SetDis(int n, int m) {
			Dis[n] =m;
		}
		
    	//获取前访问顶点
		public int GetPreNode(int n) {
			return PreNode[n];
		}
		
    	//设置前访问顶点
		public void SetPreNode(int n, int m) {
			PreNode[n] =m;
		}
		
    	//获取顶点的访问状态
		public boolean GetVisited(int n) {
			return isVisited[n];
		}
		
    	//设置顶点的访问状态
		public void SetVisited(int n, boolean rst) {
			isVisited[n] = rst;
		}	
	}

}
