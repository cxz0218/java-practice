package digit;

public class TestNumber {
	public static void main(String[] args) {
		int i =5;
		byte i1 = 2;
		short i2 = 15;
		float i3 = 3.14f;
		double i4 = 45.6;
		String str4 = "3.14";
		String str5 = "3.1a4";
		//��������ת���ɷ�װ����
		Integer it = new Integer(i);
		
		//��װ����ת��Ϊ��������
		//int i2 = it.intValue();
		
		//�Զ�ת���ͽ�װ��
		//Integer it2 = i;
		
		String s4 = String.valueOf(i4);
		
		float ss4 =Float.parseFloat(str4);
		//����ת�ַ�
		String str = String.valueOf(i);
		String str2 = it.toString();
		
		//�ַ���ת����
		String str3 = "88";
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(i4);
		System.out.println(ss4);
		System.out.println(Integer.parseInt(str3));
	}
}
