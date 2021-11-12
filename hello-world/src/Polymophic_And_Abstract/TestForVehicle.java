package Polymophic_And_Abstract;

public class TestForVehicle {
		public static void main(String[] args) {
			Master jim = new Master("Jim");
			Vehicle car = new Car("奔驰");
			jim.GoHome(car);
	}
}

abstract class Vehicle {
	private final String band;

	public Vehicle(String band) {
		super();
		this.band = band;
	}

	public String getBand() {
		return band;
	}

	public abstract void run();
	
}
class Car extends Vehicle{
	
	public Car(String band) {
		super(band);
	}

	@Override
	public void run() {
		System.out.println(super.getBand()+"牌的车在路上跑");
	}
	
}
