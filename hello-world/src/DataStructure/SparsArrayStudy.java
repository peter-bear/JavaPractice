package DataStructure;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SparsArrayStudy {
	public static void main(String[] args) {
		System.out.printf("\tԭ����\n");
		int[][] array = new int[5][5];
		array[0][1] = 1;
		array[0][3] = 2;
		array[1][0] = 1;
		print(array);
		
		System.out.printf("\tѹ���������\n");
		int[][] SparseArray = compress(array);
		print(SparseArray);
		
		System.out.printf("\tԭ����ָ�\n");
		array = recovery(SparseArray);
		print(array);
		
		
		String source = "E:\\java����\\hello-world\\src\\DataStructure\\SparseArray.data";
		System.out.println();
		System.out.println("\t��ϡ���������Ӳ��");
		store(SparseArray,source); //ָ���洢λ��
		System.out.println();
		
		System.out.println("\t��Ӳ���ж�ȡϡ������");
		SparseArray = read(source);//ָ����ȡλ��
		if(SparseArray!=null) {
			print(SparseArray);
		}
		
		
	}
	
	public static int[][] compress(int[][] array){
		//��������
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
		//����ԭ��������
		int[][] array = new int[SparseArray[0][0]][SparseArray[0][1]];
		//����ѹ���������
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
		System.out.println("\tд��ɹ�");
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
			System.out.println("δ�ҵ��ļ�");
		}
		return SparseArray;
	}
}

