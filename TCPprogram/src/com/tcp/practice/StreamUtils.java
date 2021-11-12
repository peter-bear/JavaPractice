package com.tcp.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;

public class StreamUtils {
	public static void Write(Socket socket, String words) throws IOException {
		OutputStream output = socket.getOutputStream();
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(output));
		bfw.write(words);
		bfw.newLine();
		bfw.flush();
		socket.shutdownOutput();
	}
	
	public static String Read(Socket socket) throws IOException {
		String words;
		InputStream input = socket.getInputStream();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
		words = bfr.readLine();
		return words;
	}
	
	public static boolean SendFile(Socket socket, String path){
		try {
			FileInputStream file = new FileInputStream(path);
			OutputStream output =  socket.getOutputStream();
			byte[] buf = new byte[1024];
			int len;
			while((len =file.read(buf))!=-1)
				output.write(Arrays.copyOf(buf, len));

			socket.shutdownOutput();
			
			file.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	public static boolean ReceiveFile(Socket socket, String path) {
		try {
			InputStream input = socket.getInputStream();
			FileOutputStream file = new FileOutputStream(path);
			byte[] buf = new byte[1024];
			int len;
			while((len =input.read(buf))!=-1)
				file.write(Arrays.copyOf(buf, len));
			
			file.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public static void closeAll(InputStream input, OutputStream  output,
			FileInputStream inputfile,FileOutputStream outputfile,
			BufferedWriter bfw, BufferedReader bfr) throws IOException {
		if(input!=null)
			input.close();
		if(output!=null)
			output.close();
		if(inputfile != null)
			inputfile.close();
		if(outputfile!=null)
			outputfile.close();
		if(bfw!=null)
			bfw.close();
		if(bfr!=null)
			bfr.close();
	}
	
	
}
