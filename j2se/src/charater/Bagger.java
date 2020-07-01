package charater;

public class Bagger {

	public static void main(String[] args) {
		int sum = 0,sub=1;
		int i;
		for(i=1;i<11;i++){
			
			sum+=sub;
			sub=2*sub;
			
		}
		System.out.println("ÊÕÈëÊÇ£º"+ sum);
	}
}
