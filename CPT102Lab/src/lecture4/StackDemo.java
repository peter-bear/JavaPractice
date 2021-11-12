package lecture4;


public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack<Integer> stack = new ArrayStack<>();
		stack.push(1);
		stack.push(9);
		stack.push(10);
		stack.push(4);
	}

}
class ArrayStack<E>{
	private E[] data;
	private int manyItems;
	/**
	 * Initialize an empty array Stack with an initial capacity of 10
	 */
	public ArrayStack() {
		final int INITIAL_CAPACITY =10;
		manyItems = 0;
	    data =  (E[]) new Object[INITIAL_CAPACITY];
	}
	
	/**
   * Initialize an empty array Stack with a specified initial capacity. 
   **/   
   public ArrayStack(int initialCapacity){
      if (initialCapacity < 0)
         throw new IllegalArgumentException("The initialCapacity is negative: " + initialCapacity);
      data = (E[]) new Object[initialCapacity];
      manyItems = 0;
   }
   
   /**
    * To ensure the array has enough capacity
    * @param minimumCapacity
    * 
    */
   public void ensureCapacity(int minimumCapacity){
      E[ ] biggerArray;
      
      if (data.length < minimumCapacity){
         biggerArray = (E[]) new Object[minimumCapacity];
         System.arraycopy(data, 0, biggerArray, 0, manyItems);
         data = biggerArray;
      }
   }
   
   /**
    * Push the value into the stack
    * @param value
    */
   public void push(E value) {
	   if (manyItems == data.length){  
         ensureCapacity((manyItems + 1)*2); // Ensure twice as much space as we need.
      }

      data[manyItems] = value;
      manyItems++;
   }
   
   /**
    * 
    * @return whether this stack is empty
    */
   public boolean isEmpty() {
	   return data == null || manyItems == 0;
   }
   
   /**
    * remove and return top of stack
    * @return the top element
    */
   
   public E pop() {
	   E element=null;
	   if(!isEmpty()) {
		   element = data[manyItems-1];
		   manyItems--;
	   }
	   return element;
   }
   
   /**
    * have a look at the top element
    * @return the top of stack
    */
   public E peek() {
	   E element=null;
	   if(!isEmpty()) {
		   element = data[manyItems-1];
	   }
	   return element;
   }
   
   /**
    * print all the elements
    */
   public void show() {
	   for(int i=0;i<manyItems;i++)
		   System.out.print(data[i]+" ");
	   System.out.println();
   }
   
   /**
    * 
    * @return how many items in this stack
    */
   public int size() {
	   return manyItems;
   }


	
	
	
}