package impl;

import strategy.Price;

/**
 *  ����������۸�
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
