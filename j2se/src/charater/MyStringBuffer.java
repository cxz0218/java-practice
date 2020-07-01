package charater;

public class MyStringBuffer implements IStringBuffer{
	
	int capacity = 16;
	int length = 0;
	char[] value;
	
	//���췽��
	public MyStringBuffer(){
		value = new char[capacity];
	}
	
	//���ι��췽��
	public MyStringBuffer(String str){
		this();
		
		if( null == str){
			return;
		}
		
		if(capacity < value.length){
			capacity *= 2;
			value = new char[capacity];
		}
		
		if(capacity >= str.length()){
			System.arraycopy(str.toCharArray(),0 , value, 0, str.length());
			length = value.length;
		}
		
		//System.out.println(value);
	}
	@Override
	public void append(String str) {
		// TODO Auto-generated method stub
		insert(length,str);
		
		
	}
	@Override
	public void append(char c) {
		// TODO Auto-generated method stub
		append(String.valueOf(c));
	}

	@Override
	public void insert(int pos, String b) {
		// TODO Auto-generated method stub
		
		//�߽�����
		if(pos < 0 || pos > length)
			return;
		if(null == b)
			return;
		
		//����
		 while(length+b.length()>capacity){
	            capacity = (int) ((length+b.length())*1.5f);
	            char[] newValue = new char[capacity];
	            System.arraycopy(value, 0, newValue, 0, length);
	            value = newValue;
	        }
		 
	       char[] cs = b.toCharArray();
	          
	        //�Ȱ��Ѿ����ڵ�����������
	          
	        System.arraycopy(value, pos, value,pos+ cs.length, length-pos);
	        //��Ҫ��������ݲ��뵽ָ��λ��
	        System.arraycopy(cs, 0, value, pos, cs.length);
	          
	        length = length+cs.length;
	          
	    }
	   public String toString(){
	          
	        char[] realValue = new char[length];
	  
	        System.arraycopy(value, 0, realValue, 0, length);
	          
	        return new String(realValue);
	          
	    }
	
	@Override
	public void delete(int start) {
		// TODO Auto-generated method stub
		delete(start,length);
		
	}
	@Override
	public void insert(int post, char b) {
		// TODO Auto-generated method stub
		insert(post , String.valueOf(b));
	}
	@Override
	//�����0��1��2��3��4��ɾ��2.3  start��2 end ��4
	public void delete(int start, int end) {
		// TODO Auto-generated method stub
	    //�߽������ж�
        if(start<0)
            return;
         
        if(start>length)
            return;
         
        if(end<0)
            return;
         
        if(end>length)
            return;
         
        if(start>=end)
            return;
         
        System.arraycopy(value, end, value, start, length- end);
        length-=end-start;
	}
	@Override
	public void reverse() {
		// TODO Auto-generated method stub
    	for(int i = 0; i < length / 2; i++){ //i < length / 2  ��������������Ļ����м���Ǹ�����û�¡�
    		char temp = value[i];
    		value[i] = value[length - i - 1];
    		value[length - i - 1] = temp;	
    	}
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String[] args) {
		MyStringBuffer sb1 = new MyStringBuffer();
		System.out.println(sb1);
		
		MyStringBuffer sb = new MyStringBuffer("there light");
		System.out.println(sb);

	}



	
}
