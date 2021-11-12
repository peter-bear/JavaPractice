
public class exercise_6 {
	String s = "Hello World!";
	int storage(String s) {
		return s.length()*2;
	}
	void print() {
		System.out.println("storage(s) = " + storage(s));
	}
	public static void main(String[] args) {
		exercise_6 st = new exercise_6();
		st.print();
	}

}
