package comtests;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Cutpoint {
	public static void main(String[] args) {
//		float points=0.618f;
//		float minDiff = 1000;//离黄金分割点的差值
//		int range = 20;/*最好不要出现直接出现的数字*/
//		int answerFenzi = 0,answerFenmu = 0;
//		int i ,j;
//		for(i = 1;i <= range;i++){
//			for (j = 1 ;j <= range;j++){
//			
//				// 分子和分母不能同时是偶数
//				if(0 == i % 2 & 0 == j % 2)
//					continue;
//				
//				//取值
//				float value = (float)i / j;
//				
//				//计算差值
//				float differ = value - points;
//				
//				//取绝对值
//				differ = differ > 0 ? differ : 0 - differ;
//				//判断谁是最小的数
//				if(differ < minDiff){
//					minDiff = differ;
//					answerFenzi = i;
//					answerFenmu = j;
//				}
//					
//			}
//
//		}
//		System.out.println("离黄金分割点（" + points +
//				"）最近的两个数相除是：" + answerFenzi + "/" + answerFenmu + "=" + 
//				((float) answerFenzi / answerFenmu));
//
		//寻找某两个数相除，其结果 离黄金分割点 0.618最近
//		分母和分子不能同时为偶数
//		分母和分子 取值范围在[1-20]
		//step1 把数值设置成固定变量
		float points = 0.618f;
		int range = 20;
		
		//
		int answerFenzi = 1;
		int answerFenmu = 1;
		float minDiffer = 100;
		
		//开始遍历
		for(int fenzi = 1;fenzi <= range; fenzi++){
			for(int fenmu = 1;fenmu <= range; fenmu++){
				//剔除一些条件
				if(0 == fenzi % 2 & 0 == fenmu % 2)
					continue;
				
				//计算比值
				float value = (float) fenzi / fenmu;
				
				//计算差值
				float differ = value - points;
				
				//计算差值的绝对值
				
				differ = differ <0 ? 0 - differ : differ;
				
				//判断谁是最小值
				if(minDiffer > differ)
				{
					minDiffer = differ;
					answerFenzi = fenzi;
					answerFenmu = fenmu;
				}
			}
		}
		System.out.println("离黄金分割点（"+ points +"）最近的两个数相除是："
		+ answerFenzi + "/" + answerFenmu + "=" + ((float) answerFenzi / answerFenmu));
//		
//		System.out.println("离黄金分割点（"+ points +"）最近的两个数相除是："
//	+ ( (answerFenzi / answerFenmu ) = ((float) answerFenzi / answerFenmu)));
	}
		
	}
