package Assignment;

public class UseAccount extends BankAccount {
	private float perInCapital; //每次存款的金额
	private float perOutCapital;//每次取款的金额
	
	public static void main(String[] args) {
		UseAccount lili = new UseAccount();//实例化一个对象
		
		//设置并查询利率
		lili.setRate(0.2f);
		System.out.println("银行利率是" + lili.searchRate());
		
		//存款取款查询余额
		lili.deposit(50);
		lili.deposit(120);
		System.out.println("账户余额是：" + lili.getBalance());
		lili.withdrawl(100);
		System.out.println("账户余额是：" + lili.getBalance());
	}
}
/*考虑数据的，以及数据的类型。*/