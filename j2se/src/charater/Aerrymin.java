package charater;

//import java.util.Scanner;

public class Aerrymin {
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		int[] a = new int[5];
		
		//��ʼ��
		for(int i = 0;i < a.length;i++){
			//a[i] = s.nextInt();
			a[i] = (int)(Math.random()*100);
		}
		
		//�����Сֵ
		System.out.println("�����������ǣ�");
		for(int k = 0;k < a.length;k++)
			System.out.print(a[k] + " ");
		System.out.println();
			
		
//		// ����Сֵ
//		int min = 100;
//		for(int j = 0;j < a.length;j++){
//			if(a[j] < min)
//				min = a[j];
//		}
//		System.out.println("��Сֵ�ǣ�"+ min);
		
		//��ת����
//		int i = 0, j = a.length-1;
//		int value = a[i];
//		for(;i != a.length / 2 | j != a.length / 2;i++,j--){
//			a[i] = a[j];
//		}
//		a[a.length-1]=value;

//		
		
		for(int x = 0;x < a.length / 2;x++){
			int middle = a[a.length -1 - x];
			a[a.length -1 - x] = a[x];
			a[x] = middle;		
		}
		
		System.out.println("���������ǣ�");
		for(int k = 0;k < a.length;k++)
			System.out.print(a[k] + " ");
		System.out.println();
	}
}
