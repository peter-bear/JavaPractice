package BubbleSorting;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;


public class BubbleDrawing extends JFrame{
	private MyPanel panel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BubbleDrawing();
	}
	
	
	BubbleDrawing(){
		int[] arr = {3,2,6,4,5};
		panel = new MyPanel();
		panel.InitData(arr);
		this.add(panel);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		this.setVisible(true);
		
		
	}

}

class MyPanel extends Panel{
	private int[] arr;
	private int[] originArr;
	private JButton start;
	private JButton reset;
	
	public int[] getArr() {
		return arr;
	}


	public void InitData(int[] arr) {
		this.arr = arr;
		this.originArr = Arrays.copyOf(arr, arr.length);
		
		start = new JButton();
		
		start.setText("开始");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				StartToSort();
			}
		});
		start.setVisible(true);
		
		
		reset = new JButton();
		reset.setText("重置");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ReSetArr();
			}
		});
		
		this.add(start);
		this.add(reset);
	}
	
	//重置
	private void ReSetArr() {
		// TODO Auto-generated method stub
		arr = Arrays.copyOf(originArr, originArr.length);
		this.repaint();
	}

	//开始排序
	private void StartToSort() {
		// TODO Auto-generated method stub
		BubbleAlgorithm sort = new BubbleAlgorithm(arr, this);
		sort.start();
				

	}

	//绘制图像
	private void InitRects(Graphics g) {
		int x=100;
		int y=500;
		int preY =0;
		for(int i:arr) {
			y -= i*50 - preY;
			g.drawRect(x, y, 20, i*50);
			x+=20;
			preY = i*50;
		}
		
		
		
	}


	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		InitRects(arg0);		
	}
	
}
