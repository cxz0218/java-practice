package digit;
import java.util.Date;
//public class TestString1 {
//
//	public static boolean found = false;
//	public static void main(String[] args) {
//		String password = randomString(3);
//		System.out.println("������:" + password);
//		
//		char[] guessPassword = new char[password.length()];
//		generatePasswords(guessPassword,0,password);
//	}
//	
//	// ��������
//
////�ݹ�
//	private static void generatePasswords(char[] guessPassword ,int index ,String password){
//		if(found)
//			return;//�����˴εĵݹ�
//		for(short i = '0';i <= 'z';i++){
//			char c = (char) i;
//			if(!Character.isLetterOrDigit(c))
//				continue;
//			guessPassword[index] = c;
//			
//			//���鳤�ȵ���
//			if(index != guessPassword.length - 1)
//				generatePasswords(guessPassword,index + 1,password);
//			else{
//				String guess = new String(guessPassword);
//				if(guess.equals(password))
//				{
//					System.out.println("�ҵ��ˣ�������:" + guess);
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
//        String sentence = "����,�ڽ���������8�λ�ɱ��,����˳��� �ĳƺ�";
//  
//        System.out.println(sentence.indexOf('8')); //�ַ���һ�γ��ֵ�λ��
//          
//        System.out.println(sentence.indexOf("����")); //�ַ�����һ�γ��ֵ�λ��
//          
//        System.out.println(sentence.lastIndexOf("��")); //�ַ��������ֵ�λ��
//          
//        System.out.println(sentence.indexOf(',',5)); //��λ��5��ʼ�����ֵĵ�һ��,��λ��
//          
//        System.out.println(sentence.contains("��ɱ")); //�Ƿ�����ַ���"��ɱ"
//          
//    }
	
	//�޸��ض�λ���ϵ���ĸ
//    public static void main(String[] args) {
//        // �����һ��two��������ĸ��д
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
    
    
    //�����ַ����Ƿ�ͬһ����
//    public static void main(String[] args) {
//        String str1 = "the light";
//        String str3 = "the light";
//        System.out.println( str1  ==  str3);
//    }
	
	//����StringBuffer��
	public static void main(String[] args) {
	    
//	    String str1 = "the";
//	    
//	    StringBuffer sb = new StringBuffer(str1);
//	    System.out.println(sb.length()); //���ݳ���
//        
//       System.out.println(sb.capacity());//�ܿռ�
       
       // ��ǰʱ��
       Date d1 = new Date();
       System.out.println("��ǰʱ��:");
       System.out.println(d1);
       System.out.println();
       // ��1970��1��1�� ����8��0��0�� ��ʼ�����ĺ�����
       Date d2 = new Date(5000);
       System.out.println("��1970��1��1�� ����8��0��0�� ��ʼ������5���ʱ��");
       System.out.println(d2);
	}
}
