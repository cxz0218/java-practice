package CarRentSystem;
import java.util.Scanner;
public class Car {
	
		public static void main(String[] args) {

			
			Scanner s = new Scanner(System.in);
			welcome();
			System.out.println("���Ƿ���Ҫ�⳵:1�� 0��");	
			int choose = s.nextInt();
			
			//�⳵�б�
			if(choose == 1){
				System.out.println("�������õ����ͼ����Ŀ��:");
				String number = "���";
				String carName = "��������";
				String rent = "���";
				String capacity = "����";
				System.out.println(number + "\t"+ carName + "\t" + rent + "\t" + capacity);
				System.out.println("1	�µ�A4	500	����:4��");
				System.out.println("2	���Դ�6	400	����:4��");
				System.out.println("3	Ƥ��ѩ6	450	����:4 �ػ���2��");
				System.out.println("4	����	800	����:20��");
				System.out.println("5	�ɻ���	400	�ػ���4��");
				System.out.println("6	����	1000	�ػ���20��");
				
				//�⳵���������
				System.out.println("��������Ҫ��������������");
				int carNumber = s.nextInt();
				Qiche[] save= new Qiche[carNumber];
				
				//�û�ѡ��ͼ���
				int kecheMounts = 0;
				int huocheMounts = 0;
				int sumRent = 0; 
				
				for(int i = 0;i < save.length ;i++){ //
					System.out.println("�������"+ (i+1) + "���������:");
					int carIndex = s.nextInt();
					save[i] =new Qiche(carIndex);
					
					//����ͳ�����
					if(0 == save[i].capacityGoods){
						kecheMounts++;
						 System.out.println(save[i].carName);
					}
					
					//�����������
					 if(0 == save[i].capacityPerson){
						huocheMounts++;
					System.out.println(save[i].carName);
					}
						
					if((0 != save[i].capacityGoods) && (0 != save[i].capacityPerson)){
						kecheMounts++;	
						huocheMounts++;
						System.out.println(save[i].carName);
					}
					//�����ܻ���
					sumRent+=save[i].rent;
					System.out.println(sumRent);
				}
	 System.out.println(kecheMounts);	
	 System.out.println(huocheMounts);

				//����ͳ��ͻ���������
				String[] kecheName = new String[kecheMounts];
				String[] huocheName = new String[huocheMounts];
				int j = 0;
				int k = 0;
				int manSum = 0;
				int loadSum = 0;
				for(int i = 0;i < save.length ;i++){
					if(0 == save[i].capacityGoods){
						 System.out.println(save[i].carName);
						kecheName[k] = save[i].carName;
						manSum += save[i].capacityPerson;
						k++;
					}
					
					//�����������
					if(0 == save[i].capacityPerson){
						 System.out.println(save[i].carName);
						huocheName[j] = save[i].carName;
						loadSum += save[i].capacityGoods;
						j++;
					}
					
					if((0 != save[i].capacityGoods) && (0 != save[i].capacityPerson)){
						//System.out.println(save[i].carName);
						kecheName[k] = save[i].carName;
						huocheName[j] = save[i].carName;
						loadSum += save[i].capacityGoods;
						manSum += save[i].capacityPerson;
						j++;
						k++;
						
					}
				
				}
				//�⳵����
				System.out.println("�������⳵������");
				int days = s.nextInt();
				
				//����˵�
				System.out.println("�����˵���");
				System.out.println("***" + "�����˵ĳ���:");
				
				//��ӡ�ͳ�
				for(int i = 0;i < kecheMounts;i++)
					System.out.print(kecheName[i] + "  ");
				System.out.printf("�����ˣ�" + manSum + "��" );
				System.out.println();
				
				//��ӡ����
				System.out.println("***" + "�ػ��ĳ���:");
				for(int i =0;i < huocheMounts;i++)
					System.out.printf(huocheName[i] + "  ");	
				System.out.printf("���ػ���%d��",loadSum);
				System.out.println();
				System.out.println("***�⳵�ܼ۸�" + sumRent*days + "Ԫ");

			}
			else{
				System.out.println("��ӭʹ�ñ�ϵͳ");
			}
			
			
		}
		
		protected static void welcome(){
			//��ӭ��
			System.out.println("��ӭʹ�ô���⳵ϵͳ:");
		}


		
}
