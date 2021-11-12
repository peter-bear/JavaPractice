package FinalAll;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;

import BubbleSorting.BubbleAlgorithm;
import InsertSorting.InsertAlgorithm;
import QuickSorting.QuickAlgorithm;
import ShellSorting.ShellAlgorithm;



public class FinalView extends JFrame{
	private MyPanel panel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FinalView();
	}
	
	public FinalView() {
		// TODO Auto-generated constructor stub
		int[] arr = {59,48,75,107,86,23,37,59,65,14, 12, 15, 9,20, 6,31,24};
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
	private JButton select;
	private JButton shell;
	private JButton bubble;
	private JButton quick;
	private JButton reset;
	private JButton insert;
	
	public int[] getArr() {
		return arr;
	}


	public void InitData(int[] arr) {
		this.arr = arr;
		this.originArr = Arrays.copyOf(arr, arr.length);
		
		select = new JButton();
		
		select.setText("Select Sort");
		select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SelectSort();
			}
		});
		select.setVisible(true);
		
		shell = new JButton();
		
		shell.setText("Shell Sort");
		shell.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ShellSort();
			}
		});
		shell.setVisible(true);
		
		insert = new JButton();
		
		insert.setText("Insert Sort");
		insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				InsertSort();
			}
		});
		insert.setVisible(true);
		
		quick = new JButton();
		
		quick.setText("Quick Sort");
		quick.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				QuickSort();
			}
		});
		quick.setVisible(true);
		
		bubble = new JButton();
		
		bubble.setText("Bubble Sort");
		bubble.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BubbleSort();
			}
		});
		bubble.setVisible(true);
		
		reset = new JButton();
		reset.setText("重置");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ReSetArr();
			}
		});
		
		this.add(select);
		this.add(quick);
		this.add(shell);
		this.add(bubble);
		this.add(insert);
		this.add(reset);
	}
	
	private void InsertSort() {
		// TODO Auto-generated method stub
		InsertAlgorithm sort = new InsertAlgorithm(arr, this);
		sort.start();
	}


	private void BubbleSort() {
		// TODO Auto-generated method stub
		BubbleAlgorithm sort = new BubbleAlgorithm(arr, this);
		sort.start();
	}


	private void QuickSort() {
		// TODO Auto-generated method stub
		QuickAlgorithm sort = new QuickAlgorithm(arr, this);
		sort.start();
	}


	private void ShellSort() {
		// TODO Auto-generated method stub
		ShellAlgorithm sort = new ShellAlgorithm(arr, this);
		sort.start();
	}


	//重置
	private void ReSetArr() {
		// TODO Auto-generated method stub
		arr = Arrays.copyOf(originArr, originArr.length);
		this.repaint();
	}

	//开始排序
	private void SelectSort() {
		// TODO Auto-generated method stub
		ShellAlgorithm sort = new ShellAlgorithm(arr, this);
		sort.start();
				

	}

	//绘制图像
	private void InitRects(Graphics g) {
		int x=100;
		int y=500;
		int preY =0;
		for(int i:arr) {
			y -= i*2 - preY;
			g.drawRect(x, y, 20, i*2);
			x+=20;
			preY = i*2;
		}
		
		
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		InitRects(g);
	}
	
}