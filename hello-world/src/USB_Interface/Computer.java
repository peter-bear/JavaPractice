package USB_Interface;

public class Computer {
	private USB usb1;
	private USB usb2;
	
	public USB getUsb1() {
		return usb1;
	}

	public void setUsb1(USB usb1) {
		this.usb1 = usb1;
	}

	public USB getUsb2() {
		return usb2;
	}

	public void setUsb2(USB usb2) {
		this.usb2 = usb2;
	}

	public void Run() {
		System.out.println("Computer starts to work!!");
		if(this.getUsb1() != null) {
			usb1.Service();
		}
		if(this.getUsb2() != null) {
			usb2.Service();
		}
	}
	
}
