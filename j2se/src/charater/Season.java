package charater;

import java.util.Scanner;

public class Season {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int month = s.nextInt();
		
		System.out.println("请输入月份\n"+ month);
		
		switch(month){
			
		case 2:
		case 3:
		case 4:
			System.out.println("是春天啦");
			break;
		case 5:
		case 6:
		case 7:
			System.out.println("是夏天啦");
			break;
		case 8:
		case 9:
		case 10:
			System.out.println("是秋天啦");
			break;
		case 11:
		case 12:
		case 1:
			System.out.println("是冬天啦");
			break;
		default:
			System.out.println("这是个什么鬼？");
		}
		
		
	}
}


//次可以简写为定义一个season变量 每个season在最后输出