package HuffmanCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class HuffmanCodingDemo1 {

	public static void main(String[] args) {
		String msg ="hello world my friend, this is peterbear";
		
		byte[] arr = msg.getBytes();
		HashMap<Byte, Integer> map = Count(arr);
		Node root = HuffmanTree(map);
		StringBuffer buf=new StringBuffer();
		HashMap<Byte, String> Dic = new HashMap<>();
		
		System.out.println("Huffman Code");;
		byte[] code = Zip(msg);
		System.out.println(Arrays.toString(code));
		
		Decode(Unzip(code),password(root, buf,Dic));
	}
	
	
	
	
	//�շ�������
	public static byte[] Zip(String msg) {
		byte[] arr = msg.getBytes();
		HashMap<Byte, Integer> map = Count(arr);
		Node root = HuffmanTree(map);
		StringBuffer buf=new StringBuffer();
		HashMap<Byte, String> Dic = new HashMap<>();
		password(root, buf,Dic);
//		for(Byte i:Dic.keySet()) {
//			System.out.println((char)(byte)i+":"+Dic.get(i));
//		}
		
		return UpdateCode(arr,Dic);
	}
	
	//ͳ��ÿ����ĸ���ֵĴ���
	private static HashMap<Byte, Integer> Count(byte[] arr) {
		HashMap<Byte, Integer> map = new HashMap<>();
		for(byte i:arr) {
			Byte data = new Byte(i);
			if(!map.containsKey(data)) {
				map.put(data, 1);
			}
			else {
				map.replace(data, map.get(data), map.get(data)+1);
			}
		}
		return map;
	}
	
	//�����շ����������ظ��ڵ�
	private static Node HuffmanTree(HashMap<Byte, Integer> map) {
		ArrayList<Node> nodes = new ArrayList<>();
		for(Byte i:map.keySet()) {
			nodes.add(new Node(i, map.get(i)));
		}
		Collections.sort(nodes);
		while(nodes.size() > 1) {
			Node leftNode = nodes.get(0);
			Node rightNode =nodes.get(1);
			Node parentNode = new Node(null, leftNode.weight+rightNode.weight);
			parentNode.left = leftNode;
			parentNode.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
			Collections.sort(nodes);
		}
		return nodes.get(0);
	}
	
	//�ó����룬�շ�����
	private static HashMap<Byte, String> password(Node root,StringBuffer buf,HashMap<Byte, String> map) {
		if(root.left != null) {
			buf.append(0);
			password(root.left, buf, map);
		}
		if(root.left == null && root.right == null) {
			map.put(root.data, buf.toString());
			buf.deleteCharAt(buf.length()-1);
			return null;
		}
		
		if(root.right != null) {
			buf.append(1);
			password(root.right, buf, map);
		}
//		if(buf.length()>0)
		try {
			buf.deleteCharAt(buf.length()-1);
		}catch(Exception e) {
			
		}
		
		
		return map;
	}
	
	//����ת���ɺշ��������ʽ
	private static byte[] UpdateCode(byte[] arr, HashMap<Byte, String> dic) {
		StringBuilder meg =new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			 meg.append(dic.get(arr[i]));
		}
//		System.out.println(meg);
		//ת��byte����
		//1 byte ����8 bits, 0001001��bits,Ҫת��byte 
		int len;
		if(meg.length()%8==0) {
			len = meg.length()/8;
		}else {
			len = meg.length()/8+1;
		}
		byte[] codes =new byte[len];
		//�ѸղŴ�õ��ַ�����8λ8λ��ȡ����ӽ�byte������
		int count=0;
		for(int j=0;j<meg.length();j+=8){
			String temp;
			if(j+8 > meg.length()) {
				temp = meg.substring(j);
			}
			else
				temp = meg.substring(j, j+8);
			
			//����Ӧ���ַ���,תΪ2���Ʊ��룬�ٽ���Ӧ��2���Ʊ���תΪbyte����
			codes[count] = (byte)Integer.parseInt(temp, 2);
			
			count++;
		}
		return codes;
	}
	
	public static void Decode(String msg, HashMap<Byte, String> dic) {
		//�����ѯ����
		HashMap<String, Byte> map = new HashMap<>();
//		System.out.println(msg);
		System.out.println("Huffman decode");
		for(Byte word:dic.keySet()) {
			map.put(dic.get(word), word);
		}
		
		int count =1;
		String value;
		
		for(int i=0;i<msg.length();i+= value.length()) {
			while(true) {
				value = msg.substring(i, i+count);
				if(map.containsKey(value)) {
					System.out.print((char)(byte)map.get(value));
					count =1;
					break;
				}
				count ++;
			}
		}
		
	}
	
	//��byte����תΪ����������
	private static String Unzip(byte[] msg) {
		StringBuilder container = new StringBuilder();
		for(int i=0;i<msg.length;i++) {
			
			int value =new Byte(msg[i]);
			String temp =Integer.toBinaryString(value);
			//�ж����һλ�Ƿ�Ϊ8bit���ȣ�������ǣ�ֱ�Ӽӽ�ȥ
			if(i==msg.length-1 && temp.length()<24) {
				container.append(temp);
			}
			else {
				if(temp.length()>24)
					container.append(temp.substring(24));
				else {
					for(int j=0;j<(8-temp.length());j++) {
						container.append("0");
					}
					container.append(temp);
				}
			}
//			System.out.println(temp);
			
				
			
		}
		return container.toString();
	}
	
	
	//ǰ�����
	public static void preOrder(Node root) {
		System.out.println(root);
		if(root.left != null) {
			preOrder(root.left);
		}
		if(root.right != null) {
			preOrder(root.right);
		}
	}
	
	//�������
	public static void infixOrder(Node root) {
		
		if(root.left != null) {
			infixOrder(root.left);
		}
		System.out.println(root);
		if(root.right != null) {
			infixOrder(root.right);
		}
	}

}


//Node�ڵ㣬����������Ȩֵ
class Node implements Comparable<Node>{
	Byte data;
	int weight;
	Node left;
	Node right;
	Node(Byte data, int value){
		this.data =  data;
		weight = value;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}
