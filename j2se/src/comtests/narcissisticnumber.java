package comtests;

public class narcissisticnumber {
	public static void main(String[] args) {
		// 1. һ����3λ�� 100-999
		// 2. ÿһλ��������������ǡ�����������������153=1*1*1+5*5*5+3*3*3

		// Ѱ�����е�ˮ�ɻ���
		//�������
		int gewei = 1,shiwei = 1,baiwei = 1;

		
		//��ʼѭ�� ����
		
//		for(int i = 1;i <= 9;i++){
//			for(int j = 0;j <=9; j++){
//				for(int k = 0;k <=9; k++){
//					if((k + j * 10 + i * 100) == k * k * k + j * j * j + i * i *i){
//						baiwei = i;
//						shiwei = j;
//						gewei = k;
//						System.out.println(baiwei + "" + shiwei + "" + gewei);
//					}
//				}
//			}
//		}
		
		for(int i =100;i < 1000;i++){
			gewei = i % 10;
			baiwei = i / 100;
			shiwei = (i - baiwei * 100) /10;
			int result = gewei * gewei * gewei + baiwei * baiwei * baiwei + shiwei * shiwei * shiwei;
			if (i == result)
				System.out.println(i);
		}
		
		
	}
}
