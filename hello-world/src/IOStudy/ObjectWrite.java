package IOStudy;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectWrite {
	public static void main(String[] args) throws Exception{
		String source = "E:\\java³ÌÐò\\ObjWriter.bin";
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(source));
		Student Biden = new Student("Biden", 78);
		Student Trump = new Student("Trump", 72);
		obj.writeObject(Trump);
		obj.writeObject(Biden);
		obj.writeObject(null);
//		ArrayList<Student> stu = new ArrayList<>();
//		stu.add(Biden);
//		stu.add(Trump);
//		obj.writeObject(stu);
		obj.close();
		System.out.println("Finish");
	}
}
