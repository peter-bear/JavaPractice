package Frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;

import javax.swing.*;
public class MouseControl implements MouseMotionListener, KeyListener{
	private JFrame frame;
	private JLabel tf;
	String words="";
	
	public static void main(String[] args) {

		MouseControl control = new MouseControl();
		control.go();
	}
	
	private void go() {
		frame = new JFrame("Hello World");
		Container contentPane =  frame.getContentPane();
		contentPane.add(new JLabel("get mouse and keyboard event"), BorderLayout.NORTH);
		tf = new JLabel();
		contentPane.add(tf, BorderLayout.SOUTH);
		frame.addMouseMotionListener(this);
		frame.addKeyListener(this);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		//自动关闭
//		Long start = Calendar.getInstance().getTimeInMillis();
//		Long end =(long) 0;
//		while((end-start)<10000) {
//			end = Calendar.getInstance().getTimeInMillis();
//		}
//		System.exit(0);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("1");

		int charcode = e.getKeyCode();

		words = "有键按下1";

		if(charcode == KeyEvent.VK_SHIFT) words = "shift1";

		if(charcode == KeyEvent.VK_CONTROL) words = "control1";
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("3");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("2");

		int charcode = e.getKeyCode();

		words = "有键按下2";

		if(charcode == KeyEvent.VK_SHIFT) {
			words = "shift2";
			}

		if(charcode == KeyEvent.VK_CONTROL) 
			words = "control2";
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		String s = "鼠标拖动的坐标: X =" +e.getX() + " Y =" + e.getY() + " KEY：" + words;

		tf.setText(s);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		String s = "鼠标移动的坐标: X =" +e.getX() + " Y =" + e.getY() + " KEY：" + words;

		tf.setText(s);
	}
}
