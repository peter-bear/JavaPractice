package mainApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Class Level
 * 
 * @author A_105 <br>
 *         Purpose: Creates a new Level with Objects <br>
 *         Restrictions: Level sizing is determined by final variables in
 *         ViewerMain <br>
 *         For example:
 * 
 *         <pre>
 *         Level l = new Level(frame, 1);
 *         </pre>
 */
public class Level extends JComponent {

	private static final long serialVersionUID = 1L;
	private int id, score, bombCount;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Bomb> bombs = new ArrayList<>();
	private ArrayList<Platform> platforms = new ArrayList<>();
	public JFrame frame;
	private Hero h;
	private Clip nextLevelSound;

	/**
	 * ensures: Initializes a new level
	 * @param frame the JFame where the level is displayed
	 * <br> requires: frame &ne; null
	 * @param id the numerical identifier of the level
	 * <br> requires: id &ge; 0
	 */
	public Level(JFrame frame, int id) {
		this.frame = frame;
		this.id = id;
		this.bombCount = 0;
		h = new Hero();
		try {
			this.nextLevelSound = AudioSystem.getClip();
			this.nextLevelSound.open(
					AudioSystem.getAudioInputStream(Level.class.getResourceAsStream("Music/Next Level.wav")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ensures: Updates the value of the score
	 * @param score the score value to set
	 * <br> requires: score &ge; 0
	 */
	public void updateScore(int score) {
		this.score = score;
	} // End updateScore

	/**
	 * ensures: Returns the current score value
	 * @return the score
	 */
	public int getScore() {
		return score;
	} // End getScore

	/**
	 * ensures: Updates the number of hero lives
	 * @param lives the number of lives to set
	 * <br> requires: lives &gt; 1
	 */
	public void updateLives(int lives) {
		h.setLives(lives);
	} // End updateLives

	/**
	 * ensures: Returns the current number of lives
	 * @return number of lives
	 */
	public int geth1Lives() {
		return h.getLives();
	} // End geth1Lives

	/**
	 * ensures: Creates a new object in the level
	 * @param type the type of object to create
	 * <br> requires: type = "H" || "P" || "S" || "O" || "T" || "B"
	 * @param x the x position
	 * <br> requires: x &ge; 0
	 * @param y the y position
	 * <br> requires: y &ge; 0
	 */
	public void addObject(String type, int x, int y) {
		switch (type) {
		case "H":
			h.setPosition(x,  y);
			frame.addKeyListener(new KeyListener() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						h.jump();
					} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						h.holdKey("left", true);
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						h.holdKey("right", true);
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						h.fastFall();
					}
					
				}
				@Override
				public void keyTyped(KeyEvent e) {}
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						h.cancelJump();
					}
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						h.holdKey("left", false);
					}
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						h.holdKey("right", false);
					}
				}
			});
			break;
		case "P":
			platforms.add(new Platform(x, y));
			break;
		case "S":
			// Spaces are not initialized, this is a placeholder
			break;
		case "O":
			enemies.add(new AlienOne(x, y));
			break;
		case "T":
			enemies.add(new AlienTwo(x, y, this.h));
			break;
		case "B":
			bombs.add(new Bomb(x, y));
			break;
		}
	} // End addObject

	/**
	 * ensures: Checks for collisions between objects
	 * @return true when the level has ended
	 */
	public boolean update() {
		boolean hero1OnPlat = false;
		h.update();
		for (Bomb b : bombs) {
			b.update();
			if (h.collidesWith(b)) {
				b.collect();
				this.bombCount++;
				this.score += 200;
				if (this.bombCount == bombs.size()) {
					nextLevelSound.start();
					nextLevelSound.setMicrosecondPosition(0);
					return true;
				}
			}
			b.update();
		}
		for (Platform p : platforms) {
			if (h.collidesWith(p)) {
				h.reposition(p);
				hero1OnPlat = true;
			}
		}
		for (Enemy e : enemies) {
			e.update();
			if (h.collidesWith(e)) {
				if (h.isAbove(e)) {
					e.die();
					this.score += 500;
				} else {
					h.takeLife();
					if (h.getLives() == 0) {
						frame.dispose();
						FrameDisplay.gameLost(score);
					}
				}
				h.knockBack(e);
			}
			for (Platform p : platforms) {
				if (e.collidesWith(p)) {
					e.reposition(p);
				}
			}
			e.resetCollision();
		}
		if (!hero1OnPlat && h.y < this.getHeight() - 32)
			h.fall();
		return false;
	} // End update

	/**
	 * ensures: Returns the level id
	 * @return the level id
	 */
	public int getId() {
		return id;
	} // End getId

	/**
	 * ensures: Draws objects in the frame
	 * @param g the graphics controller
	 */
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(Toolkit.getDefaultToolkit().getImage("src//MainApp//backgrounds//level" + (id+1) + ".jpg"), 0, 0, null);
		g2.setBackground(Color.BLACK);
		h.drawOn(g2);
		// Draws face on Hero
