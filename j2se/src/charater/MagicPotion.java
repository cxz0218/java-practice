package charater;

public class MagicPotion extends Item {
	
	@Override
	public void effect (){
		 System.out.println("��ƿʹ�ú󣬿��Ի�ħ��");
	}
	
	public static void main(String[] args) {
		Item ad = new Item();
		ad.effect();
		
		MagicPotion sg = new MagicPotion();
		sg.effect();
	}
}
