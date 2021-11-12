package setStudy;

public class Students implements Comparable<Object>{
	private int age;
	private String name;
	public Students(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "Student [ name: "+this.getName()+", age: "+this.getAge()+"  ]";
	}
	
//	
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) {
//			return true;
//		}
//		if(obj == null) {
//			return false;
//		}
//		if(obj instanceof Students) {
//			Students students = (Students) obj;
//			if(this.name.equals(students.name)&&this.age == students.age) {
//				return true;
//			}
//		}
//		return false;
//	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		//第一种转换string的方法
//		String age = String.valueOf(this.age);
		//第二种
//		String age = this.age+"";
		String age = Integer.toString(this.age);
		return age.hashCode()*this.name.hashCode();
	}
	@Override
	public int compareTo(Object obj) {
		Students stu = (Students) obj;
		return (stu.name.hashCode() - this.name.hashCode());
	}
	

}
