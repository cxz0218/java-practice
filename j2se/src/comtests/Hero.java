package comtests;


import charater.Item;
public class Hero extends Object {
//	String name;
//	float hp;
//	float armor;
//	int moveSpeed;
	
	//带一个参数的构造方法
//	public Hero(String name) {
//		System.out.println("一个参数的构造方法");
//		this.name = name;
//		
//	}
//	
//	public Hero(String name,float hp){
//		this(name);
//		System.out.println("两个参数的构造方法");
//		this.hp = hp;
//	}
//	
//	//带有四个参数
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
	//回收
	public void finalize(){
		System.out.println(this+ "这个英雄正在被回收");
	}
	
	//判断是否相等
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
	           //不断生成新的对象
            //每创建一个对象，前一个对象，就没有引用指向了
            //那些对象，就满足垃圾回收的条件
            //当，垃圾堆积的比较多的时候，就会触发垃圾回收
            //一旦这个对象被回收，它的finalize()方法就会被调用
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
