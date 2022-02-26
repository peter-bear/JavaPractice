package mainApp;

import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class: ViewerMain
 * 
 * @author A_105 <br>
 *         Purpose: Top level class for CSSE220 Project containing main method
 *         <br>
 *         Restrictions: Level files must exist in the respective folder, grids
 *         must match MAX_HEIGHT and MAX_WIDTH <br>
 *         For example:
 * 
 *         <pre>
 *         ViewerMain v = new ViewerMain();
 *         </pre>
 */
public class ViewerMain {

	private ArrayList<Level> levels = new ArrayList<Level>();
	private File dir = new File("src//mainApp//levels");
	private Scanner s;
	public JFrame frame;
	public int levelId;
	public Level level;
	private Timer t;
	private final int MAX_HEIGHT = 16;
	private final int MAX_WIDTH = 16;
	public static final int FRAME_WIDTH = 526;
	public static final int FRAME_HEIGHT = 549;
	public static final int DELAY = 10;
	private Clip levelMusic;

	/**
	 * ensures: Creates a new instance of the game
	 */
	public ViewerMain() {
		try {
			this.levelMusic = AudioSystem.getClip();
			this.levelMusic.open(
					AudioSystem.getAudioInputStream(ViewerMain.class.getResourceAsStream("Music/LevelMusic.wav")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.levelMusic.loop(Clip.LOOP_CONTINUOUSLY);
	} // End constructor

	/**
	 * ensures: Ends the game
	 */
	public void stop() {
		this.levelMusic.stop();
		t.stop();
	} // End stop

	/**
	 * ensures: Builds the game JFrame
	 */
	public void buildFrame() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		handleCreateLevel();
		handleSetLevel(levels.get(0), 0, 3);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 85 && dir.list().length > levelId + 1) {
					frame.remove(levels.get(levelId));
					handleSetLevel(levels.get(levelId + 1), level.getScore(), level.geth1Lives());
				} else if (e.getKeyCode() == 68 && levelId - 1 >= 0) {
					frame.remove(levels.get(levelId));
					handleSetLevel(levels.get(levelId - 1), level.getScore(), level.geth1Lives());
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
	} // End buildFrame

	/**
	 * ensures: Sets the current level displayed in the frame
	 * 
	 * @param level the level to display <br>
	 *              requires: level &ne; null
	 * @param score inherited from previous level <br>
	 *              requires: score &ge; 0
	 * @param lives inherited from previous level <br>
	 *              requires: lives &gt; 0
	 */
	public void handleSetLevel(Level level, int score, int lives) {
		this.level = level;
		if(t != null) {
			t.stop();
		}
		frame.getContentPane().removeAll();
		frame.repaint();
		levelId = level.getId();
		frame.add(level);
		level.updateLives(lives);
		level.updateScore(score);
		t = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (level.update()) {
					if (levelId + 1 < dir.list().length) {
						frame.remove(levels.get(levelId));
						handleSetLevel(levels.get(levelId + 1), level.getScore(), level.geth1Lives());
					} else {
						frame.remove(levels.get(levelId));
						FrameDisplay.gameWon(level.getScore());
						frame.dispose();
					}
				}
				level.repaint();
			}
		});
		t.start();
		frame.setTitle("Bomb Jack | Level " + (levelId+1));
		frame.pack();
		frame.repaint();
	} // End handleSetLevel

	/**
	 * ensures: Creates a new level for each file in the /levels folder
	 */
	public void handleCreateLevel() {
		int id = 0;
		for (String str : dir.list()) {
			File f = new File("src//mainApp//levels//" + str);
			try {
				s = new Scanner(f);
				levels.add(new Level(frame, id));
				int y = 0;
				while (s.hasNextLine()) {
					String line = s.nextLine();
					for (int i = 0; i < line.length(); i++) {
						if (i >= MAX_WIDTH || y >= MAX_HEIGHT) {
							throw new IndexOutOfBoundsException();
						}
						levels.get(levels.size() - 1).addObject(line.substring(i, i + 1), i * 32, y * 32);
					}
					y++;
				}
				id++;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	} // End handleCreateLevel
}