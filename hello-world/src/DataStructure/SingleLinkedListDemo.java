package DataStructure;

import java.util.Stack;

/**
 * @author 23881
 * �������ɾ�Ĳ�
 * �ϲ�����
 * �����ӡ
 *��ת����
 *��ӡ���ǵ�n��Ԫ��
 */
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
//		list.add(new HeroNode(1,"peter","peterbear"));
//		list.add(new HeroNode(3,"tony","hairCutter"));
		System.out.println("\t����Ԫ��");
		list.AddByOrder(new HeroNode(1,"peter","peterbear"));
		list.AddByOrder(new HeroNode(3,"tony","hairCutter"));
		list.AddByOrder(new HeroNode(2,"jerry","printf"));
		list.AddByOrder(new HeroNode(5,"jim","java"));
		list.AddByOrder(new HeroNode(6,"trump","python"));
		list.AddByOrder(new HeroNode(2,"jerry","printf"));
		list.print();
		System.out.println("\t����Ԫ��");
		list.Search(0);
		System.out.println("\t����Ԫ��");
		list.Update(new HeroNode(2,"zhang","רҵ��"));
		list.print();
		System.out.println("\tɾ��Ԫ��");
		list.Delete(2);
		list.print();
		System.out.println("\t�������нڵ�ĸ�����"+list.size());
		System.out.println("\t������n��Ԫ��\n"+list.NodeFromLast(3));
		System.out.println("\t��ת�������");
		list.ReserveNode();
		list.print();
		System.out.println("\t�����ӡ");
		list.RevPrint();
		list.ReserveNode();
		System.out.println("\t�ϲ�����");
		System.out.println("����1��");
		list.print();
		System.out.println("����2��");
		SingleLinkedList list2 = new SingleLinkedList();
		list2.AddByOrder(new HeroNode(5,"Biden","�˯��"));
		list2.AddByOrder(new HeroNode(8,"John","somebody"));
		list2.print();
		System.out.println("�ϲ���");
		list.Combine(list2);
		list.print();
		
	}
	
	
}
 
class HeroNode{
	public int No;
	public String Name;
	public String NickName;
	public HeroNode next; //ָ����һ���ڵ�
	public HeroNode(int No, String Name, String NickName) {
		this.No = No;
		this.Name = Name;
		this.NickName = NickName;
	}
	@Override
	public String toString() {
		return "Node[ No: "+this.No+"; Name: "+this.Name+"; NickName: "+this.NickName+" ]";
	}
	@Override
	public boolean equals(Object obj) {
		HeroNode node = (HeroNode)obj;
		return node.No == this.No && node.Name.equals(node.Name) && node.NickName.equals(node.NickName);
	}
	
	
}


class SingleLinkedList{
	//�ȳ�ʼ��һ��ͷ�ڵ�
	public HeroNode Head = new HeroNode(0,"","");
	
	//��ӽڵ�
	//�ҵ���ǰ�б�����һ���ڵ㣬�����һ���ڵ��nextָ����һ��
	public void add(HeroNode node) {
		//head�ڵ㲻�ܶ�����һ��ָ��ָ��head
		HeroNode cur = Head;
		//��������
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
	}
	
	//����heronode�ı�����洢���ݣ��ж������Ƿ������洢����
	public void AddByOrder(HeroNode node) {
		HeroNode cur = Head;
		if(isempty()) {
			add(node);
			return;
		}
		while(cur.next != null) {
			if(cur.next.No > node.No) {
				node.next = cur.next;
				cur.next = node;
				break;
			}
			else if(cur.next.No == node.No ) {
				System.out.printf("%s�ı��%d �Ѵ��ڣ��޷����\n",node.Name,node.No);
				break;
			}
			cur = cur.next;
			if(cur.next == null) {
				add(node);
				break;
			}
		}
		
	}
	
	//�����������ݽ��з�ת 
	public void ReserveNode() {
		HeroNode cur = Head.next;

		HeroNode temp = new HeroNode(0,"","");
		while(cur!=null) {
			Head.next = cur.next;
			cur.next = temp.next;
			temp.next = cur;
			cur = Head.next;
		}
		Head = temp;
		//�ڶ���
//		HeroNode next =null;
//		while(cur!=null) {
//			next = cur.next;
//			cur.next = temp.next;
//			temp.next = cur;
//			cur = next;
//		}
//		Head = temp;
	}
	
	//ɾ����Ϣ
	public void Delete(int No) {
		if(isempty()) {
			System.out.println("������Ϊ�������޷�ɾ���κ�Ԫ��");
			return;
		}
		if(No == 0) {
			System.out.println("�޷�ɾ��ͷ�ڵ�");
			return;
		}
		HeroNode cur = Head;
		while(cur.next != null) {
			if(cur.next.No == No) {
				cur.next = cur.next.next;
				return;
			}
			cur = cur.next;
		}
		System.out.println("δ�ҵ�ƥ�����Ϣ");
	}
	
	
	//�ı���Ϣ
	public void Update(HeroNode NewNode) {
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		if(NewNode.No == 0) {
			System.out.println("�޷��ı�ͷ�ڵ��ֵ");
			return;
		}
		HeroNode cur = Head;
		while(cur!=null) {
			if(cur.next.No == NewNode.No) {
				NewNode.next = cur.next.next;
				cur.next = NewNode;
				return;
			}
			cur = cur.next;
		}
	}
	
	//������Ϣ
	public void Search(int No) {
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		if(No == 0) {
			System.out.println("�˽ڵ�Ϊͷ�ڵ�");
			return;
		}
		HeroNode cur = Head;
		while(cur!=null) {
			if(cur.No == No) {
				System.out.println("��� "+No+":"+cur);
				return;
			}
			cur = cur.next;
		}
		System.out.println("δ�ҵ�ƥ����Ϣ");
	}
	
	//���ҵ���������k�����
	public HeroNode NodeFromLast(int k) {
		if(k>size()||k<=0) {
			return null;
		}
		HeroNode cur = Head.next;
		for(int i=0;i<(size()-k);i++) {
			cur = cur.next;
		}
		return cur;
	}
	//�п�
	public boolean isempty() {
		return Head.next == null;
	}
	
	//������ӡ����
	public void print() {
		if(isempty()) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode cur = Head.next;
		while (cur != null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}
	
	//��β��ͷ��ӡ����
	//1.��������ת��Ȼ����������ƻ�ԭ���Ľṹ��
	//2.����ջ���������ڵ�ѹ�뵽ջ�У��Ƚ�������ص㣬ʵ�������ӡ��Ч��
	public void RevPrint() {
		if(isempty()) {
			System.out.println("������Ϊ��");
			return;
		}
		Stack<HeroNode> stack = new Stack<>();
		HeroNode cur = Head.next;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
	
	//��ȡ����ڵ����
	public int size() {
		int count =0;
		HeroNode cur = Head;
		while(cur.next != null) {
			cur=cur.next;
			count++;
		}
		return count;
	}
	
	//�ϲ�����
	public void Combine(SingleLinkedList list) {
		HeroNode cur = list.Head.next;
		while(cur!=null) {
			list.Head = cur.next;
			cur.next = null;
			this.AddByOrder(cur);
			cur = list.Head;
		}
	}
}
