package Assignment;

public class SalesEmployee extends Employee {
	
	private double profit = 100;
	public SalesEmployee(int ID, String name) {
		super(ID, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		return name;	
	}
	
	@Override
	public double getMonthlyPay() {
		// TODO Auto-generated method stub
		return salary + (profit * 0.2);
	}
	public static void main(String[] args) {
		Employee one = new SalesEmployee(1,"Gery");
		//one.name = "rt";
		System.out.println(one);
		System.out.println("雇员的编号是："+ compareTo(one));
		System.out.println("雇员的姓名是：" + one.toString());
		System.out.println(one.getMonthlyPay());
	}



}
