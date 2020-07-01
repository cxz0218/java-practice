package Experiment;

import java.util.Scanner;
/**
 * 冒泡法排序(从小到大) 
 * 冒泡法排序对相邻的两个元素进行比较，并把小的元素交到前面 。
 * 要求：
 * 从控制台输入十个数字，并在控制台打印由小到大的数字序列
 * @author future
 *
 */
public class Assignment2 {
	
	//冒泡排序。
	//冒泡法排序对相邻的两个元素进行比较，并把小的元素交到前面 。
	protected static void BubbleSort(int str[]){
		for( int j = str.length - 1;j > 0; j--){ 
			for( int i = 0; i < j ;i++){ 
				if(str[i] > str[i+1]){  //当后者比前者小的时候，两个交换位置
					int temp = str[i];
					str[i] = str[i+1];
					str[i+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] str = new int[10];//定义一个数组用来存贮10个数字
		System.out.println("请输入10个数");
		
		for(int i = 0 ;i < str.length ; i ++){
			str[i] = s.nextInt();
		}
		
		//打印未排序的数组：
		System.out.println("未排序的数组：");
		for( int each : str){
			System.out.printf(each + "\t");
		}
		System.out.println();
		
		BubbleSort(str);
		
		//打印排序后的数组：
		System.out.println("排序后的数组：");
		for( int each : str){
			System.out.printf(each + "\t");
		}
		System.out.println();
	}
}
