package charater;

public class TestString {
//    public static void main(String[] args) {
//        String garen ="¸ÇÂ×";
//        
//        
//         
//    }
	
	public static void strObject(){
        String strA = "abc";
        String strB = "abc";
        
        String strX = "length: 10";
        String strY = "length: " + strX.length();
        
        String strAA = new String("abc");
        String strBB = new String("abc");
        
        System.out.println(strA == strB);
        System.out.println(strX == strY);
        System.out.println(strAA == strBB);
        
        System.out.println(strA.equals(strAA));
    }
    
    public static void strObject1(){
        String strA = "a";
        String strB = "b";
        String strC = strA + strB;
        String strD = strA.concat(strB);
        
        System.out.println(strC == "ab");
        System.out.println(strC.equals("ab"));
        System.out.println(strC == strA);
        System.out.println(strD == strA);
    }
    
    public   static   void  main(String[] args){
//        strObject();
        strObject1();
        
        String garen ="¸ÇÂ×";
      
        String gtuhr = "¸ÇÂ×";
        
        String g = new String("gailun");
        
        String str1 = "the light";
        String str3 = "the light";
        System.out.println( str1  ==  str3);
    }
}
