package strategy;

public class TestCarCost {

	public static void main(String[] args) {
		System.out.println("���ԼƷѳ���");
		System.out.println("************************");
		CountCost countCost = null;
		countCost = new CarCost();
		countCost.display();
		System.out.println("�˴δ򳵷���Ϊ" + countCost.cost(5) + "Ԫ��");
		System.out.println("************************");
		System.out.println("�������");
	}
}
