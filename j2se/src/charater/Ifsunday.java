package charater;

import java.util.Scanner;

public class Ifsunday {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		
		System.out.println("�������ܼ���"+ num);
		
//		int b = (num ==7)? 1:0;
//		
//		if (b==1)
//		{
//			System.out.println("���������գ�");
//		}
//		else{
//			System.out.println("�����ǹ�����");
//		}
		
		String status = num==7 ? "����":"������";
		
		System.out.println("������" + status);
		
	}
}
