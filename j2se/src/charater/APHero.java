package charater;

public class APHero extends Hero implements AD ,Mortal {
    @Override
    public void physicAttack() {
         
    }
	@Override
	public void die(){
		System.out.println(name + "�������Ӣ�۹���" );
	}
}
