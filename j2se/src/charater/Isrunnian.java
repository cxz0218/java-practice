package charater;

import java.util.Scanner;

public class Isrunnian {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int year = s.nextInt();
		System.out.println("���������\n"+ year);
		
		if(year%4==0 & year%100!=0)
			System.out.println(year + "������");
		else
			System.out.println(year + "��������");
			
	}
	
	
}
