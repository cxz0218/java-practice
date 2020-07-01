package Assignment;

public abstract class Employee {
	protected static int ID;
	protected String name;
	protected double salary;
	
	public Employee(int ID,String name){
		this.ID = ID;
		this.name = name;
	}
	
	public String toString(){
		return name;	
	}
	//
	public static int compareTo (Object o){
		return ID;	
	}
	
	//每月的支付
	public abstract double getMonthlyPay();

}
