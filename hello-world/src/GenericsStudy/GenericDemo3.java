package GenericsStudy;

public class GenericDemo3<T> {
	private T t;
	public void add(T t) {
		this.t = t;
	}
	public T get() {
		return this.t;
	}
	public static void main(String[] args) {
		GenericDemo3<Integer> one = new GenericDemo3<Integer>();
		GenericDemo3<String> two = new GenericDemo3<String>();
		one.add(1);
		two.add("Hello World");
		System.out.println(one.get());
		System.out.println(two.get());
	}
}
