package charater;

public class ADAPHero extends Hero implements AD ,AP, Mortal {
    @Override
    public void physicAttack() {
         
    }
    
    @Override
    public void magicAttack() {
        
         
    }
	@Override
	public void die(){
		System.out.println(name + "�������Ӣ�۹���" );
	}

@Override
	public void attack() {
		// TODO Auto-generated method stub
		AP.super.attack();
	}

public static void main(String[] args) {
	ADAPHero we = new ADAPHero();
	we.attack();
}
}
