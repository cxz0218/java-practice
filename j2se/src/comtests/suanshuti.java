package comtests;

public class suanshuti {
	public static void main(String[] args) {
		
//		for(int i = 0;i <= 8;i++){
//			for( int j = 0 ;j <= 8;j++){
//				for(int k = 0 ;k <= 10;k++){
//					for(int x = 0;x <=14 ;x++){
//						if((8 == i + j) && (6 == x -k) && (10 == j + k) && (14 == x + i)){
//							System.out.println("i:" +i);
//							System.out.println("j:" +j);
//							System.out.println("k:" +k);
//							System.out.println("x:" +x);
//						}
//							
//					}
//				}
//			}
//		}
		
	       int moneyEachDay = 0;
	        int day = 10;
	        int sum=0;
	        for (int i = 1; i <= day; i++) {
	            if(0==moneyEachDay)
	                moneyEachDay = 1;
	            else
	                moneyEachDay *= 2;
	              
	            sum+=moneyEachDay;
	              
	            System.out.println(i + " 天之后，洪帮主手中的钱总数是: " + sum );
	        }
	    }
	}
