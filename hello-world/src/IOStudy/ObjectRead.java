package IOStudy;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectRead {
	public static void main(String[] args) throws Exception{
		String source ="E:\\java³ÌÐò\\ObjWriter.bin";
		ObjectInputStream obj = new ObjectInputStream(new FileInputStream(source));
//		@SuppressWarnings("unchecked")
//		ArrayList<Student> stu = (ArrayList<Student>) obj.readObject();
//		System.out.println(stu.toString());
		Object stu;
		while((stu=obj.readObject())!= null) {
			System.out.println(stu);
		}
		obj.close();
	}
}
