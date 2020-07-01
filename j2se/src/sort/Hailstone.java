package sort;

import java.util.Scanner;
public class Hailstone {

	//����������Ȼ��n�����H��n�����еķ�ֵ��

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] str = new int[100];//���������洢Hailstone����
		System.out.println("������Ȼ��n��");
		int n = s.nextInt();

	
		str [0] = n;//����һ�������nֵ��������
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
		
		System.out.println("H��n�����еķ�ֵ�ķ�ֵ�ǣ�" + maxvalue(str));
		
	}
	
	//������ֵ
	public static int maxvalue (int[] str){
		int max = -1;
		for (int each : str){
			if(each > max)
				max = each;
		}
		
		return max;
	}
}
