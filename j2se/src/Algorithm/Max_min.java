package Algorithm;

public class Max_min {
	public static void main(String[] args) {
		
		/**
		 * ���������ҵ�����һ����
		 */
		int[] a = new int[]{2,56,89,1,3,5};
		
		int max = -1;
		

		for (int each : a){
			if(each > max)
				max = each;
		}
		 
	
		System.out.println("������ǣ�"+ max);
		
		String a1 = String.valueOf('a');
		
		String a2 = Character.toString('a');
		
		String str1 = "the";
		 
        StringBuffer sb = new StringBuffer(str1);
        

	}
    /**
     * �����е������з�ת����
     */
   // static int length = 16;
    public static void reverse(){
    	int length = 16;
    	char[] value = new char[16];
    	for(int i = 0; i < length / 2; i++){ //i < length / 2  ��������������Ļ����м���Ǹ�����û�¡�
    		char temp = value[i];
    		value[i] = value[length - i - 1];
    		value[length - i - 1] = temp;	
    	}
    }

}
