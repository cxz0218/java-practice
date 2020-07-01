package sort;
import java.util.Scanner;
public class Hailstonen {
	//给定任意自然数n，求解H（n）序列的峰值。

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int[] str = new int[100];//用数组来存储Hailstone序列
			System.out.println("输入自然数n：");
			int n = s.nextInt();
			
			//int maxValue = hailstone(n);
			
			System.out.println(hailstone(n));
			
		}
		
		//求出最大值
		public static int hailstone (int n){
			 int maxValue = 0;
			    while(n > 1)
			    {
			         System.out.printf(n + "\t");
			         if(1 == n % 2){
			        	 n=(3*n+1) ;
			         }
			         else{
			        	 n=(n/2);
			         }
				    // (n % 2) ? n=(3*n+1) : n=(n/2);
			        /*
			         * <表达式1>?<表达式2>:<表达式3>
			         * 在运算中，首先对第一个表达式进行检验，
			         * 如果为真，则返回表达式2的值；
			         * 如果为假，则返回表达式3的值。
			         *
			         * */
			         if (n > maxValue)
			         {
			             maxValue = n;
			         }
			         //length++;
			    }
			    return maxValue;
		
		}
}
