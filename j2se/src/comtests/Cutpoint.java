package comtests;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Cutpoint {
	public static void main(String[] args) {
//		float points=0.618f;
//		float minDiff = 1000;//��ƽ�ָ��Ĳ�ֵ
//		int range = 20;/*��ò�Ҫ����ֱ�ӳ��ֵ�����*/
//		int answerFenzi = 0,answerFenmu = 0;
//		int i ,j;
//		for(i = 1;i <= range;i++){
//			for (j = 1 ;j <= range;j++){
//			
//				// ���Ӻͷ�ĸ����ͬʱ��ż��
//				if(0 == i % 2 & 0 == j % 2)
//					continue;
//				
//				//ȡֵ
//				float value = (float)i / j;
//				
//				//�����ֵ
//				float differ = value - points;
//				
//				//ȡ����ֵ
//				differ = differ > 0 ? differ : 0 - differ;
//				//�ж�˭����С����
//				if(differ < minDiff){
//					minDiff = differ;
//					answerFenzi = i;
//					answerFenmu = j;
//				}
//					
//			}
//
//		}
//		System.out.println("��ƽ�ָ�㣨" + points +
//				"�����������������ǣ�" + answerFenzi + "/" + answerFenmu + "=" + 
//				((float) answerFenzi / answerFenmu));
//
		//Ѱ��ĳ��������������� ��ƽ�ָ�� 0.618���
//		��ĸ�ͷ��Ӳ���ͬʱΪż��
//		��ĸ�ͷ��� ȡֵ��Χ��[1-20]
		//step1 ����ֵ���óɹ̶�����
		float points = 0.618f;
		int range = 20;
		
		//
		int answerFenzi = 1;
		int answerFenmu = 1;
		float minDiffer = 100;
		
		//��ʼ����
		for(int fenzi = 1;fenzi <= range; fenzi++){
			for(int fenmu = 1;fenmu <= range; fenmu++){
				//�޳�һЩ����
				if(0 == fenzi % 2 & 0 == fenmu % 2)
					continue;
				
				//�����ֵ
				float value = (float) fenzi / fenmu;
				
				//�����ֵ
				float differ = value - points;
				
				//�����ֵ�ľ���ֵ
				
				differ = differ <0 ? 0 - differ : differ;
				
				//�ж�˭����Сֵ
				if(minDiffer > differ)
				{
					minDiffer = differ;
					answerFenzi = fenzi;
					answerFenmu = fenmu;
				}
			}
		}
		System.out.println("��ƽ�ָ�㣨"+ points +"�����������������ǣ�"
		+ answerFenzi + "/" + answerFenmu + "=" + ((float) answerFenzi / answerFenmu));
//		
//		System.out.println("��ƽ�ָ�㣨"+ points +"�����������������ǣ�"
//	+ ( (answerFenzi / answerFenmu ) = ((float) answerFenzi / answerFenmu)));
	}
		
	}
