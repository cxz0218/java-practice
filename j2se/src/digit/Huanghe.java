package digit;
import java.util.Scanner;
public class Huanghe {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//����
		
		System.out.println("���������:");
		String place = s.nextLine();

		//System.out.printf("���������:%n%s",place);
		//��˾����
		System.out.println("�����빫˾����:");
		String firmStyle = s.nextLine();
		//System.out.printf("�����빫˾����:%n%s",firmStyle);

		//��˾����
		System.out.println("�����빫˾����");
		String firmName = s.nextLine();
		System.out.println(":" + firmName);
		
		//�ϰ�����
		System.out.println("�������ϰ����ƣ�");
		String boxName = s.nextLine();

		
		//Ƿծ���
		System.out.println("��������:");
		float money = s.nextFloat();
		
		s.nextLine();

		//Ǯ��
		System.out.println("�������ƽ:");
		String product = s.nextLine();

		//������λ
		System.out.println("������۸������λ:");
		String hundred = s.nextLine();
		
		String model = "%s����%s%s�����ˣ����˵��ϰ�%s�Ժ��ζģ�Ƿ����%f����,%n"
				+ "��������С��������!����û�а취������Ǯ���ֹ���!ԭ�۶���һ%s�ࡢ��%s�ࡢ��%s���%s��%n"+ 
				"����ȫ��ֻ����ʮ�飬ͳͳֻҪ��ʮ��!%s���˵����㲻����!����������������˴���꣬%n"+
				"�㲻�����ʣ��㻹��Ѫ��Ǯ������Ѫ��Ǯ!";
		System.out.printf(model,place,firmName,firmStyle,boxName,money,
				hundred,hundred,hundred,product,boxName);

	}
}
