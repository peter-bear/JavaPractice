package StudyFundation;

import javax.swing.JFrame;

public class TestTank extends JFrame{
	public TestTank() {
		// TODO Auto-generated constructor stub
		TankPanel tp = new TankPanel();
		Thread main = new Thread(tp);
		main.start();
		this.add(tp);
		this.addKeyListener(tp);
		this.setSize(1300, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestTank test = new TestTank();

	}

}
