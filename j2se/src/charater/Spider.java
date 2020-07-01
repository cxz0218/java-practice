package charater;

public class Spider extends Animal {


	@Override
	public void eat(){
		System.out.println( "用蛛网吃小动物");
	}
	public Spider(){
		super(8);
		System.out.println("OK");
	}
	
	public static void main(String[] args) {
		Spider zhuzhi = new Spider();
		zhuzhi.eat();
		zhuzhi.walk();

	}
}
