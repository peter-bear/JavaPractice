package IOStudy;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class FileOperator {
	public static void main(String[] args) throws Exception {
		File file = new File("E:\\java³ÌÐò\\PicSource");
		System.out.println("dictory's name: "+file.getName());
//		System.out.println(file.createNewFile());
//		System.out.println(file.getParent());
		File[] files = file.listFiles();
		Integer count =0;
		for(File pic:files) {
			File image = new File(file.getAbsolutePath(),count.toString()+".jpg");
			if(pic.isFile()) {
				pic.renameTo(image);
				count++;
			}
		}
		File[] file2 = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if(pathname.getName().endsWith(".jpg"))
					return true;
				return false;
			}
			
		});
		for(File pic:file2) {
			
			System.out.println(pic.getName());
		}
//		File file = new File("E:\\java³ÌÐò\\PicSource","Summer_Pocket");
//		System.out.println("File Exists: "+file.exists());
//		System.out.println(file.isDirectory());
//		System.out.println(file.length());
//		System.out.println("create this directory: "+file.mkdirs());
//		Scanner in = new Scanner(System.in);
//		System.out.print("Do you want to delete this directory? (y/n)");
//		String choice = in.next();
//		if(choice.equals("y")) {
//			System.out.println("File Delete: "+file.delete());
//		}
//		in.close();
		
		
	}
}
