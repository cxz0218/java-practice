package charater;

public class Support extends Hero implements Healer{
	
	@Override
	public void heal(){
		System.out.println(name + "");
	}
	
//	public void heal(){
//		System.out.println(name + "���Լ�����������");
//	}
	public void heal(Hero h1){
		System.out.println(name + "Ϊ" + h1.name + "��Ѫ");
	}
	public void heal(Hero h1,int hp){
		System.out.println(name + "Ϊ" + h1.name + "����" + hp + "��Ѫ��");
	}
	
	public static void main(String[] args) {
		Support pd = new Support();
		pd.name = "������";  //Ϊʲô��pd������ h1���ø�����  ��Ϊ�����ǲ�ͬ�Ķ���
//		pd.hp = 500f; //�ں������õ�ʱ��ֱ�Ӹ��ƾ���
		
		Hero h1 = new Hero();
		h1.name = "piter";
		
		pd.heal();
		pd.heal(h1);
		pd.heal(h1, 200);
		
		
	}
	

}
