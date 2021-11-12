package StudyFundation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TankUtil extends JFrame{
	public void ShowMessage(String message) {
		BoardPanel panel = new BoardPanel(message);
	
		this.add(panel);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class BoardPanel extends Panel{
	private String message;
	BoardPanel(String message){
		this.message = message;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paint(g);
		Image image = null;
		if(message.equals("Game Over")) {
			image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/person.jpg"));
		}else {
			image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/kiss.gif"));
		}
		
		
		g.drawImage(image, 10, 10, 500, 371, this);
		
		//������������ɫ
		g.setColor(Color.BLACK);
		//��������
		//���壬������壬�����С
		g.setFont(new Font("����", Font.BOLD, 50));
		//������, ���������½�����
		g.drawString(message, 100, 450);
		
		
	}
	
}

