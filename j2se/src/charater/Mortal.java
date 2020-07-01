package charater;

public interface Mortal {
	public void die();
	
	//默认方法
	default public void revive() {
		System.out.println("本英雄复活了");
	}
	
}
