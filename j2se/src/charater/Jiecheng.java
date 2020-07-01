package charater;

import java.util.Scanner;

public class Jiecheng {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int jiechen = s.nextInt();
		int i=1;
		int result=1;
//		while(i<=jiechen){
//			result*=i;
//			i++;
//		}
		do{
			result*=i;
			i++;
		}while(i<=jiechen);
		System.out.println( jiechen +"µÄ½×³ËÊÇ£º"+ result);
	}
}
