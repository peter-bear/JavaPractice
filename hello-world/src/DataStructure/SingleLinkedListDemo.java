package DataStructure;

import java.util.Stack;

/**
 * @author 23881
 * 链表的增删改查
 * 合并链表
 * 逆序打印
 *反转链表
 *打印倒是第n个元素
 */
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
//		list.add(new HeroNode(1,"peter","peterbear"));
//		list.add(new HeroNode(3,"tony","hairCutter"));
		System.out.println("\t增添元素");
		list.AddByOrder(new HeroNode(1,"peter","peterbear"));
		list.AddByOrder(new HeroNode(3,"tony","hairCutter"));
		list.AddByOrder(new HeroNode(2,"jerry","printf"));
		list.AddByOrder(new HeroNode(5,"jim","java"));
		list.AddByOrder(new HeroNode(6,"trump","python"));
		list.AddByOrder(new HeroNode(2,"jerry","printf"));
		list.print();
		System.out.println("\t查找元素");
		list.Search(0);
		System.out.println("\t更改元素");
		list.Update(new HeroNode(2,"zhang","专业户"));
		list.print();
		System.out.println("\t删除元素");
		list.Delete(2);
		list.print();
		System.out.println("\t此链表中节点的个数："+list.size());
		System.out.println("\t倒数第n个元素\n"+list.NodeFromLast(3));
		System.out.println("\t反转后的链表");
		list.ReserveNode();
		list.print();
		System.out.println("\t逆序打印");
		list.RevPrint();
		list.ReserveNode();
		System.out.println("\t合并链表");
		System.out.println("链表1：");
		list.print();
		System.out.println("链表2：");
		SingleLinkedList list2 = new SingleLinkedList();
		list2.AddByOrder(new HeroNode(5,"Biden","瞌睡虫"));
		list2.AddByOrder(new HeroNode(8,"John","somebody"));
		list2.print();
		System.out.println("合并后：");
		list.Combine(list2);
		list.print();
		
	}
	
	
}
 
class HeroNode{
	public int No;
	public String Name;
	public String NickName;
	public HeroNode next; //指向下一个节点
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
	//先初始化一个头节点
	public HeroNode Head = new HeroNode(0,"","");
	
	//添加节点
	//找到当前列表的最后一个节点，将最后一个节点的next指向下一个
	public void add(HeroNode node) {
		//head节点不能动，用一个指针指向head
		HeroNode cur = Head;
		//遍历链表
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
	}
	
	//按照heronode的编号来存储数据，判断数据是否存在与存储数据
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
				System.out.printf("%s的编号%d 已存在，无法添加\n",node.Name,node.No);
				break;
			}
			cur = cur.next;
			if(cur.next == null) {
				add(node);
				break;
			}
		}
		
	}
	
	//对链表中数据进行反转 
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
		//第二种
//		HeroNode next =null;
//		while(cur!=null) {
//			next = cur.next;
//			cur.next = temp.next;
//			temp.next = cur;
//			cur = next;
//		}
//		Head = temp;
	}
	
	//删除信息
	public void Delete(int No) {
		if(isempty()) {
			System.out.println("此链表为空链表，无法删除任何元素");
			return;
		}
		if(No == 0) {
			System.out.println("无法删除头节点");
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
		System.out.println("未找到匹配的信息");
	}
	
	
	//改变信息
	public void Update(HeroNode NewNode) {
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		if(NewNode.No == 0) {
			System.out.println("无法改变头节点的值");
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
	
	//查找信息
	public void Search(int No) {
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		if(No == 0) {
			System.out.println("此节点为头节点");
			return;
		}
		HeroNode cur = Head;
		while(cur!=null) {
			if(cur.No == No) {
				System.out.println("编号 "+No+":"+cur);
				return;
			}
			cur = cur.next;
		}
		System.out.println("未找到匹配信息");
	}
	
	//查找单链表倒数第k个结点
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
	//判空
	public boolean isempty() {
		return Head.next == null;
	}
	
	//遍历打印链表
	public void print() {
		if(isempty()) {
			System.out.println("链表为空");
			return;
		}
		HeroNode cur = Head.next;
		while (cur != null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}
	
	//从尾到头打印链表
	//1.将单链表反转，然后遍历（会破坏原来的结构）
	//2.利用栈，将各个节点压入到栈中，先进后出的特点，实现逆序打印的效果
	public void RevPrint() {
		if(isempty()) {
			System.out.println("此链表为空");
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
	
	//获取链表节点个数
	public int size() {
		int count =0;
		HeroNode cur = Head;
		while(cur.next != null) {
			cur=cur.next;
			count++;
		}
		return count;
	}
	
	//合并链表
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
