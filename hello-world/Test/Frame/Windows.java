package Frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Windows {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello World");
		frame.setSize(500, 500);
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		JPanel Pane = new JPanel();
		Pane.setSize(100, 100);
		Pane.setBackground(Color.YELLOW);
		Pane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		JButton btn1, btn2, btn3;
		btn1 =new JButton("Open");
		btn2 = new JButton("Close");
		btn3 = new JButton("Back");
		
		Pane.add(btn1);
		Pane.add(btn2);
		Pane.add(btn3);
		
		frame.add(Pane);
		frame.setVisible(true);
		BufferedReader intemp = new BufferedReader(new InputStreamReader(System.in));
		try {
			intemp.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
}
