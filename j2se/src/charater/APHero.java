package charater;

public class APHero extends Hero implements AD ,Mortal {
    @Override
    public void physicAttack() {
         
    }
	@Override
	public void die(){
		System.out.println(name + "这个物理英雄挂了" );
	}
}
