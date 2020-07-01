package sort;

import java.util.Scanner;
public class Hailstone {

	//给定任意自然数n，求解H（n）序列的峰值。

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] str = new int[100];//用数组来存储Hailstone序列
		System.out.println("输入自然数n：");
		int n = s.nextInt();

	
		str [0] = n;//将第一次输入的n值存入数组
		int i = 0;
		do{
			if(0 == n % 2){
				n /= 2;
			}
			else {
				n = 3*n + 1;
			}
			str[i++] = n;
		}while( 1 != n);
		str[i+1] = 1;
		
		System.out.println("H（n）序列的峰值的峰值是：" + maxvalue(str));
		
	}
	
	//求出最大值
	public static int maxvalue (int[] str){
		int max = -1;
		for (int each : str){
			if(each > max)
				max = each;
		}
		
		return max;
	}
}
