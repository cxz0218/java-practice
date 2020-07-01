package charater;

public abstract class Animal {

	protected int legs;//记录动物腿的数目
	
	protected  Animal(int legs){ //初始化legs属性
		this.legs = legs;
	}
	
	public abstract  void eat();
	
	public void walk (){
		System.out.println( "用" + legs + "条腿走路");
	}
}
