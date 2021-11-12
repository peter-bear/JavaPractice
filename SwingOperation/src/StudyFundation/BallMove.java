package StudyFundation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class BallMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BallFrame();
	}
	
	

}
class BallFrame extends JFrame{
	BallFrame(){
		BallPanel bp = new BallPanel();
		this.add(bp);
		this.addKeyListener(bp);
		this.setSize(1000, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class BallPanel extends Panel implements KeyListener{
	private int x=40;
	private int y=40;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, 50, 50);
	}
	
	@Override
	public void update(Graphics arg0) {
		paint(arg0);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_A) {
			x -= 5;
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			x += 5;
		}else if(e.getKeyCode() == KeyEvent.VK_W) {
			y -= 5;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			y += 5;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
