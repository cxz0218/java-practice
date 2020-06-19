package strategy;

import impl.TaxiWay;

public class TaxiCost extends CountCost {
	
	public TaxiCost() {
		super.setCostType(new TaxiWay());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("您显示使用的是出租车。");
	}
}
