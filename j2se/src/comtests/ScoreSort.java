package comtests;

import java.util.Arrays;
public class ScoreSort {
    
	   //��� main ����
	    public static void main(String[] args) {
	        
	       int[] scores = new int[]{89,-23,64,91,119,52,73};
	       System.out.println("��ʼ�ɼ�Ϊ:");
	       for( int each : scores){
	    	   System.out.print(each + "\t");
	       }
	       System.out.println();
	       
	       //����
	       Arrays.sort(scores);
	       
	       //���ɼ��Ƿ���Ч
	       System.out.println("�ɼ�ǰ������:");
	       int valueCount = 0;
	       for(int i = scores.length - 1;i >= 0;i--){
	    	   if(scores[i] < 0 || scores[i] > 100)
	    		   continue;
	    	   else{
	    		   
	    	   }
	    	   valueCount++;
	    	   System.out.print(scores[i] + "\t");
	    	   if(3 == valueCount)
	    		   break;
	    	   
	       }
	        
	       
	       
	    }
	    
}
