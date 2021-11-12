package mainApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import listeners.KeyboardListener;
import utility.GameUtility;

/**
 * Class GameDiver
 * @author Qingyuan Jiao; Yao Xiong
 * <br>Handles level changes, map & high scores reading, general display
 * <br>For example
 * <pre>
 * 	GameDriver gd = new GameDriver(); 
 * </pre>
 */
public class GameDriver {
	
private JFrame frame;
private JButton start;
private GameComponent game;
private JLabel helpLabel, lifeLabel, scoreLabel, levelLabel;
private int score;
private int currentLevel;
private KeyboardListener ML;

private Timer advTimer;
private Timer keyMovementTimer;

	/**
	 *  ensures: initialize game driver for the game
	 *  set current lever to 1;
	 *  set score to 0
	 */
	public GameDriver() {
		frameCreator();
		currentLevel = 1;
		this.score = 0;
	}


	/**
	 * ensures: the score of the hero is returned
	 * @return the score label
	 */
	public JLabel getScoreLabel() {
		return this.scoreLabel;
	}
	
	/**
	 * ensures: the life of the hero is returned
	 * @return the life label
	 */
	public JLabel getLifeLabel() {
		return this.lifeLabel;
	}
	
	/**
	 * ensures: the gameComponent is returned
	 * @return gameComponent
	 */
	public GameComponent getGameComponent() {
		return this.game;
	}
	
	/**
	 * ensures:get current level
	 * @return current level
	 */
	public int getCurrentLevel() {
		return this.currentLevel;
	}
	
