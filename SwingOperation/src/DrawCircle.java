

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawCircle extends JFrame{
	
	private MyPanel panel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawCircle circle = new DrawCircle();
//		System.out.println("hello");
	}
	
	DrawCircle(){
		panel = new MyPanel();
		this.add(panel);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanel extends Panel{

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
//		g.drawOval(10, 10, 100, 100);
		Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("E:\\java³ÌÐò\\SwingOperation\\src\\person.jpg"));
		g.drawImage(image, 10, 10, 500, 371, this);
	}
	
}
