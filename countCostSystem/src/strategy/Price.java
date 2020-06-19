package strategy;
/**
 * 计算价格
 * 
 * @author future
 *
 */
public  interface Price {

	/**
	 *返回计算后的价格
	 * @param path
	 * @return
	 */
	String countPrice(int path);
}
