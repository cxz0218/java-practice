package charater;

public interface IStringBuffer {
	public void append(String str);//׷���ַ���
	public void append(char c);//׷���ַ�
	public void insert(int post,char b);//ָ��λ�ò����ַ�
	public void insert(int post ,String b);//ָ��λ�ò����ַ���
	public void delete(int start);//�ӿ�ʼλ��ɾ��ʣ�µ�
	public void  delete(int start ,int end); //�ӿ�ʼλ��ɾ������λ��
	public void reverse();//��ת
	public int length(); //���س���
}
