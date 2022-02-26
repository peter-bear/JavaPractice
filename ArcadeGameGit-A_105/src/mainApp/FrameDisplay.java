package mainApp;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class FrameDisplay
 * 
 * @author A_105 <br>
 *         Purpose: Displays loading screen, end result screens <br>
 *         Restrictions: None
 */
public class FrameDisplay {

	private static JFrame frame;
	private static ViewerMain viewerMain;
	private static Clip introMusic;

	/**
	 * ensures: Runs common startup code for frame initialization
	 */
	private static void runDefaults() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(ViewerMain.FRAME_WIDTH, ViewerMain.FRAME_HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			introMusic = AudioSystem.getClip();
			introMusic.open(
					AudioSystem.getAudioInputStream(FrameDisplay.class.getResourceAsStream("Music/Menu Music.wav")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		introMusic.loop(Clip.LOOP_CONTINUOUSLY);
	} // End runDefaults

	/**
	 * ensures: Runs common code for frame building
	 * @param image the image file to display below the content
	 * @param score sends score data to the frame, -1 if no score
	 */
	private static void buildFrame(String image, int score) {
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Listens for space key press only when a FrameDisplay is visible
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					introMusic.stop();
					frame.dispose();
					viewerMain = new ViewerMain();
					viewerMain.buildFrame();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		JLabel background = new JLabel(new ImageIcon("src//MainApp//backgrounds//" + image));
		frame.setContentPane(background);
		if(score > -1) {
			frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
			JPanel panel = new JPanel();
			JLabel finalScore = new JLabel("Your final score was " + score);
			finalScore.setFont(new Font("Futura", Font.BOLD, 24));
			panel.setOpaque(false);
			panel.add(finalScore);
			frame.add(panel, gbc);
		}
		frame.pack();
		frame.setVisible(true);
	} // End buildFrame

	/**
	 * ensures: Displays a message when the game is lost
	 * 
	 * @param score the player's final score <br>
	 *              requires: score &ge; 0
	 */
	public static void gameLost(int score) {
		runDefaults();
		frame.setTitle("Game Over | Score: " + score);
		viewerMain.stop();
		buildFrame("lose.gif", score);
	} // End gameLost

	/**
	 * ensures: Displays a message when the game is won
	 * 
	 * @param score the player's final score <br>
	 *              requires: score &ge; 0
	 */
	public static void gameWon(int score) {
		runDefaults();
		frame.setTitle("Winner | Score: " + score);
		viewerMain.stop();
		buildFrame("win.gif", score);
	} // End gameWon

	/**
	 * ensures: Displays a welcome screen on first load
	 */
	public static void gameLoading() {
		runDefaults();
		frame.setTitle("Bomb Jack");
		// Runs build method without displaying score
		buildFrame("start.gif", -1);
	} // End gameLoading

}
