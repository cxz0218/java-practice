package comtests;

public class Two_array {
	public static void main(String[] args) {
		
		//��ʼ����ά����
		int[][] a = new int[5][5];//������һά���飬ÿ��һά����ĳ�����3
		int x = 0;
		int y = 0;
		
		for (int i = 0;i < a.length;i++){
			for(int j = 0;j < a[i].length;j++){
				a[i][j] = (int) (Math.random()*100);
			}
		}
		//��ӡ�������
		System.out.println("��ά�����ǣ�");
		for (int[] row : a){
			for (int each : row){
				System.out.print(each + "\t");
			}
			System.out.println();
		}
		//�ҳ������
		int max = -1;
		for (int i = 0;i < 5;i++){
			for(int j = 0;j < 5;j++){
				if (a[i][j] > max){
					max = a[i][j];
					 x = i;
					 y = j;
				}
					
			}
		}
		
		System.out.println("������ǣ�" + max);
		System.out.println("��������["+ x +"]["+ y + "]");
		

	}
}
