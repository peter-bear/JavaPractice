package mainApp;


/**
 * Class: MainApp
 * @author Arcade Game Team A202
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	
	private void runApp() {
//		System.out.println("Write your cool arcade game here!");
		GameDriver gs = new GameDriver();
		gs.showStartPage();
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main

}