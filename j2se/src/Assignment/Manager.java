package Assignment;

public class Manager extends Employee {

	private double bonus = 12;	
	public Manager(int ID, String name) {
		super(ID, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMonthlyPay() {
		// TODO Auto-generated method stub
		return salary + bonus;
	}
	
	public static void main(String[] args) {
		//System.out.println( getMonthlyPay());
	}
}
