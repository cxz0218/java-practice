package comtests;

import java.util.Arrays;
public class ScoreSort {
    
	   //完成 main 方法
	    public static void main(String[] args) {
	        
	       int[] scores = new int[]{89,-23,64,91,119,52,73};
	       System.out.println("开始成绩为:");
	       for( int each : scores){
	    	   System.out.print(each + "\t");
	       }
	       System.out.println();
	       
	       //排序
	       Arrays.sort(scores);
	       
	       //检查成绩是否有效
	       System.out.println("成绩前三名是:");
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
