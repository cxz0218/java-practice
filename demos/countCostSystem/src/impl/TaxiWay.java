package impl;

import strategy.Price;
/**
 *  出租车计算价格
 *  
 * @author future
 *
 */
public class TaxiWay implements Price {

	@Override
	public String countPrice(int path) {
		// TODO Auto-generated method stub
		return 2*path+5 +  "";
	}

}
