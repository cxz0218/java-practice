package Assignment;

public class BankAccount {
	protected float balance = 0 ;//定义余额
	protected  float rate;//定义利率

	
	//余额查询
	public float getBalance(){
		//System.out.println("账户余额为：" + balance);
		return balance;
	}
	
	//存款并计算余额
	public void deposit(float perInCapital){
		//	this.perCapital = perCapital;
		System.out.println("存入账户" + perInCapital + "元");
		balance += perInCapital;
		//sumCapital *= (1 + rate);
	}
	
	//取款
	public void withdrawl(float perOutCapital){
		System.out.println("从账户取款" + perOutCapital + "元");
		balance -= perOutCapital;
	}
	
	//设置利率
	public void setRate(float rate){
		this.rate = rate;
	}
	//查询利率
	public float searchRate(){
		return rate;
	}
}
