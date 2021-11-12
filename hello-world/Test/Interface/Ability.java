package Interface;

public interface Ability extends flyable, swimmable{
	public abstract void fly();
}

interface flyable{
	public abstract void fly();
}

interface swimmable{
	public abstract void swim();
}