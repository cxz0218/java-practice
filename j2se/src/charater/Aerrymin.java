package charater;

//import java.util.Scanner;

public class Aerrymin {
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		int[] a = new int[5];
		
		//初始化
		for(int i = 0;i < a.length;i++){
			//a[i] = s.nextInt();
			a[i] = (int)(Math.random()*100);
		}
		
		//输出最小值
		System.out.println("数组的随机数是：");
		for(int k = 0;k < a.length;k++)
			System.out.print(a[k] + " ");
		System.out.println();
			
		
//		// 找最小值
//		int min = 100;
//		for(int j = 0;j < a.length;j++){
//			if(a[j] < min)
//				min = a[j];
//		}
//		System.out.println("最小值是："+ min);
		
		//反转数组
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
		
		System.out.println("数组逆数是：");
		for(int k = 0;k < a.length;k++)
			System.out.print(a[k] + " ");
		System.out.println();
	}
}
