package comtests;


import charater.Item;
public class Hero extends Object {
//	String name;
//	float hp;
//	float armor;
//	int moveSpeed;
	
	//��һ�������Ĺ��췽��
//	public Hero(String name) {
//		System.out.println("һ�������Ĺ��췽��");
//		this.name = name;
//		
//	}
//	
//	public Hero(String name,float hp){
//		this(name);
//		System.out.println("���������Ĺ��췽��");
//		this.hp = hp;
//	}
//	
//	//�����ĸ�����
//	public Hero(String name, float hp,float armor,int moveSpeed){
//		this(name,hp);
//		this.armor = armor;
//		this.moveSpeed = moveSpeed;
//	}
    public String name;
    protected float hp;
      
    public String toString(){
        return name;
    }
	//����
	public void finalize(){
		System.out.println(this+ "���Ӣ�����ڱ�����");
	}
	
	//�ж��Ƿ����
	public boolean equals (Object o){
		if (o instanceof Hero){
			Hero h = (Hero) o;
			return this.hp == h.hp;
		}
		return false;
	}
	public static void main(String[] args) {
//		Hero pf = new Hero("daiyu");
		
//		System.out.println(pf.name);
		
		//toString()
//		System.out.println(pf.toString());
//		System.out.println(pf);
//		Hero ght = new Hero("lisi", 520, 45.2f, 520);
//		System.out.println(ght.moveSpeed);
	
		//finalize
		Hero h = new Hero();
		for (int i= 0;i <2000;i++){
	           //���������µĶ���
            //ÿ����һ������ǰһ�����󣬾�û������ָ����
            //��Щ���󣬾������������յ�����
            //���������ѻ��ıȽ϶��ʱ�򣬾ͻᴥ����������
            //һ��������󱻻��գ�����finalize()�����ͻᱻ����
            h = new Hero();
		}
//        Hero h1= new Hero();
//        h1.hp = 300;
//        Hero h2= new Hero();
//        h2.hp = 400;
//        Hero h3= new Hero();
//        h3.hp = 300;
         
//        System.out.println(h1.equals(h2));
//        System.out.println(h1.equals(h3));
//        	System.out.println(h1 == h2);
//        	System.out.println(h1 == h3);
	}
}
