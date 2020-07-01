package digit;
import java.util.Date;
//public class TestString1 {
//
//	public static boolean found = false;
//	public static void main(String[] args) {
//		String password = randomString(3);
//		System.out.println("密码是:" + password);
//		
//		char[] guessPassword = new char[password.length()];
//		generatePasswords(guessPassword,0,password);
//	}
//	
//	// 生成密码
//
////递归
//	private static void generatePasswords(char[] guessPassword ,int index ,String password){
//		if(found)
//			return;//跳出此次的递归
//		for(short i = '0';i <= 'z';i++){
//			char c = (char) i;
//			if(!Character.isLetterOrDigit(c))
//				continue;
//			guessPassword[index] = c;
//			
//			//数组长度到了
//			if(index != guessPassword.length - 1)
//				generatePasswords(guessPassword,index + 1,password);
//			else{
//				String guess = new String(guessPassword);
//				if(guess.equals(password))
//				{
//					System.out.println("找到了，密码是:" + guess);
//					found = true;
//					return;
//				}
//			}
//		}
//	}
//		
//	    private static String randomString(int length) {
//	        String pool = "";
//	        for (short i = '0'; i <= '9'; i++) {
//	            pool += (char) i;
//	        }
//	        for (short i = 'a'; i <= 'z'; i++) {
//	            pool += (char) i;
//	        }
//	        for (short i = 'A'; i <= 'Z'; i++) {
//	            pool += (char) i;
//	        }
//	        char cs[] = new char[length];
//	        for (int i = 0; i < cs.length; i++) {
//	            int index = (int) (Math.random() * pool.length());
//	            cs[i] = pool.charAt(index);
//	        }
//	        String result = new String(cs);
//	        return result;
//	    }

	
//}

public class TestString1 {
    
//    public static void main(String[] args) {
//    
//        String sentence = "盖伦,在进行了连续8次击杀后,获得了超神 的称号";
//  
//        System.out.println(sentence.indexOf('8')); //字符第一次出现的位置
//          
//        System.out.println(sentence.indexOf("超神")); //字符串第一次出现的位置
//          
//        System.out.println(sentence.lastIndexOf("了")); //字符串最后出现的位置
//          
//        System.out.println(sentence.indexOf(',',5)); //从位置5开始，出现的第一次,的位置
//          
//        System.out.println(sentence.contains("击杀")); //是否包含字符串"击杀"
//          
//    }
	
	//修改特定位置上的字母
//    public static void main(String[] args) {
//        // 把最后一个two单词首字母大写
//        String s = "Nature has given us that two ears,two eyes, and but one tongue, to the end that we should hear and see more than we speak";
//        int index = s.lastIndexOf(" two ");
//         
//        System.out.println(index);
//        char[] cs = s.toCharArray();
//        System.out.println(cs[35]);
//        System.out.println(cs[index]);
//        cs[index] = Character.toUpperCase(cs[index]);
//        String result = new String(cs);
//        System.out.printf(result);
//    } 
    
    
    //测试字符串是否同一对象
//    public static void main(String[] args) {
//        String str1 = "the light";
//        String str3 = "the light";
//        System.out.println( str1  ==  str3);
//    }
	
	//测试StringBuffer类
	public static void main(String[] args) {
	    
//	    String str1 = "the";
//	    
//	    StringBuffer sb = new StringBuffer(str1);
//	    System.out.println(sb.length()); //内容长度
//        
//       System.out.println(sb.capacity());//总空间
       
       // 当前时间
       Date d1 = new Date();
       System.out.println("当前时间:");
       System.out.println(d1);
       System.out.println();
       // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
       Date d2 = new Date(5000);
       System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
       System.out.println(d2);
	}
}
