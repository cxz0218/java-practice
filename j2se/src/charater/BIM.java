package charater;

import java.util.Scanner;

public class BIM {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

        float height = s.nextFloat();
        
        System.out.println("��������ߣ�m����"+ height);
        
        float weight = s.nextFloat();
        
        System.out.println("���������أ�kg��"+ weight);
        
        float BIM = weight / (height * height);
        
        System.out.println("��ǰ��BIM�ǣ�"+ BIM);

        System.out.println("��ǰ����״̬�ǣ�");
        if(BIM < 18.5)
        	System.out.println("���ع���");
        else if(BIM < 24)
        	System.out.println("������Χ");
        else if(BIM < 27)
        	System.out.println("���ع���");
        else if(BIM < 30)
        	System.out.println("��ȷ���");
        else if (BIM < 35)
        	System.out.println("�жȷ���");
        else
        	System.out.println("�ضȷ���");
	}
}

// ���Զ���һ��status���ַ���������������Ϊ  System.out.println("����״̬��: " + status);