package StudyFundation;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawPicture extends JFrame{
	
	private MyPanel panel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawPicture pci = new DrawPicture();
//		System.out.println("hello");
	}
	
	DrawPicture(){
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
		Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/person.jpg"));
		
		g.drawImage(image, 10, 10, 500, 371, this);
		
		//������������ɫ
		g.setColor(Color.BLACK);
		//��������
		//���壬������壬�����С
		g.setFont(new Font("����", Font.BOLD, 50));
		//������, ���������½�����
		g.drawString("������", 50, 450);
		
		
		
	}
	
	@Override
	public void update(Graphics arg0) {
		paint(arg0);
	}
	
}
