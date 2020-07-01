package comtests;

public class Mergearray {
	public static void main(String[] args) {
		int[] a = new int[(int) (Math.random()*5) + 5];
		int[] b = new int[(int) (Math.random()*5) + 5];
		int[] c = new int[a.length + b.length];
		
		for (int i = 0;i < a.length - 1;i++){
			a[i] = (int) (Math.random()*100);
		}

		//数组a的内容是
		System.out.println("数组a的内容是：");
		for (int each : a){
			System.out.print(each +" ");
		}
		System.out.println();
		for (int i = 0;i < b.length - 1;i++){
			 b[i] = (int)(Math.random()*100);
		}
		
		//数组b的内容是
		System.out.println("数组b的内容是：");
		for (int each : b){
			System.out.print(each +" ");
		}
		System.out.println();
		
		//复制
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		
		//遍历结果
		//数组b的内容是
		System.out.println("数组c的内容是：");
		for (int each : c){
			System.out.print(each +" ");
		}
	}
}
