package sort;

public class Bubber {
	public static void main(String[] args) {
		int[] a = new int[20];
		
		//赋值
		for(int i =0;i < a.length; i++){
			a[i] = (int)(Math.random()*100);
		}
		
		//输出排序之前的数组
		System.out.println("排序之前的数组是：");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		//冒泡排序
		for( int j = a.length - 1;j > 0; j--){ //外层遍历是用来记录j值的，j值是从L-2 - 1的
			for( int i = 0; i < j ;i++){ //每一次遍历的时候从a[i]是从0 - l-2的
				if(a[i] > a[i+1]){  //与相邻的数开始比较
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		
		//排序之前的数组
		System.out.println("排序之后的数组是：");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
