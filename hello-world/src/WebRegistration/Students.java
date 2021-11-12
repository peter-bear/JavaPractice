package WebRegistration;

public class Students {
	private int ID;
	private String name;
	private String password;
	
	public Students(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPass() {
		return this.password;
	}
	public void setPass(String password) {
		this.password = password;
	}
}
