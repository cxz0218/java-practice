package strategy;

import impl.BusWay;

public class BusCost extends CountCost {
	
	public BusCost() {
		super.setCostType(new BusWay());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("������ʹ�õ��ǹ�������");
	}
}
