package impl;

import strategy.Price;

/**
 *  С��������۸�
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
