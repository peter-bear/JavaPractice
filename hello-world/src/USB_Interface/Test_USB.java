package USB_Interface;

public class Test_USB {
	public static void main(String[] args) {
		Computer Windows = new Computer();
		Windows.setUsb1(new Fan());
		Windows.setUsb2(new USB_Flash());
		Windows.Run();
	}
}
