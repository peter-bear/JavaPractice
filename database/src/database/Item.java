package database;
public class Item {
	private String name;
	private int time;
	private String commend; 
	public Item() {
		
	}
	public Item(String name,int time, String commend){
		super();
		this.name =name;
		this.time = time;
		this.commend = commend;
	}	
	public void print() {
		System.out.printf(name+" "+time+" "+commend);
	}
}

class CD extends Item{
//	private String name;
//	private int time;
//	private String commend;
	public CD(String name,int time, String commend){
		super(name,time,commend);
//		this.name =name;
//		this.time = time;
//		this.commend = commend;
	}
	public void print() {
		System.out.print("CD: ");
		super.print();
	}
	
}
class DVD extends Item{
//	private String name;
//	private int time;
//	private String commend;
	public DVD(String name,int time, String commend){
		super(name,time,commend);
//		this.name =name;
//		this.time = time;
//		this.commend = commend;
	}
	public void print() {
		System.out.print("DVD: ");
		super.print();
	}
}