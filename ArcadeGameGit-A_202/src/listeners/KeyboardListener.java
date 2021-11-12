package listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.HashSet;

import mainApp.GameComponent;
import mainApp.GameDriver;
/**
 * Reads keyboard input, including level changes and movements
 * @author Qingyuan Jiao, Yao Xiong
 *
 */
public class KeyboardListener implements KeyListener, ActionListener {
	
	private GameComponent gameComp;
	private GameDriver gameDriver;
	
	private HashSet<Integer> commands = new HashSet<>();

	public KeyboardListener (GameDriver game) {
		this.gameDriver = game;
		this.gameComp = game.getGameComponent();

	}
	



	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	@Override
	/**
	 * when a key is pressed, adds the key to the commands list
	 */
	public void keyPressed(KeyEvent e) {
		
		//if the key pressed is space and game is over, reset the game
		if (e.getKeyCode() == KeyEvent.VK_SPACE && gameComp.isGameOver()) {
			gameDriver.closeTimer();
			gameDriver.configureCurrentLevel();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP || 
				 e.getKeyCode() == KeyEvent.VK_LEFT  || 
				 e.getKeyCode() == KeyEvent.VK_RIGHT ||
				 e.getKeyCode() == KeyEvent.VK_SPACE ||
				 e.getKeyCode() == KeyEvent.VK_D ||
				 e.getKeyCode() == KeyEvent.VK_U) {
			if (e.getKeyCode() == KeyEvent.VK_UP && !(gameComp.getHero(0).ifCollideWithPlane())) {
				gameComp.getHero(0).resetVelocity();
			}
			 commands.add(e.getKeyCode());
		 }
	}
	
	@Override
	/**
	 * if the key is released, deletes the key code in commands list
	 */
	public void keyReleased(KeyEvent e) {
		 if (e.getKeyCode() == KeyEvent.VK_UP || 
				 e.getKeyCode() == KeyEvent.VK_LEFT  || 
				 e.getKeyCode() == KeyEvent.VK_RIGHT ||
				 e.getKeyCode() == KeyEvent.VK_D ||
				 e.getKeyCode() == KeyEvent.VK_SPACE ||
				 e.getKeyCode() == KeyEvent.VK_U) {
			 commands.remove(e.getKeyCode());
		 }
		 
	}

	@Override
	/**
	 * move the hero according to the commands in commands list
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if ( !gameComp.isOnPlane(gameComp.getHero(0)) ) {
			gameComp.getHero(0).fall();
        }
		
         if(commands.contains(KeyEvent.VK_RIGHT)) {
        	 
        	 gameComp.getHero(0).changeFacing(1);
        	 gameComp.getHero(0).move();
         } 
         if(commands.contains(KeyEvent.VK_LEFT)) {
        	 
        	 gameComp.getHero(0).changeFacing(-1);
        	 gameComp.getHero(0).move();
         } 
         if(commands.contains(KeyEvent.VK_UP)) {
        	 gameComp.getHero(0).moveUp();
         } 
         if(commands.contains(KeyEvent.VK_D)) {
        	 gameDriver.changeLevel(-1);
         }
         if(commands.contains(KeyEvent.VK_U)) {
        	 gameDriver.changeLevel(1);
         }
         
         if(commands.contains(KeyEvent.VK_SPACE)) {
        	 if(gameComp.getBulletNum()<=5) {
        		 if (gameComp.getHero(0).getFacing() == 1) {
    				 gameComp.addBullet(gameComp.getHero(0).getX() + gameComp.getHero(0).getLength() + 10,
    						 gameComp.getHero(0).getY() + gameComp.getHero(0).getHeight() / 2,
    						 1);
    			 } else {
    				 gameComp.addBullet(gameComp.getHero(0).getX() - 10 - 10, 
    						 gameComp.getHero(0).getY() + gameComp.getHero(0).getHeight() / 2,
    						 -1);
    			 } 
        	 }
			 
		}
         
		 
		 
			 
	}
			 
			 
			
	         
	     
}
		
	


