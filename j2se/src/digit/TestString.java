package digit;

public class TestString {
	
	public static void main(String[] args) {
		
		String password = randomString(3);//����һ���������
		
		System.out.println("������:"+ password);
		
		char [] testPassword = new char[3];
		
		outloop://���ѭ�������������ǵ���: ����;
		//��ʼ�ж�
		for(short i = '0';i <= 'z';i++){
			for(short j = '0';j <= 'z';j++){
				for(short k = '0';k <= 'z';k++){
					if(!isLetterOrDigit(i,j,k))
						continue;
					//ɸ���˲�������������
					testPassword[0] = (char) i ;//����ÿ�ζ���Ҫ��shortת����char��
					testPassword[1] = (char) j;
					testPassword[2]	= (char) k;
					
					//����ת�����ַ���
					String test = new String(testPassword);
					//System.out.println("��ٳ�����������:" + test);
					
					if(test.equals(password)){
					System.out.println("�ҵ�������:" + test);
					break outloop;						
					}

				}
			}
		}
		
	}
	
	//�ж��Ƿ������ֻ����ַ�
	private static boolean isLetterOrDigit(short i,short j,short k){
		return Character.isLetterOrDigit(i) && 
				Character.isLetterOrDigit(j) &&
				Character.isLetterOrDigit(k);
	}
	//�����������
	 private static String randomString(int length){
		 String loop = "";
		 for(short i= '0';i <= '9';i++)
			 loop += (char) i;
		 for(short i = 'a';i <= 'z'; i++)
			 loop += (char) i;
		 for(short i = 'A';i <= 'Z';i++	)
			 loop += (char) i;
		 char[] cs = new char[length];
		 
		 for(int i = 0;i < cs.length;i++){
			 int index = (int)(Math.random()*loop.length());
			 cs[i] = loop.charAt(index);
		 }
		 
		String result = new String(cs);
		return result;
		 
			 
	 }
}
