package Experiment;
import java.util.Scanner;
/**
 * Fibonacci数列
 * Fibonacci数列的定义为： F1=F2=1，Fn=Fn-1+Fn-2(n＞=3) 
 * 控制台随意输入一个数字n，回车，在控制台打印出数列F1, F2,…Fn
 * @author future
 *
 */
public class Assignment1 {
//计算Fibonacci数列
	protected static int  Fibonacci(int n){
		if(n < 1){
			System.out.println("您输入数字小于0，请重新输入");//如果输入的数字小于1，则重新输入	
			return -1;
		}			
		else if(1 == n || 2 == n)//当n=1，2时，Fn=1
			return 1;
		else{
			return Fibonacci(n-1) + Fibonacci(n-2);//当n>2时，Fn=Fn-1+Fn-2
		}
	}
	//当输入有误，需要重新输入
	public static boolean  Reinput() {
		Scanner s = new Scanner(System.in);
		System.out.printf("请输入数字n：");
		int n = s.nextInt();
		if(-1 == Fibonacci(n)){
			return false;//如果输入的数字有误，返回false
		}else{
			System.out.println("Fibonacci数列:");
			for(int i = 1;i <= n ;i ++){
				System.out.printf(Fibonacci(i) + "\t");	
			}
			return true;
		}
		
	}

	public static void main(String[] args) {
		int count = 0;//用count来记录输入错误
		if(!Reinput()){
			//输入有误，则重新输入	.
			Reinput();
		}
	}
}


