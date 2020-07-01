package charater;
	
public class ADHero extends Hero implements AD,AP,Mortal{
    public void useItem(Item i) {
        System.out.println("adhero use item");
        super.useItem(i);
    }
//	public ADHero (){
//		System.out.println("AD Hero的构造方法");
//	}
//	
	int moveSpeed =400;//移动速度 
    public int getMoveSpeed(){
        return this.moveSpeed;
    }
     
    public int getMoveSpeed2(){
        return super.moveSpeed;
    }
//	public ADHero (String name){
//		super(name);
//		System.out.println("AD Hero的构造方法");
//	}
//	隐藏父类的battleWin方法
	public static void battleWin(){
		System.out.println("ad hero battle win");
	}
	@Override
	public void die(){
		System.out.println(name + "这个物理英雄挂了" );
	}
	@Override
	public void physicAttack() {
		System.out.println("进行了物理攻击");
	}
	
	public void magicAttack() {
		System.out.println("进行了魔法攻击");
	}
	public void attack(){
//		System.out.println(name + "进行一次攻击，但不确定打中了谁");
		physicAttack();
	}
	public void attack(Hero h1) {
		System.out.println(name + "对" + h1.name + "进行了一次攻击");
	}
	public void attack(Hero h1,Hero h2){
		System.out.println(name + "同时对" + h1.name + "和" + h2.name + "进行了一次攻击");
	}
	public void attack(Hero...heros){
		for(int i = 0;i < heros.length;i++){
			System.out.println(name + "攻击了" + heros[i].name); 
		}
	}
	
	// 在一个类方法里直接调用对象方法


	static String copyright;
	public static void main(String[] args) {
//		ADHero h3 = new ADHero ();
//		h3.name = "赏金雷人";//继承
//		ADHero.copyright = "ming";
//		System.out.println(h3.copyright);
//		h3.copyright = "king";
//		System.out.println(h3.copyright);
//		Hero h1 = new Hero();
//		h1.name = "盖伦";
//		
//		Hero h2 = new Hero();
//		h2.name = "莫提";
//		
//		h3.attack(h1);
//		h3.attack(h1, h2);
//		
//		Hero h = new ADHero();
//		Hero.battleWin();
//		ADHero.battleWin();
//		h.battleWin();	
		
//		new ADHero();
		//new ADHero("德莱文");
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
