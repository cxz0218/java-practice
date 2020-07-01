package sort;

public class Select {
	public static void main(String[] args) {
		int[] a = new int[5];
		
		//赋值
		for(int i =0;i < a.length; i++){
			a[i] = (int)(Math.random()*100);
		}
		
		//输出排序之前的数组
		System.out.println("排序之前的数组是：");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		//选择正排序
		for(int j = 0;j <a.length-1;j++){    //当只剩下一个数的时候就不需要比较了，因此遍历范围 [0 - length-2]
			for(int i = j+1; i < a.length;i++){  //每个数值a[i]都要[i+1 , length-1] 的数比较
				if(a[i] < a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}	
			}
		}
		
		//正排序之后的数组
		System.out.println("排序之后的数组是：");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		//冒泡
		for(int j = a.length - 1;j > 0;j--){
			for(int i = 0;i < j;i ++){
				if(a[i] < a[i+1]){
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		
		//到排序之后的数组
		System.out.println("排序之后的数组是：");
		for(int i = 0;i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
