package comtests;
import java.util.Arrays;
public class Twoarray_sort {
	public static void main(String[] args) {
		
//		�ȰѶ�ά����ʹ��System.arraycopy�������鸴�Ƶ�һ��һά����
//		Ȼ��ʹ��sort��������
//		����ٸ��ƻص���ά����
//		int[][] a = new int[5][8];
//		
//		// ��ֵ
//		for(int i = 0;i < a.length;i++){
//			for(int j = 0;j < a[i].length;j++){
//				a[i][j] = (int) (Math.random()*100);
//			}
//		}
//		
//		//��ӡ��ά����
//		System.out.println("��ӡ��ά���飺");
//		for(int[] i : a){
//			System.out.println(Arrays.toString(i));
//		}
//		
//		// �Ѷ�ά���鸴�Ƶ�һά������
//		int b[] = new int [a.length*a[0].length];
//		for ( int i = 0;i < a.length;i++){
//			System.arraycopy(a[i], 0, b, i*a[i].length, a[i].length);
//		}
//		
//		//��һά�����������
//		Arrays.sort(b);
//		
//		// ��һά���鸴�Ƶ���ά����
//		 for (int i = 0;i < a.length;i++){ 
//			 System.arraycopy(b, a[i].length*i, a[i], 0, a[i].length);
//		 }
//		System.out.println("����֮��Ķ�ά�����ӡ��");
//		for (int[] i : a){
//			System.out.println(Arrays.toString(i));
//		}
//		
//		�ȰѶ�ά����ʹ��System.arraycopy�������鸴�Ƶ�һ��һά����
//		Ȼ��ʹ��sort��������
//		����ٸ��ƻص���ά����
		int[][] a = new int[5][8];
		
		//��ֵ
		for (int i = 0;i < a.length ;i++){
			for (int j = 0;j <a[i].length;j++){
				a[i][j] = (int) (Math.random()*100); 
			}
		}
			
		//��ӡ����
		for (int[] i : a){
				System.out.println(Arrays.toString(i));
		}

		//���Ƶ�ʱ����һ���Ը���һ�����飬�ı�b����ÿ�α����ƵĿ�ʼλ��
		int[] b = new int[a.length*a[0].length];
		for (int i = 0;i < a.length;i++){  //��ôa[i]�����ŵ�i�е�
				System.arraycopy(a[i], 0, b, i*a[i].length, a[i].length);
		}//i*a[i].length����Ϊ�������ܹ�������������һλ�����ж�ά����ÿ�е���ʵλ��... �о���Ϊ��i*a[i -1].length���ӷ���ʵ����
		//a[i -1] ���� ��Ϊ��������I= -1��ȡֵ��
		
		//�����
		Arrays.sort(b);
		
		//��һά���鸴�Ƴɶ�ά���ְ�
		for (int i = 0;i < a.length;i++){
			System.arraycopy(b, i*a[i].length, a[i], 0, a[i].length);//ֻҪȷ���˸��Ƶ���ʼλ�úͽ���λ�� �ټ��ϳ��ȾͿ��԰�һλ���鸴�Ƶ���ά�����а�
		}
		
		//��ӡ
		System.out.println("����֮������飺");
		for (int[] i : a){ // i ������һ���������
			System.out.println(Arrays.toString(i));
		}
	}
	
 }
