package impl;

import strategy.Price;

/**
 *  公交车计算价格
 *  
 * @author future
 *
 */
public class BusWay implements Price {

	@Override
	public String countPrice(int path) {
		// TODO Auto-generated method stub
		return path*2+"";
	}

}
