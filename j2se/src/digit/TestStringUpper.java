package digit;

public class TestStringUpper {
//	public static void main(String[] args) {
//		   
//        String s = "let there be light";
//        System.out.println(s);
//        //char[] str = s.toCharArray();
//  
//        //���÷ָ��Լ����ƶ�ά����Ķ���
//        //��ȡ�ַ���
//        String[] words = s.split(" ");
//        
//        for(int i = 0;i < words.length;i ++){
//        	String word = words[i];
//        	//if(word.charAt(0) == 'p')
//        	char UpperFirstWord = Character.toUpperCase(word.charAt(0));
//        	String rest = word.substring(1);
//        	words[i] = UpperFirstWord + rest;
//        }
//        
//        //ƴ������
//        String result = "";
//        
//        for(String word : words){
//        	result+=word + " ";
//        }
//        
//       result = result.trim();
//       System.out.println(result);
//         
//    }
//	
//	public static void main(String[] args) {
//		String s = "lengendary";
//		 char[] cs = s.toCharArray();
//		
//        cs[cs.length - 1] = Character.toUpperCase(cs[cs.length-1]);
//	}
	
	public static void main(String[] args) {
		 
        String[] ss = new String[100];
        // ��ʼ��
        for (int i = 0; i < ss.length; i++) {
            ss[i] = randomString(2);
        }
        // ��ӡ
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i] + " ");
            if (19 == i % 20)
                System.out.println();
        }
 
        for (String s1 : ss) {
            int repeat = 0;
            for (String s2 : ss) {
                if (s1.equalsIgnoreCase(s2)) {
                    repeat++;
                    if (2 == repeat) {
                        // ��repeat==2��ʱ�򣬾��Ҵ���һ���Ǽ����ظ��ַ���
 
                        putIntoDuplicatedArray(s1);
                        break;
                    }
                }
            }
        }
 
        System.out.printf("�ܹ��� %d���ظ����ַ���%n", pos);
        if (pos != 0) {
            System.out.println("�ֱ��ǣ�");
            for (int i = 0; i < pos; i++) {
                System.out.print(foundDuplicated[i] + " ");
            }
        }
    }
 
    static String[] foundDuplicated = new String[100];
    static int pos;
 
    private static void putIntoDuplicatedArray(String s) {
        for (int i = 0; i < pos; i++){
            if (foundDuplicated[i].equalsIgnoreCase(s))
                return;
        }
 
        foundDuplicated[pos++] = s;
    }
 
    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }

   
}
