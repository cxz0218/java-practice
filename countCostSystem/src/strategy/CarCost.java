package strategy;

import impl.CarWay;

public class CarCost extends CountCost {
	
	public CarCost() {
		super.setCostType(new CarWay());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("������ʹ�õ���С����");
	}
}