//		g2.setColor(Color.WHITE);
//		g2.fillOval((int) h.x + 5, (int) h.y + 10, 6, 6);
//		g2.fillOval((int) h.x + 20, (int) h.y + 10, 6, 6);
//		g2.setColor(Color.BLACK);
//		g2.fillOval((int) h.x + 5, (int) h.y + 10, 5, 5);
//		g2.fillOval((int) h.x + 20, (int) h.y + 10, 5, 5);
//		g2.drawLine((int) h.x + 5, (int) h.y + 25, (int) h.x + 25, (int) h.y + 25);
//		g2.drawLine((int) h.x + 5, (int) h.y + 26, (int) h.x + 25, (int) h.y + 26);
		for (Object o : platforms) {
			o.drawOn(g2);
		}
		for (Object o : bombs) {
			o.drawOn(g2);
			if (!o.isDead) {
				// Draws stem of Bomb
				g2.setColor(Color.BLACK);
				g2.fillRect((int) o.x + 15, (int) o.y - 15, 2, 15);
				g2.setColor(Color.RED);
				g2.fillRect((int) o.x + 15, (int) o.y - 15, 2, 5);
			}
		}
		for (Object o : enemies) {
			o.drawOn(g2);
			if (!o.isDead) {
				// Draws face on Enemy
				g2.setColor(Color.WHITE);
				g2.fillOval((int) o.x + 5, (int) o.y + 10, 6, 6);
				g2.fillOval((int) o.x + 20, (int) o.y + 10, 6, 6);
				g2.setColor(Color.BLACK);
				g2.fillOval((int) o.x + 5, (int) o.y + 10, 5, 5);
				g2.fillOval((int) o.x + 20, (int) o.y + 10, 5, 5);
				g2.drawLine((int) o.x + 5, (int) o.y + 25, (int) o.x + 25, (int) o.y + 25);
				g2.drawLine((int) o.x + 5, (int) o.y + 26, (int) o.x + 25, (int) o.y + 26);
				g2.drawLine((int) o.x + 7, (int) o.y + 5, (int) o.x + 14, (int) o.y + 10);
				g2.drawLine((int) o.x + 25, (int) o.y + 5, (int) o.x + 18, (int) o.y + 10);
				g2.drawLine((int) o.x + 8, (int) o.y + 5, (int) o.x + 15, (int) o.y + 10);
				g2.drawLine((int) o.x + 26, (int) o.y + 5, (int) o.x + 19, (int) o.y + 10);

			}
		}
		// Displays text with current level, lives, and score
		Font s = new Font("Dialog", Font.PLAIN, 20);
		g2.setFont(s);
		g2.setColor(Color.WHITE);
		g2.drawString("Score:" + score, 380, 500);
		g2.drawString("Lives: " + h.getLives(), 280, 500);
		g2.drawString("Level " + (this.id + 1), 30, 500);
	} // End paintComponent
}
