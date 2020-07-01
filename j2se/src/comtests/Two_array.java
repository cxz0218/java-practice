package comtests;

public class Two_array {
	public static void main(String[] args) {
		
		//初始化二维数组
		int[][] a = new int[5][5];//有两个一维数组，每个一维数组的长度是3
		int x = 0;
		int y = 0;
		
		for (int i = 0;i < a.length;i++){
			for(int j = 0;j < a[i].length;j++){
				a[i][j] = (int) (Math.random()*100);
			}
		}
		//打印这个数组
		System.out.println("二维数组是：");
		for (int[] row : a){
			for (int each : row){
				System.out.print(each + "\t");
			}
			System.out.println();
		}
		//找出最大数
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
		
		System.out.println("最大数是：" + max);
		System.out.println("其坐标是["+ x +"]["+ y + "]");
		

	}
}
