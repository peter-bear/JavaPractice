package GenericsStudy;

public class GenericDemo6 {
	public static void main(String[] args) {
		Dictionary<String, Integer> dic1 = new Dictionary<String, Integer>();
		dic1.put("Peter",110);
		System.out.println(dic1.getKey());
		System.out.println(dic1.getValue());
		System.out.println(dic1.getAll());
	}
}

class Dictionary<K, V>{
	private K key;
	private V value;
	public void put(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	public String getAll() {
		return key.toString()+":"+value.toString();
	}
	
}