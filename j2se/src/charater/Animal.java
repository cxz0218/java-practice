package charater;

public abstract class Animal {

	protected int legs;//��¼�����ȵ���Ŀ
	
	protected  Animal(int legs){ //��ʼ��legs����
		this.legs = legs;
	}
	
	public abstract  void eat();
	
	public void walk (){
		System.out.println( "��" + legs + "������·");
	}
}
