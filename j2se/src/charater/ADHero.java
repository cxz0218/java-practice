package charater;
	
public class ADHero extends Hero implements AD,AP,Mortal{
    public void useItem(Item i) {
        System.out.println("adhero use item");
        super.useItem(i);
    }
//	public ADHero (){
//		System.out.println("AD Hero�Ĺ��췽��");
//	}
//	
	int moveSpeed =400;//�ƶ��ٶ� 
    public int getMoveSpeed(){
        return this.moveSpeed;
    }
     
    public int getMoveSpeed2(){
        return super.moveSpeed;
    }
//	public ADHero (String name){
//		super(name);
//		System.out.println("AD Hero�Ĺ��췽��");
//	}
//	���ظ����battleWin����
	public static void battleWin(){
		System.out.println("ad hero battle win");
	}
	@Override
	public void die(){
		System.out.println(name + "�������Ӣ�۹���" );
	}
	@Override
	public void physicAttack() {
		System.out.println("������������");
	}
	
	public void magicAttack() {
		System.out.println("������ħ������");
	}
	public void attack(){
//		System.out.println(name + "����һ�ι���������ȷ��������˭");
		physicAttack();
	}
	public void attack(Hero h1) {
		System.out.println(name + "��" + h1.name + "������һ�ι���");
	}
	public void attack(Hero h1,Hero h2){
		System.out.println(name + "ͬʱ��" + h1.name + "��" + h2.name + "������һ�ι���");
	}
	public void attack(Hero...heros){
		for(int i = 0;i < heros.length;i++){
			System.out.println(name + "������" + heros[i].name); 
		}
	}
	
	// ��һ���෽����ֱ�ӵ��ö��󷽷�


	static String copyright;
	public static void main(String[] args) {
//		ADHero h3 = new ADHero ();
//		h3.name = "�ͽ�����";//�̳�
//		ADHero.copyright = "ming";
//		System.out.println(h3.copyright);
//		h3.copyright = "king";
//		System.out.println(h3.copyright);
//		Hero h1 = new Hero();
//		h1.name = "����";
//		
//		Hero h2 = new Hero();
//		h2.name = "Ī��";
//		
//		h3.attack(h1);
//		h3.attack(h1, h2);
//		
//		Hero h = new ADHero();
//		Hero.battleWin();
//		ADHero.battleWin();
//		h.battleWin();	
		
//		new ADHero();
		//new ADHero("������");
//	       ADHero h= new ADHero();
//	         
//	        System.out.println(h.getMoveSpeed());
//	        System.out.println(h.getMoveSpeed2());
	        
//	        ADHero h3 = new ADHero();
//	        
////	        LifePotion lp = new LifePotion();
//	       	ADHero.copyright = "ming";
//			System.out.println(h3.copyright);
//			h3.copyright = "king";
//			System.out.println(h3.copyright);
	}
}
