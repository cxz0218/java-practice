package Algorithm;

public class Max_min {
	public static void main(String[] args) {
		
		/**
		 * 在数组中找到最大的一个数
		 */
		int[] a = new int[]{2,56,89,1,3,5};
		
		int max = -1;
		

		for (int each : a){
			if(each > max)
				max = each;
		}
		 
	
		System.out.println("最大数是："+ max);
		
		String a1 = String.valueOf('a');
		
		String a2 = Character.toString('a');
		
		String str1 = "the";
		 
        StringBuffer sb = new StringBuffer(str1);
        

	}
    /**
     * 数组中的数进行反转交换
     */
   // static int length = 16;
    public static void reverse(){
    	int length = 16;
    	char[] value = new char[16];
    	for(int i = 0; i < length / 2; i++){ //i < length / 2  数组个数是奇数的话，中间的那个数就没事。
    		char temp = value[i];
    		value[i] = value[length - i - 1];
    		value[length - i - 1] = temp;	
    	}
    }

}
