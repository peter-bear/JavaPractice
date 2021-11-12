package DataStructure;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SparsArrayStudy {
	public static void main(String[] args) {
		System.out.printf("\t原数组\n");
		int[][] array = new int[5][5];
		array[0][1] = 1;
		array[0][3] = 2;
		array[1][0] = 1;
		print(array);
		
		System.out.printf("\t压缩后的数组\n");
		int[][] SparseArray = compress(array);
		print(SparseArray);
		
		System.out.printf("\t原数组恢复\n");
		array = recovery(SparseArray);
		print(array);
		
		
		String source = "E:\\java程序\\hello-world\\src\\DataStructure\\SparseArray.data";
		System.out.println();
		System.out.println("\t将稀疏数组存入硬盘");
		store(SparseArray,source); //指定存储位置
		System.out.println();
		
		System.out.println("\t从硬盘中读取稀疏数组");
		SparseArray = read(source);//指定读取位置
		if(SparseArray!=null) {
			print(SparseArray);
		}
		
		
	}
	
	public static int[][] compress(int[][] array){
		//遍历数组
		int sum =0;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				if(array[i][j]!=0) {
					sum++;
				}
			}
		}
		
		int[][] SparseArray = new int[sum+1][3];
		SparseArray[0][0] = array.length;
		SparseArray[0][1] = array[0].length;
		SparseArray[0][2] = sum;
		int count = 1;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				if(array[i][j]!=0) {
					SparseArray[count][0] = i;
					SparseArray[count][1] = j;
					SparseArray[count][2] = array[i][j];
					count++;
				}
			}
		}
		return SparseArray;
		
	}
	
	public static void print(int[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				System.out.printf("%d\t",array[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] recovery(int[][] SparseArray) {
		//创建原来的数组
		int[][] array = new int[SparseArray[0][0]][SparseArray[0][1]];
		//遍历压缩后的数组
		for(int i=1;i<SparseArray.length;i++) {
			array[SparseArray[i][0]][SparseArray[i][1]] = SparseArray[i][2];
		}
		return array;
	}
	
	public static void store(int[][] SparseArray,String source){
		
		FileOutputStream file;
		try {
			file = new FileOutputStream(source,false);
			BufferedOutputStream buf = new BufferedOutputStream(file);
			for(int i=0;i<SparseArray.length;i++) {
				for(int j=0;j<SparseArray[0].length;j++) {
					buf.write(Integer.valueOf(SparseArray[i][j]).byteValue());
					buf.flush();
				}
			}
			buf.close();
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\t写入成功");
	}
	
	public static int[][] read(String source) {
		
		FileInputStream file;
		int[][] SparseArray = null;
		try {
			file = new FileInputStream(source);
			BufferedInputStream buf = new BufferedInputStream(file);
			int row = buf.read();
			int column = buf.read();
			int sum = buf.read();
			SparseArray = new int[sum+1][3];
			SparseArray[0][0] = row;
			SparseArray[0][1] = column;
			SparseArray[0][2] = sum;
			
			for(int i=1;i<SparseArray.length;i++) {
				SparseArray[i][0]=buf.read();
				SparseArray[i][1]=buf.read();
				SparseArray[i][2]=buf.read();
			}
			buf.close();
		}catch(Exception e) {
			System.out.println("未找到文件");
		}
		return SparseArray;
	}
}

