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
////	//��û���
////	float getArmor(){
////		return armor;
////	}
////	
////	//�Ӷ���
////	void keng(){
////		System.out.println("�Ӷ���!");
////	}
////	
////	void addSpeed(int speed){
////		
////		moveSpeed+=speed;
////	}
////	
////	void legendary(){
////		System.out.println("����!");
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
////	//���췽��
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
////		Garen.name = "����";
////		Garen.hp = 616.28f;//Ѫ��
////		System.out.println(Garen.name + "��ǰѪ����" + Garen.getHp());
////		System.out.println("��Ѫ100");
////		Garen.recovery(100);
////		System.out.println(Garen.name + "����Ѫ����" + Garen.getHp());
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
////		Teemo.name = "��Ī";
////		Teemo.hp = 382.45f;
////		Teemo.armor =14;
////		Teemo.moveSpeed = 330;
//		
//		//ʹ�ù��췽��
////		Hero geeen = new Hero("lisi",500f,465.4f,562);
////	}
////
////}
//
public /*abstract*/ class Hero {
    
    String name; //����
     
    float hp; //Ѫ��
     
    float armor; //����
     
    int moveSpeed = 520; //�ƶ��ٶ�
//    
//   //�޲ι��췽�� 
    public Hero(){
    	System.out.println("Hero���޲ι��췽��");
    }
    
    //�вι��췽��
    public Hero (String name){
    	System.out.println("Hero����һ�������Ĺ��췽��");
    	this.name = name;
    }

	    //������
//    public abstract void attack();
    public void useItem(Item i) {
        System.out.println("hero use item");
    }

    //�෽������̬����
    //ͨ����Ϳ���ֱ�ӵ���
	public static void battleWin(){
		System.out.println("hero battle win");
	}
 
    //��������������һ��
    //�ڷ������У�ֻ�ܷ��ʵ�����name
    public void setName1(String name){
        name = name;
    }
     
    //Ϊ�˱���setName1�е����⣬���������ò�ʹ������������
    public void setName2(String heroName){
        name = heroName;
        
    }
     
    //ͨ��this��������
    public void setName3(String name){
        //name������ǲ���name
        //this.name�����������name
        this.name = name;
    }
     
    public void kill(Mortal m){
    	System.out.println(name + "����һ������");
    	m.die();
    }
    public static void main(String[] args) {
        Hero  h =new Hero();
        
        h.name = "ter";
      h.setName1("teemo");
        System.out.println(h.name);
         
        h.setName2("garen");
        System.out.println(h.name);    
         
        h.setName3("����");
        System.out.println(h.name); 
    	
    	//�������ͺͶ������͡�
//    	 Hero h = new Hero(); 
//    	 h.name = "����";
//    	 ADHero one = new ADHero();
//    	 one.name = "��ϧ";
//    	 APHero two = new APHero();
//    	 two.name = "����";
//    	 ADAPHero three = new ADAPHero();
//    	 three.name = "����";
//    	 h.kill(one);
//    	 h.kill(two);
//    	 
    	 new Hero();      
    }
     
}
			//��̬�ڲ���
//public class Hero {
//    public String name;
//    protected float hp;
//  
//    private static void battleWin(){
//        System.out.println("battle win");
//    }
//     
//    //�з���ˮ��
//    static class EnemyCrystal{
//        int hp=5000;
//         
//        //���ˮ����Ѫ��Ϊ0��������ʤ��
//        public void checkIfVictory(){
//            if(hp==0){
//                Hero.battleWin();
//                 
//                //��̬�ڲ��಻��ֱ�ӷ����ⲿ��Ķ�������
//                System.out.println(name + " win this game");
//            }
//        }
//    }
//     
//    public static void main(String[] args) {
//        //ʵ������̬�ڲ���
//        Hero.EnemyCrystal crystal = new Hero.EnemyCrystal();
//        crystal.hp = 0;
//        crystal.checkIfVictory();
//    }
//  
//}

					// ������
//public abstract class Hero {
//    String name; //����
//          
//    float hp; //Ѫ��
//          
//    float armor; //����
//          
//    int moveSpeed; //�ƶ��ٶ�
//      
//    public abstract void attack();
//      
//    public static void main(String[] args) {
//          
//        ADHero adh=new ADHero();
//        //ͨ����ӡadh�����Կ���adh�����������ADHero��
//        adh.attack();
//        System.out.println(adh);
//          
//        Hero h = new Hero(){
//            //����ʵ��attack����
//            public void attack() {
//                System.out.println("�µĽ����ֶ�");
//            }
//        };
//        h.attack();
//        //ͨ����ӡh�����Կ���h�����������Hero$1��ôһ��ϵͳ�Զ����������
//          
//        System.out.println(h);
//    }
//      
//}