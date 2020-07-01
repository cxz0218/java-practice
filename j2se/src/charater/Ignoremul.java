package charater;

//public class Ignoremul {
//	public static void main(String[] args) {
//		int i;
//		for(i = 1;i <=100;i++){
//			if(i%3==0 ||i%5==0)
//				continue;
//			System.out.println(i);
//		}
//	}
//}


public class Ignoremul {
    public static void main(String[] args) {
          
        //打印单数    
        for (int j = 0; j < 10; j++) {
            if(0==j%2) 
                break; //如果是双数，直接结束循环
             
            System.out.println(j);
        }
    }
}