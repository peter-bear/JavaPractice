package Polymophic_And_Abstract;

public class Master {
	private final String name;
	public Master(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public void GoHome(Vehicle vehicle) {
		System.out.println(this.getName()+"ªÿº“¡À");
		vehicle.run();
	}
}
