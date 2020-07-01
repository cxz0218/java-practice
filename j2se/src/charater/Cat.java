package charater;

public class Cat extends Animal implements Pet{
	private String name;
	
	@Override
	public  void setName(String name){
		this.name = name;
	}
	
	@Override
	public String getName(){
		return name;
	
	}
	@Override
	public void play(){
		System.out.println("Cat is playing");
	}
	
	@Override
	public void eat(){
		System.out.println("Cat is eating");
	}
	
	//ππ‘Ï∆˜
	public Cat(String name){
		super(4);
		this.name = name;
	}
	
	public Cat(){
		this(" ");
	}
	public static void main(String[] args) {
//		Cat cat = new Cat("MIMI");
		Cat cat = new Cat();
		cat.setName("ﬂ‰ﬂ‰");
		cat.getName();
		cat.walk();
		cat.eat();
		cat.play();
	}
}
