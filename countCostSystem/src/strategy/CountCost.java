package strategy;

/**
 * ͳһ�������ͺ͹������
 * @author future
 *
 */
public abstract class CountCost {
	/**
	 * ��ʾ��ǰʹ�ó���������Ϊabstract�� ������ʵ��
	 */
	public abstract void display();
	/**
	 * ���һ�����Զ��󣬽��Ʒ���Ϊ������ö���ʵ��
	 */
	private Price price;
	public void setCostType(Price price){
		this.price = price;
	}	
	public String cost(int path){
		 return price.countPrice(path);
	}
}
