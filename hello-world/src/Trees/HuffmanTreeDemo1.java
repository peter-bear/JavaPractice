package Trees;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTreeDemo1 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 6, 7, 8, 13, 29};
		ArrayList<HuffmanNode> nodes = new ArrayList<>(); 
		for(int i:arr) {
			nodes.add(new HuffmanNode(i));
		}
		Collections.sort(nodes);
		CrtTree(nodes);
		System.out.println("前序遍历");
		preOrder(nodes.get(0));

	}
	
	public static void CrtTree(ArrayList<HuffmanNode> nodes) {
		while(nodes.size() >1) {
			HuffmanNode leftNode = nodes.get(0);
			HuffmanNode rightNode = nodes.get(1);
			HuffmanNode parent = new HuffmanNode(leftNode.value +rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
			Collections.sort(nodes);
		}
		System.out.println(nodes.get(0));
	}
	
	public static void preOrder(HuffmanNode root) {
		System.out.println(root);
		if(root.left != null) {
			preOrder(root.left);
		}
		if(root.right != null) {
			preOrder(root.right);
		}
	}
}

//为了使Node对象支持排序
class HuffmanNode implements Comparable<HuffmanNode>{
	int value;
	HuffmanNode left;
	HuffmanNode right;
	HuffmanNode(int num){
		value = num;
	}
	
	@Override
	public String toString() {
		return "HuffmanNode [value=" + value + "]";
	}

	@Override
	public int compareTo(HuffmanNode node) {
		// TODO Auto-generated method stub
		return this.value - node.value;
	}
	
	
	
}
