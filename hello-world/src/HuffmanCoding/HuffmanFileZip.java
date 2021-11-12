package HuffmanCoding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class HuffmanFileZip {

	public static void main(String[] args) {
		String input ="C:\\Users\\23881\\Desktop\\Self_study\\Java����\\HuffmanCoding\\music.mp3";
		String output ="C:\\Users\\23881\\Desktop\\Self_study\\Java����\\HuffmanCoding\\ѹ��\\store.zip";
		Zip(input, output);
		input = output;
		output = "C:\\Users\\23881\\Desktop\\Self_study\\Java����\\HuffmanCoding\\��ѹ\\music.mp3";
		UnZipFile(input, output);
		
	}
	
	
	
	
	//�շ�������
	public static void Zip(String input, String output) {
		FileInputStream file=null;
		ObjectOutputStream oop=null;
		FileOutputStream out=null;
		byte[] arr;
		try {
		    file= new FileInputStream(input);
			arr = new byte[file.available()];
			file.read(arr);
			
			HashMap<Byte, Integer> map = Count(arr);
			Node root = HuffmanTree(map);
			StringBuffer buf=new StringBuffer();
			//����ʹ���Dic�ֵ���
			HashMap<Byte, String> Dic = new HashMap<>();
			
			password(root, buf,Dic);
			byte[] rst = UpdateCode(arr,Dic);
			//�����
			out = new FileOutputStream(output);
			//�����������������,���ڻָ�����
			oop = new ObjectOutputStream(out);
			//�ѱ���������д��ѹ���ļ�
			oop.writeObject(rst);
			
			//ͬʱ���ǻ�Ҫ�Ѻշ�������Ҳд���ļ���
			oop.writeObject(Dic);
			System.out.println("ѹ�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��·��Ϊ��");
		}finally{
			try {
				file.close();
				out.close();
				oop.close();
			} 
			catch (IOException e) {
				
			}
		}
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
	
	
	public static void UnZipFile(String input, String output) {
		System.out.println(input);
		
		FileInputStream file=null;
		FileOutputStream Outfile =null;
		ObjectInputStream ZipFile=null;
		try {
			file = new FileInputStream(input);
			Outfile =new FileOutputStream(output);
			ZipFile = new ObjectInputStream(file);
			byte[] huffmanBytes = (byte[])ZipFile.readObject();
			HashMap<Byte, String> dic = (HashMap<Byte, String>)ZipFile.readObject();
			Outfile.write(Decode(Change(huffmanBytes),dic));
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				ZipFile.close();
				Outfile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private static byte[] Decode(String msg, HashMap<Byte, String> dic) {
		//�����ѯ����
		HashMap<String, Byte> map = new HashMap<>();
		ArrayList<Byte> list = new ArrayList<>();
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
					list.add(map.get(value));
					count =1;
					break;
				}
				count ++;
			}
		}
		
		byte[] arr = new byte[list.size()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = list.get(i);
		}
		return arr;
		
	}

	//��byte����תΪ����������
	private static String Change(byte[] msg) {
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
	
			
		}
		return container.toString();
	}
	

}

