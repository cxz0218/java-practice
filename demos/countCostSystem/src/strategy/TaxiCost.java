package strategy;

import impl.TaxiWay;

public class TaxiCost extends CountCost {
	
	public TaxiCost() {
		super.setCostType(new TaxiWay());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("����ʾʹ�õ��ǳ��⳵��");
	}
}
