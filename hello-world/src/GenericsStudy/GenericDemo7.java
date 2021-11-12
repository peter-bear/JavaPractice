package GenericsStudy;

public class GenericDemo7 {
	public static void main(String[] args) {
		ImpleData<String> Imple = new ImpleData<String>();
		Imple.print("Hello World");
	}
}

interface  Data<T>{
	T getData(T t1);
}

class ImpleData<T> implements Data<T>{
	
	@Override
	public T getData(T t1) {
		return t1;
	}
	
	public void print(T t1) {
		System.out.println("Print: "+this.getData(t1));
	}
}