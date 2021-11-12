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
		
		//给画笔设置颜色
		g.setColor(Color.BLACK);
		//设置字体
		//字体，字体粗体，字体大小
		g.setFont(new Font("宋体", Font.BOLD, 50));
		//画出字, 坐标是左下角坐标
		g.drawString(message, 100, 450);
		
		
	}
	
}

