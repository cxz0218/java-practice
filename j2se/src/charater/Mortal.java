package charater;

public interface Mortal {
	public void die();
	
	//Ĭ�Ϸ���
	default public void revive() {
		System.out.println("��Ӣ�۸�����");
	}
	
}
