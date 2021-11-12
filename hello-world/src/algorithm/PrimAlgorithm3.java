package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimAlgorithm3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = {'A','B','C','D','E','F','G'};
		
		AdjNode[] adjList = new AdjNode[7];
		adjList[0] = new AdjNode(0, 0, new AdjNode(1, 5, new AdjNode(2, 7, new AdjNode(6, 2, null))));
		adjList[1] = new AdjNode(1, 0, new AdjNode(0, 5, new AdjNode(6, 3, new AdjNode(3, 9, null))));
		adjList[2] = new AdjNode(2, 0, new AdjNode(0, 7, new AdjNode(4, 8, null)));
		adjList[3] = new AdjNode(3, 0, new AdjNode(1, 9, new AdjNode(5, 4, null)));
		adjList[4] = new AdjNode(4, 0, new AdjNode(2, 8, new AdjNode(6, 4, new AdjNode(5, 5, null))));
		adjList[5] = new AdjNode(5, 0, new AdjNode(3, 4, new AdjNode(6, 6, new AdjNode(4, 5, null))));
		adjList[6] = new AdjNode(6, 0, new AdjNode(0, 2, new AdjNode(1, 3, new AdjNode(4, 4, new AdjNode(5,6,null)))));
		System.out.println("Start");
		Prim(adjList, data, 0);
		
	}
	
	private static class AdjNode{
		int id;
		AdjNode next;
		int weight;
		AdjNode(int i, int w, AdjNode n){
			id = i;
			weight =w;
			next = n;
		}
		
	}
	
	private static class HeapNode{
		int id;
		int weight;
		int parent;
		HeapNode(int i, int w, int p){
			id =i;
			weight =w;
			parent =p;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return weight+"";
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return ((HeapNode)obj).id == this.id;
		}
		
		
		
	}
	
	//Prim Algorithm With Heap
	public static void Prim(AdjNode[] list, char[] data, int start) {
		int num = data.length;
		int count=0;
//		PriorityQueue<HeapNode> q = new PriorityQueue<>();
		
		
		HeapNode[] rst = new HeapNode[num];
		LinkedList<HeapNode> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[num];
		
		queue.push(new HeapNode(start, 0, -1));
		isVisited[start] = true;
		
		while(count != num) {
			for(int i=queue.size()/2; i >=0 ;i--) { /*Build Heap*/

				BuildHeap(i, queue.size(), queue);
				
			
			}
				
			
			HeapNode parent =queue.pop();
			

			
			rst[count] = parent;
			AdjNode cur = list[parent.id].next;
			
			while(cur!= null) {
				int index =queue.indexOf(new HeapNode(cur.id, 0, 0));
				if(index == -1) {
					if(!isVisited[cur.id]) {
						queue.push(new HeapNode(cur.id, cur.weight, parent.id));
						isVisited[cur.id] = true;
					}
				}
				else{
					HeapNode temp =queue.get(index);
					if(cur.weight < temp.weight) {
						queue.set(index, new HeapNode(temp.id, cur.weight, parent.id));
					}
				}
				cur = cur.next;
			}
			
			count++;
			

	
		}
		

		count =0;
		for(int i=1;i<num;i++) {
			count += rst[i].weight;
			System.out.println(data[rst[i].parent]+"-"+data[rst[i].id]+" "+rst[i].weight);
		}
		System.out.println(count);
		
		

		

		
	}
	
	
	
	//构建小顶堆
	private static void BuildHeap(int i, int end, LinkedList<HeapNode> weights) {
		int child;
		HeapNode temp;

		for(temp = weights.get(i); leftChild(i) < end;i = child ) {
			child = leftChild(i);
			//找出三个中最小的
			if(child != end-1 && weights.get(child).weight >weights.get(child+1).weight) //判断左边大于右边
				child++;
			if(temp.weight > weights.get(child).weight) //判断父结点是否大于子节点
				weights.set(i, weights.get(child));
			else {
				break;
			}
		}
		weights.set(i, temp);
	}
	
	
	
	private static int leftChild(int i) {
		return 2*i +1;
	}

}
