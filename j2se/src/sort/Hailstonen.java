package sort;
import java.util.Scanner;
public class Hailstonen {
	//����������Ȼ��n�����H��n�����еķ�ֵ��

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int[] str = new int[100];//���������洢Hailstone����
			System.out.println("������Ȼ��n��");
			int n = s.nextInt();
			
			//int maxValue = hailstone(n);
			
			System.out.println(hailstone(n));
			
		}
		
		//������ֵ
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
			         * <���ʽ1>?<���ʽ2>:<���ʽ3>
			         * �������У����ȶԵ�һ�����ʽ���м��飬
			         * ���Ϊ�棬�򷵻ر��ʽ2��ֵ��
			         * ���Ϊ�٣��򷵻ر��ʽ3��ֵ��
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
