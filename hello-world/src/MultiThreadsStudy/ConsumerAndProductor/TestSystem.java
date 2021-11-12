package MultiThreadsStudy.ConsumerAndProductor;

public class TestSystem {
	public static void main(String[] args) {
		Container breads = new Container();
		Cons Kity = new Cons();
		Pro Tim = new Pro();
		Kity.Eat(breads);
		Tim.Produce(breads);
		new Thread(Tim).start();
		new Thread(Kity).start();
		
	}
}
