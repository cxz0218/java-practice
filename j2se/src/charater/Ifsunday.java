package charater;

import java.util.Scanner;

public class Ifsunday {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		
		System.out.println("今天是周几："+ num);
		
//		int b = (num ==7)? 1:0;
//		
//		if (b==1)
//		{
//			System.out.println("今天是周日！");
//		}
//		else{
//			System.out.println("今天是工作日");
//		}
		
		String status = num==7 ? "周日":"工作日";
		
		System.out.println("今天是" + status);
		
	}
}
