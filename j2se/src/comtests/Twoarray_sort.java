package comtests;
import java.util.Arrays;
public class Twoarray_sort {
	public static void main(String[] args) {
		
//		先把二维数组使用System.arraycopy进行数组复制到一个一维数组
//		然后使用sort进行排序
//		最后再复制回到二维数组
//		int[][] a = new int[5][8];
//		
//		// 赋值
//		for(int i = 0;i < a.length;i++){
//			for(int j = 0;j < a[i].length;j++){
//				a[i][j] = (int) (Math.random()*100);
//			}
//		}
//		
//		//打印二维数组
//		System.out.println("打印二维数组：");
//		for(int[] i : a){
//			System.out.println(Arrays.toString(i));
//		}
//		
//		// 把二维数组复制到一维数组中
//		int b[] = new int [a.length*a[0].length];
//		for ( int i = 0;i < a.length;i++){
//			System.arraycopy(a[i], 0, b, i*a[i].length, a[i].length);
//		}
//		
//		//对一维数组进行排序
//		Arrays.sort(b);
//		
//		// 把一维数组复制到二维数组
//		 for (int i = 0;i < a.length;i++){ 
//			 System.arraycopy(b, a[i].length*i, a[i], 0, a[i].length);
//		 }
//		System.out.println("排序之后的二维数组打印：");
//		for (int[] i : a){
//			System.out.println(Arrays.toString(i));
//		}
//		
//		先把二维数组使用System.arraycopy进行数组复制到一个一维数组
//		然后使用sort进行排序
//		最后再复制回到二维数组
		int[][] a = new int[5][8];
		
		//赋值
		for (int i = 0;i < a.length ;i++){
			for (int j = 0;j <a[i].length;j++){
				a[i][j] = (int) (Math.random()*100); 
			}
		}
			
		//打印数组
		for (int[] i : a){
				System.out.println(Arrays.toString(i));
		}

		//复制的时候是一次性复制一个数组，改变b数组每次被复制的开始位置
		int[] b = new int[a.length*a[0].length];
		for (int i = 0;i < a.length;i++){  //那么a[i]代表着第i行的
				System.arraycopy(a[i], 0, b, i*a[i].length, a[i].length);
		}//i*a[i].length是因为这个数组很规整，代表着在一位数组中二维数组每行的其实位置... 感觉改为了i*a[i -1].length更加符合实际诶
		//a[i -1] 不行 因为这样会有I= -1的取值。
		
		//排序吧
		Arrays.sort(b);
		
		//把一维数组复制成二维数字吧
		for (int i = 0;i < a.length;i++){
			System.arraycopy(b, i*a[i].length, a[i], 0, a[i].length);//只要确定了复制的起始位置和接受位置 再加上长度就可以把一位数组复制到二维数字中吧
		}
		
		//打印
		System.out.println("排序之后的数组：");
		for (int[] i : a){ // i 这里是一个数组变量
			System.out.println(Arrays.toString(i));
		}
	}
	
 }
