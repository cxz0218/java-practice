package charater;

public class MagicPotion extends Item {
	
	@Override
	public void effect (){
		 System.out.println("蓝瓶使用后，可以回魔法");
	}
	
	public static void main(String[] args) {
		Item ad = new Item();
		ad.effect();
		
		MagicPotion sg = new MagicPotion();
		sg.effect();
	}
}
