package strategy;

public class TestCarCost {

	public static void main(String[] args) {
		System.out.println("测试计费程序");
		System.out.println("************************");
		CountCost countCost = null;
		countCost = new CarCost();
		countCost.display();
		System.out.println("此次打车费用为" + countCost.cost(5) + "元。");
		System.out.println("************************");
		System.out.println("测试完毕");
	}
}
