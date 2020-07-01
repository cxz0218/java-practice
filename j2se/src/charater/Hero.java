package charater;
//
////public class Hero {
////	String name;
////	
////	float hp;
////	
////	float armor;
////	
////	int moveSpeed;
////	
////	int killed;
////	
////	int kill;
////	
////	int assists;
////	
////	float money;
////	
////	int knives;
////	
////	float attackSpeed;
////	
////	String wordsAfterKill;
////
////	String wordsAfterKilled;
////	
////	//获得护甲
////	float getArmor(){
////		return armor;
////	}
////	
////	//坑队友
////	void keng(){
////		System.out.println("坑队友!");
////	}
////	
////	void addSpeed(int speed){
////		
////		moveSpeed+=speed;
////	}
////	
////	void legendary(){
////		System.out.println("超神!");
////	}
////	
////	float getHp (){
////		return hp;
////	}
//	
////	void recovery(float blood){
////		hp+=blood;
////	}
////
////	//构造方法
////	public Hero(String heroName,float heroHP ,float heroArmor,int heroMoveSpeed){
////		name = heroName;
////		hp = heroHP;
////		armor = heroArmor;
////		moveSpeed = heroMoveSpeed;
////	}
////
////	public static void main(String[] args) {
//		
////		Hero Garen = new Hero();
////		Garen.name = "盖伦";
////		Garen.hp = 616.28f;//血量
////		System.out.println(Garen.name + "当前血量是" + Garen.getHp());
////		System.out.println("回血100");
////		Garen.recovery(100);
////		System.out.println(Garen.name + "现在血量是" + Garen.getHp());
////		Garen.armor = 27.536f;
////		Garen.moveSpeed = 235;
////		Garen.addSpeed(100);
////		Garen.kill = 15;
////		Garen.killed = 25;
////		Garen.assists = 30;
////		Garen.money = 1223.4f;
////		Garen.knives = 50;
////		Garen.attackSpeed = 324f;
////		Garen.wordsAfterKill = "smile";
////		Garen.wordsAfterKilled = "zeze";
////		
////		
////		
////		Hero Teemo = new Hero();
////		Teemo.name = "提莫";
////		Teemo.hp = 382.45f;
////		Teemo.armor =14;
////		Teemo.moveSpeed = 330;
//		
//		//使用构造方法
////		Hero geeen = new Hero("lisi",500f,465.4f,562);
////	}
////
////}
//
public /*abstract*/ class Hero {
    
    String name; //姓名
     
    float hp; //血量
     
    float armor; //护甲
     
    int moveSpeed = 520; //移动速度
//    
//   //无参构造方法 
    public Hero(){
    	System.out.println("Hero的无参构造方法");
    }
    
    //有参构造方法
    public Hero (String name){
    	System.out.println("Hero的有一个参数的构造方法");
    	this.name = name;
    }

	    //抽象类
//    public abstract void attack();
    public void useItem(Item i) {
        System.out.println("hero use item");
    }

    //类方法，静态方法
    //通过类就可以直接调用
	public static void battleWin(){
		System.out.println("hero battle win");
	}
 
    //参数名和属性名一样
    //在方法体中，只能访问到参数name
    public void setName1(String name){
        name = name;
    }
     
    //为了避免setName1中的问题，参数名不得不使用其他变量名
    public void setName2(String heroName){
        name = heroName;
        
    }
     
    //通过this访问属性
    public void setName3(String name){
        //name代表的是参数name
        //this.name代表的是属性name
        this.name = name;
    }
     
    public void kill(Mortal m){
    	System.out.println(name + "放了一个大招");
    	m.die();
    }
    public static void main(String[] args) {
        Hero  h =new Hero();
        
        h.name = "ter";
      h.setName1("teemo");
        System.out.println(h.name);
         
        h.setName2("garen");
        System.out.println(h.name);    
         
        h.setName3("死歌");
        System.out.println(h.name); 
    	
    	//引用类型和对象类型。
//    	 Hero h = new Hero(); 
//    	 h.name = "盖伦";
//    	 ADHero one = new ADHero();
//    	 one.name = "爱惜";
//    	 APHero two = new APHero();
//    	 two.name = "安妮";
//    	 ADAPHero three = new ADAPHero();
//    	 three.name = "库奇";
//    	 h.kill(one);
//    	 h.kill(two);
//    	 
    	 new Hero();      
    }
     
}
			//静态内部类
//public class Hero {
//    public String name;
//    protected float hp;
//  
//    private static void battleWin(){
//        System.out.println("battle win");
//    }
//     
//    //敌方的水晶
//    static class EnemyCrystal{
//        int hp=5000;
//         
//        //如果水晶的血量为0，则宣布胜利
//        public void checkIfVictory(){
//            if(hp==0){
//                Hero.battleWin();
//                 
//                //静态内部类不能直接访问外部类的对象属性
//                System.out.println(name + " win this game");
//            }
//        }
//    }
//     
//    public static void main(String[] args) {
//        //实例化静态内部类
//        Hero.EnemyCrystal crystal = new Hero.EnemyCrystal();
//        crystal.hp = 0;
//        crystal.checkIfVictory();
//    }
//  
//}

					// 匿名类
//public abstract class Hero {
//    String name; //姓名
//          
//    float hp; //血量
//          
//    float armor; //护甲
//          
//    int moveSpeed; //移动速度
//      
//    public abstract void attack();
//      
//    public static void main(String[] args) {
//          
//        ADHero adh=new ADHero();
//        //通过打印adh，可以看到adh这个对象属于ADHero类
//        adh.attack();
//        System.out.println(adh);
//          
//        Hero h = new Hero(){
//            //当场实现attack方法
//            public void attack() {
//                System.out.println("新的进攻手段");
//            }
//        };
//        h.attack();
//        //通过打印h，可以看到h这个对象属于Hero$1这么一个系统自动分配的类名
//          
//        System.out.println(h);
//    }
//      
//}