package algorithm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class DrawMaze extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new DrawMaze().setVisible(true);
	}
	
	
	public DrawMaze() {
        
        this.setTitle("Maze");
        this.setSize(700, 750);
        
    	MyPanel panel = new MyPanel();
    	JButton button = new JButton();
		panel.init(PrimMazeCreating.Prim(31, 31, 1, 1), button);
		this.add(panel);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
	
	private static class MyPanel extends Panel{
		private int[][] map;
		private int[][] resetMap;
		private JButton DFS;
		private JButton Astar;
		private JButton reset;
		private MazePath m1;
		private MazePath2 m2;
		
		
		public void init(int[][] map, JButton button) {
			this.map =map;
			resetMap = new int[map.length][map[0].length];
			
			for(int i=0;i<map.length;i++){
				for(int j=0;j<map[0].length;j++) {
					resetMap[i][j] = map[i][j];
				}
			}
			DFS =  new JButton();
			
			DFS.setText("DFS");
			DFS.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					DFSMaze();
				}
			});
			DFS.setVisible(true);
			
			
			Astar =  new JButton();
			
			Astar.setText("Astar");
			Astar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					AstarMaze();
				}
			});
			Astar.setVisible(true);
			
			reset =  new JButton();
			reset.setText("ÖØÖÃ");
			reset.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					ResetMaze();
				}
			});
			reset.setVisible(true);
			
			this.add(DFS);
			this.add(Astar);
			this.add(reset);
			
		}
		
		
	    private void AstarMaze() {
			// TODO Auto-generated method stub
	    	m2 = new MazePath2(map, 1,1,map.length-2, map[0].length-2, this);
	    	m2.start();
		}


		private void ResetMaze() {
			// TODO Auto-generated method stub
//			m1.stop();
//			m2.stop();
	    	for(int i=0;i<map.length;i++){
				for(int j=0;j<map[0].length;j++) {
					 map[i][j] = resetMap[i][j];
				}
			}
	    	this.repaint();
		}


		private void DFSMaze() {
			// TODO Auto-generated method stub
	    	m1 = new MazePath(map, 1,1,map.length-2, map[0].length-2, this);
	    	m1.start();
		}


		@Override
	    public void paint(Graphics g) {
	        super.paint(g);
	         
	        Rectangle rect = new Rectangle(0, 0, 700, 700);

	        
//	        int[][] map = PrimMazeCreating.Prim(31,31,1,1);


	        
	       int blockWidth = rect.width / map[0].length;
	       int blockHeight = rect.height / map.length;
	        
	        for (int i = 0; i < map.length; i++) {
	            for (int j = 0; j < map[0].length; j++) {
	            	
	            	
	            	
	            	if(map[i][j] == 0) {
	            		g.setColor(Color.BLACK);
	            	}else if(map[i][j]==1) {
	            		g.setColor(Color.RED);
	            	}else if(map[i][j]==2) {
	            		g.setColor(Color.ORANGE);
	            	}else if(map[i][j]==3) {
	            		g.setColor(Color.BLUE);
	            	}
	            	
	            	if((i== 1 && j ==1) || (i == map.length-2 && j == map[0].length-2)) {
	            		g.setColor(Color.CYAN);
	            	}
	            		
	                
	                
	                 
	                g.fillRect(rect.x + j * blockWidth, rect.y + i * blockHeight, blockWidth, blockHeight);
	            }
	        }
	    }


		@Override
		public void update(Graphics arg0) {
//			// TODO Auto-generated method stub
//			super.update(arg0);
			paint(arg0);
		}
		
		
	}
     

}


