package Graphs;

public class Graph_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5);
		String[] arr = {"A","B","C","D","E"};
		for(String i:arr)
			graph.InsertVertex(i);
		
		graph.InsertEdge(0, 1, 1);
		graph.InsertEdge(0, 2, 1);
		graph.InsertEdge(2, 3, 1);
		graph.InsertEdge(0, 4, 1);
		graph.InsertEdge(1, 2, 1);
		graph.InsertEdge(2, 4, 1);
		graph.ShowGraph();
		System.out.println("深度优先");
		graph.DFS(0);
		graph.ClearVisit();
		System.out.println("\n广度优先");
		graph.BFS(0);
	}

}
