package charater;

public class Support extends Hero implements Healer{
	
	@Override
	public void heal(){
		System.out.println(name + "");
	}
	
//	public void heal(){
//		System.out.println(name + "对自己进行了治疗");
//	}
	public void heal(Hero h1){
		System.out.println(name + "为" + h1.name + "加血");
	}
	public void heal(Hero h1,int hp){
		System.out.println(name + "为" + h1.name + "加了" + hp + "的血量");
	}
	
	public static void main(String[] args) {
		Support pd = new Support();
		pd.name = "好心人";  //为什么会pd是子类 h1是用父类呢  因为他们是不同的对象啊
//		pd.hp = 500f; //在函数调用的时候直接复制就行
		
		Hero h1 = new Hero();
		h1.name = "piter";
		
		pd.heal();
		pd.heal(h1);
		pd.heal(h1, 200);
		
		
	}
	

}
