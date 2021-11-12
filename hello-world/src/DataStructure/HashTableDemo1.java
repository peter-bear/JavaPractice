package DataStructure;

import java.util.Scanner;

public class HashTableDemo1 {
	public static void main(String[] args) {
		HashTable table = new HashTable(5);
		Scanner scanner = new Scanner(System.in);
		String input="";
		while(input !="exit") {
			System.out.println("Add ����û�");
			System.out.println("Print ��ӡ�û�");
			System.out.println("Delete ɾ���û�");
			System.out.println("Exit �˳�");
			input = scanner.next();
			switch (input) {
			case "Add":
				System.out.print("�û�ID��");
				int id = scanner.nextInt();
				System.out.print("�û�������");
				String name = scanner.next();
				table.add(new NameNode(id, name));
				System.out.println();
				break;
			case "Print":
				System.out.println("�б�����");
				table.print();
				System.out.println();
				break;
			case "Delete":
				System.out.print("ɾ���û���ID�� ");
				int num = scanner.nextInt();
				table.delete(new NameNode(num, ""));
				System.out.println();
				break;
			case "Exit":
				scanner.close();
				System.exit(1);
				break;
			default:
				break;
			}
			
		}
//		List container = new List();
//		container.add(new NameNode(1,"Tom"));
//		container.add(new NameNode(3,"Jim"));
//		container.add(new NameNode(7,"Jerry"));
//		container.print();
//		container.delete(new NameNode(1,"Tom"));
//		container.print();
	}
}


class HashTable{
	private int size;
	List[] table;
	HashTable(int size){
		this.size =size;
		table  = new List[size];
		for(int i=0;i< size;i++) {
			table[i] = new List();
		}
	}
	
	public void add(NameNode sb) {
		int no = fintable(sb.num);
		table[no].add(sb);
	}
	
	public void print() {
		for(int i=0;i<size;i++) {
			System.out.print("��"+(i+1)+"�У� ");
			table[i].print();
		}
	}
	
	public void delete(NameNode node) {
		int no = fintable(node.num);
		table[no].delete(node);
	}
	
	public int fintable(int num) {
		return num % size;
	}
	
	
}

class NameNode{
	int num;
	String name;
	NameNode next;
	NameNode(int num, String name){
		this.num = num;
		this.name = name;
		next = null;
	}
	
	@Override
	public String toString() {
		return "[ ID: "+num+", Name: "+name+" ]";
	}
	
	
}

class List{
	NameNode head;
	List(){
		head = null;
	}
	
	public boolean isempty() {
		return head == null;
	}
	
	public void add(NameNode node) {
		if(isempty()) {
			head = node;
			return;
		}
		if(isExist(node)) {
			System.out.println("ID�Ѵ��ڣ�����������");
			return;
		}
		NameNode cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		
		cur.next = node;
	}
	
	public boolean isExist(NameNode node) {
		NameNode cur = head;
		while(cur != null) {
			if(node.num == cur.num) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	public void delete(NameNode node) {
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		

		NameNode cur = head;
		if(cur.num == node.num) {
			head = cur.next;
			System.out.println("ɾ�����");
			return;
		}
		do {
			NameNode pre =cur;
			cur =cur.next;
			if(cur.num == node.num) {
				pre.next = cur.next;
				System.out.println("ɾ�����");
				return;
			}
		}while(cur != null);
		System.out.println("û�����Ԫ��ID");
	}
	
	
	public void print() {
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		
		NameNode cur = head;
		while(cur != null){
			System.out.print(cur+" ~");
			cur = cur.next;
		}
		System.out.println();
	}
	
	
	
}
