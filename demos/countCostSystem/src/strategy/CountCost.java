package strategy;

/**
 * 统一管理车类型和管理费用
 * @author future
 *
 */
public abstract class CountCost {
	/**
	 * 显示当前使用车类型声明为abstract， 由子类实现
	 */
	public abstract void display();
	/**
	 * 组合一个策略对象，将计费行为代理给该对象实现
	 */
	private Price price;
	public void setCostType(Price price){
		this.price = price;
	}	
	public String cost(int path){
		 return price.countPrice(path);
	}
}
