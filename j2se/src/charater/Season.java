package charater;

import java.util.Scanner;

public class Season {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int month = s.nextInt();
		
		System.out.println("�������·�\n"+ month);
		
		switch(month){
			
		case 2:
		case 3:
		case 4:
			System.out.println("�Ǵ�����");
			break;
		case 5:
		case 6:
		case 7:
			System.out.println("��������");
			break;
		case 8:
		case 9:
		case 10:
			System.out.println("��������");
			break;
		case 11:
		case 12:
		case 1:
			System.out.println("�Ƕ�����");
			break;
		default:
			System.out.println("���Ǹ�ʲô��");
		}
		
		
	}
}


//�ο��Լ�дΪ����һ��season���� ÿ��season��������