	/**
	 * construct new frame
	 */
	public void frameCreator() {
		this.frame = new JFrame();
		this.frame.setSize(new Dimension(GameUtility.FRAME_LENGTH, GameUtility.FRAME_HEIGHT));
		//this.frame.getContentPane().setBackground(Color.white);
		
		//start.setPreferredSize(new Dimension(200,100));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}

	
	/**
	 * loads the start page which contains high scores and the start button
	 */
	public void showStartPage() {
		//this.frame.setLayout(new BorderLayout());
		start = new JButton("start game");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				configureCurrentLevel();
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel note = new JLabel();
		note.setFont(new Font("Algerian", Font.BOLD, 20));
		note.setText("PAST WINNERS");
		note.setBounds(80, 50, 800, 80);
		panel.add(note);
		
		//print History Winners
		try {
			File reader = new File(GameUtility.winnerFile);
			Scanner scanner = new Scanner(reader);
			int i = 1;
			while(scanner.hasNextLine()) {
				String[] winnerInfor = scanner.nextLine().split(";");
				JLabel winner = new JLabel();
				winner.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
				winner.setText("Date: "+winnerInfor[0]+"    Name: "+winnerInfor[1]+"    Score: "+winnerInfor[2]);
				winner.setVisible(true);
				winner.setBounds(50, 50 + i*30, 800, 80);
				panel.add(winner);
				i++;
			}
			
			scanner.close();
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		start.setBounds(350, 500, 150, 70);
		panel.add(start);
		frame.add(panel);
		frame.setVisible(true);
	}
	

	
	/**
	 * read the current level file
	 */
	public void readCurrentLevel() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("levels/level"+this.currentLevel+".txt"));//load the file 
			//use x and y to represent the position of each component
			int y=0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				int x=0;
				//load components horizontally
				for(int i=0;i<line.length();i++) {
				
					if(line.charAt(i)=='-') {
						game.addPlane(x,y,GameUtility.Default_Plane_Length, GameUtility.Default_Plane_Height, GameUtility.planeFileAddress);
					}else if(line.charAt(i)=='|') {
						game.addPlane(x,y,GameUtility.Default_Plane_Length, GameUtility.Special_Plane_Height, GameUtility.planeFileAddress);
					}
					else if(line.charAt(i)=='H') {
						game.addHero(x,y,GameUtility.Default_Hero_Length, GameUtility.Default_Hero_Height,GameUtility.heroFileAddress);
					}
					else if(line.charAt(i)=='A') {
						game.addAlien1(x, y, GameUtility.Default_Alien_Length, GameUtility.Default_Alien_Height, GameUtility.alien1FileAddress);
					}
					else if(line.charAt(i)=='E') {
						game.addAlien2(x,y, GameUtility.Default_Alien_Length, GameUtility.Default_Alien_Height, GameUtility.alien2FileAddress);
					}else if(line.charAt(i)=='B') {
						game.addBomb(x,y,GameUtility.Default_Bomb_Radius, GameUtility.bombFileAddress);
					}
					x += 20;
					
				}
				
				if(line.charAt(0)=='-')
					y += 20;
				else
					y += 50;
			}
			scanner.close();
			
//			game.addAlienBackUp();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("level file not found");
			e.printStackTrace();
		}
	}
	

	/**
	 * change currentLevel by level, currently it supports only change by 1
	 * @param desired change
	 */
	public void changeLevel(int level) {
		if (level == 1 && currentLevel < 6 || (level == -1 && currentLevel > 1)) {
			this.closeTimer();
			this.currentLevel +=level;
			this.configureCurrentLevel();
		}else if(currentLevel == 6) {
		
			this.closeTimer();
			this.isWin();
			
		}
	}
	
	/**
	 * Show the win Dialog
	 */
	private void isWin() {
		this.frame.setTitle("You Win");
//		JOptionPane pane = new JOptionPane("You Win In This Game!! Do you want to save your name?");
//		pane.setVisible(true);
		int rst = JOptionPane.showConfirmDialog(null, "Do you want to save your name?", "You Win In This Game!!", 2);
		boolean exit = false;
		if(rst==JOptionPane.YES_OPTION) {
			String name = JOptionPane.showInputDialog("Your Name:");
			try {
//				FileOutputStream fileOutput = new FileOutputStream("others\\winers.obj", true);
				FileWriter fileOutput = new FileWriter(GameUtility.winnerFile, true);
				fileOutput.write(java.time.LocalDate.now() + ";" + name + ";" + this.score+"\n");
				fileOutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?","Please Choice", 2);
		if(choice == JOptionPane.CANCEL_OPTION || choice == JOptionPane.CLOSED_OPTION)
			exit = true;
		else {
			this.score = 0;
			this.currentLevel = 1;
			this.configureCurrentLevel();
			
		}
		
		if(exit) {
			JOptionPane.showMessageDialog(null, "Bye");
			System.exit(0);
		}
		
	}
	
	
	/**
	 * close all timers
	 */
	public void closeTimer() {
		advTimer.stop();
		keyMovementTimer.stop();
		
		advTimer = null;
		keyMovementTimer = null;
	}
	
	/**
	 * Change to the next level
	 */
	public void nextLevel() {
		this.score = game.getScore();
		changeLevel(1);
	}
	
	/**
	 * initialize game Timers
	 */
	public void initTimers() {
		if(keyMovementTimer == null) {
			keyMovementTimer = new Timer(15, ML);
			keyMovementTimer.start();
		}
		
		if (advTimer == null) {
			advTimer = new Timer(5, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//update game
					game.updateAll();
					game.repaint();
					
					//update the text of JLabels
					getLifeLabel().setText("LIFE " + game.getHeroLife());
					getScoreLabel().setText("SCORE " + game.getScore());
					
					//if level is clear, change to next level
					if (game.isLevelClear()) {
						nextLevel();
						game.setLevelClear(false);
					}
					
					//if hero life is 0, game over
					if (game.getHeroLife()<=0) {
						
						game.setGameOver(true);
						game.setScore(0);
						
						advTimer.stop();
						
					}
					
				}
			});
			advTimer.start();
		}

	
	}
	
	/**
	 * generate labels
	 *
	 */
	public void setupLabels() {
		helpLabel = new JLabel("Press U and D to change level. Use ARROW KEYS to move and SPACE to shoot ");
		lifeLabel = new JLabel("LIFE "+ game.getHeroLife());
		
		scoreLabel = new JLabel("SCORE " + this.score);
		levelLabel = new JLabel("Lv " + this.currentLevel);
		
		helpLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		lifeLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		scoreLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		levelLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
	}
	
	/**
	 * reads the current level file and creates the level game component 
	 */
	public void configureCurrentLevel() {
		if(game!=null)
			game.setGameOver(false);

		
		frame.getContentPane().removeAll();
		
		game = new GameComponent();
		
		frame.setLayout(new BorderLayout());
		
		readCurrentLevel();
		
		setupLabels();
		
		game.setScore(this.score);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 5));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		panel.add(lifeLabel);
		panel.add(levelLabel);
		panel.add(scoreLabel);
		
		panel2.add(helpLabel, BorderLayout.WEST);
		
		panel.setBackground(Color.cyan);
		panel.setPreferredSize(new Dimension(50, 30));
		
		panel2.setBackground(Color.cyan);
		panel2.setPreferredSize(new Dimension(50, 30));
		
		frame.add(game);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		
		//important lines!
		frame.setFocusable(true);
		frame.requestFocus();
		
		ML = new KeyboardListener(this);
		frame.addKeyListener(ML);
		
		initTimers();	
		
		frame.repaint();
		
		frame.revalidate();
	}
	
	
}
	
	
