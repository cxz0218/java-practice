package comtests;

public class Mergearray {
	public static void main(String[] args) {
		int[] a = new int[(int) (Math.random()*5) + 5];
		int[] b = new int[(int) (Math.random()*5) + 5];
		int[] c = new int[a.length + b.length];
		
		for (int i = 0;i < a.length - 1;i++){
			a[i] = (int) (Math.random()*100);
		}

		//����a��������
		System.out.println("����a�������ǣ�");
		for (int each : a){
			System.out.print(each +" ");
		}
		System.out.println();
		for (int i = 0;i < b.length - 1;i++){
			 b[i] = (int)(Math.random()*100);
		}
		
		//����b��������
		System.out.println("����b�������ǣ�");
		for (int each : b){
			System.out.print(each +" ");
		}
		System.out.println();
		
		//����
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		
		//�������
		//����b��������
		System.out.println("����c�������ǣ�");
		for (int each : c){
			System.out.print(each +" ");
		}
	}
}
