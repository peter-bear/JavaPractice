package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	private ArrayList<String> vertexList;
	LinkedList<Integer> queue;
	private int[][] edges;
	private int numOfEdges;//�ߵ���Ŀ
	boolean[] isVisited; 
	
	/**
	 * 
	 * @param n ���붥�����
	 */
	Graph(int n){
		edges = new int[n][n]; //�Զ�ά�ڽӾ���������ͼ 
		vertexList = new ArrayList<>(n);//���ڴ洢������Ϣ
		queue = new LinkedList<>();
		 isVisited= new boolean[n];
		numOfEdges =0;
	}
	
	/**
	 * 
	 * @return �ж��ٸ�����
	 */
	public int VertexNum() {
		return vertexList.size();
	}
	
	/**
	 * 
	 * @return �ж�������
	 */
	public int EdgeLength() {
		return numOfEdges;
	}
	
	/**
	 * 
	 * @param index �����±�
	 * @return ���ض�Ӧ�Ķ���
	 */
	public String GetVertex(int index) {
		return vertexList.get(index);
	}
	
	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return ����2�������Ȩֵ
	 */
	public int GetWeight(int v1, int v2) {
		return edges[v1][v2];
	}
	
	/**
	 * ����ڵ�
	 * @param vertex
	 */
	public void InsertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	/**
	 * 
	 * @param v1 ��1���±꣬�ڼ�������
	 * @param v2 ��2���±꣬�ڼ�������
	 * @param weight ��ʾ��1���2�Ƿ��໥����
	 */
	public void InsertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	/**
	 * 
	 * @param index ����ָ����index
	 * 1. ��ӡ��ͷ����
	 * 2. ��ͷ����isVisited��Ϊtrue
	 * 3. ����������ͷ���������Ķ�����not visited
	 * 4. ������ҵ��������ҵ������index������еݹ�
	 * 
	 * 
	 */
	
	//deep first search, ������ȱ���
	public void DFS(int index) {
		System.out.print(GetVertex(index)+" ");
		isVisited[index] = true;
		for(int j=0;j<VertexNum();j++) 
			if(edges[index][j]>0 && !isVisited[j])
				DFS(j);
		
	}
	
	/**
	 * clear isVisited����
	 */
	//���visited��¼
	public void ClearVisit() {
		isVisited= new boolean[VertexNum()];
	}

	

	/**
	 * �������ʹ�ö������
	 * ������У�isvisited����Ϊtrue
	 * ����ѭ����������Ϊ�գ�ֹͣѭ��
	 * ѭ���У��ȵ���һ������ӡ����
	 * ���������������������ӣ���û������е�
	 * ������֣�����У�isVisitedΪtrue
	 * ֱ��ѭ������
	 * @param index ָ��Ķ���
	 */
	//BFS �������broad first search
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
	
	//��ʾ�ڽӾ���ͼ
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
