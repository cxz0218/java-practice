package sort;

public class Bubber {
	public static void main(String[] args) {
		int[] a = new int[20];
		
		//��ֵ
		for(int i =0;i < a.length; i++){
			a[i] = (int)(Math.random()*100);
		}
		
		//�������֮ǰ������
		System.out.println("����֮ǰ�������ǣ�");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		//ð������
		for( int j = a.length - 1;j > 0; j--){ //��������������¼jֵ�ģ�jֵ�Ǵ�L-2 - 1��
			for( int i = 0; i < j ;i++){ //ÿһ�α�����ʱ���a[i]�Ǵ�0 - l-2��
				if(a[i] > a[i+1]){  //�����ڵ�����ʼ�Ƚ�
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		
		//����֮ǰ������
		System.out.println("����֮��������ǣ�");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
