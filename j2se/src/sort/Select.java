package sort;

public class Select {
	public static void main(String[] args) {
		int[] a = new int[5];
		
		//��ֵ
		for(int i =0;i < a.length; i++){
			a[i] = (int)(Math.random()*100);
		}
		
		//�������֮ǰ������
		System.out.println("����֮ǰ�������ǣ�");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		//ѡ��������
		for(int j = 0;j <a.length-1;j++){    //��ֻʣ��һ������ʱ��Ͳ���Ҫ�Ƚ��ˣ���˱�����Χ [0 - length-2]
			for(int i = j+1; i < a.length;i++){  //ÿ����ֵa[i]��Ҫ[i+1 , length-1] �����Ƚ�
				if(a[i] < a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}	
			}
		}
		
		//������֮�������
		System.out.println("����֮��������ǣ�");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		//ð��
		for(int j = a.length - 1;j > 0;j--){
			for(int i = 0;i < j;i ++){
				if(a[i] < a[i+1]){
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		
		//������֮�������
		System.out.println("����֮��������ǣ�");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
