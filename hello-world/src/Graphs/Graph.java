package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	private ArrayList<String> vertexList;
	LinkedList<Integer> queue;
	private int[][] edges;
	private int numOfEdges;//边的数目
	boolean[] isVisited; 
	
	/**
	 * 
	 * @param n 传入顶点个数
	 */
	Graph(int n){
		edges = new int[n][n]; //以二维邻接矩阵来构建图 
		vertexList = new ArrayList<>(n);//用于存储顶点信息
		queue = new LinkedList<>();
		 isVisited= new boolean[n];
		numOfEdges =0;
	}
	
	/**
	 * 
	 * @return 有多少个顶点
	 */
	public int VertexNum() {
		return vertexList.size();
	}
	
	/**
	 * 
	 * @return 有多少条边
	 */
	public int EdgeLength() {
		return numOfEdges;
	}
	
	/**
	 * 
	 * @param index 传入下标
	 * @return 返回对应的顶点
	 */
	public String GetVertex(int index) {
		return vertexList.get(index);
	}
	
	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return 返回2个顶点的权值
	 */
	public int GetWeight(int v1, int v2) {
		return edges[v1][v2];
	}
	
	/**
	 * 插入节点
	 * @param vertex
	 */
	public void InsertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	/**
	 * 
	 * @param v1 点1的下标，第几个顶点
	 * @param v2 点2的下标，第几个顶点
	 * @param weight 表示点1与点2是否相互连接
	 */
	public void InsertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	/**
	 * 
	 * @param index 传入指定的index
	 * 1. 打印出头顶点
	 * 2. 将头顶点isVisited设为true
	 * 3. 遍历查找与头顶点相连的顶点且not visited
	 * 4. 如果查找到，立马将找到的这个index传入进行递归
	 * 
	 * 
	 */
	
	//deep first search, 深度优先遍历
	public void DFS(int index) {
		System.out.print(GetVertex(index)+" ");
		isVisited[index] = true;
		for(int j=0;j<VertexNum();j++) 
			if(edges[index][j]>0 && !isVisited[j])
				DFS(j);
		
	}
	
	/**
	 * clear isVisited数组
	 */
	//清空visited记录
	public void ClearVisit() {
		isVisited= new boolean[VertexNum()];
	}

	

	/**
	 * 广度优先使用队列完成
	 * 先入队列，isvisited设置为true
	 * 进入循环，若队列为空，停止循环
	 * 循环中，先弹出一个，打印出来
	 * 根据这个顶点查找与其连接，且没有入队列的
	 * 如果发现，入队列，isVisited为true
	 * 直到循环结束
	 * @param index 指向的顶点
	 */
	//BFS 广度优先broad first search
	public void BFS(int index) {
		queue.add(index);
		isVisited[index] = true;
		while(!queue.isEmpty()) {
			index = queue.pop();
			
			System.out.print(GetVertex(index)+" ");
			for(int j=0;j<VertexNum();j++) {
				if(edges[index][j] >0 && !isVisited[j]) {
					queue.add(j);
					isVisited[j] = true;
				}
			}
		}
	}
	
	//显示邻接矩阵图
	public void ShowGraph() {
		System.out.print("  ");
		for(int i=0;i<VertexNum();i++)
			System.out.print(vertexList.get(i)+" ");
		System.out.println();
		for(int j=0;j<edges.length;j++) {
			System.out.print(vertexList.get(j));
			for(int k=0;k<edges[0].length;k++) {
				System.out.print(" "+edges[j][k]);
			}
			System.out.println();
		}
	}
}
