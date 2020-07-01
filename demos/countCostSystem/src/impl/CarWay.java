package impl;

import strategy.Price;

/**
 *  小汽车计算价格
 *  
 * @author future
 *
 */
public class CarWay implements Price {

	@Override
	public String countPrice( int path) {
		// TODO Auto-generated method stub
		return 3*path+5 +  "";
	}

}
