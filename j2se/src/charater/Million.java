package charater;

public class Million {
	
	public static void main(String[] args) {
		int foundPerMonth = 1000;
		int foundPerYear = foundPerMonth*12;
		float rate = 0.20f;
		int target = 1000000;
		int sum =0;
		
		//F = p* ( (1+r)^n );
		for(int i = 1; i < 100;i++){
			int year = i;
			float compoundInterestRate = 1;
			//�������㸴��
			for(int j = 0; j < year;j++){
				compoundInterestRate*=(1+rate);
			}	
			
			int compondInterest = (int)(foundPerYear*compoundInterestRate);
			sum+=compondInterest;
			System.out.println("��" + year + "��,��������" + sum );
			
			//ȷ���ú�ʱ����Ŀ��
			if(sum>=target){
				System.out.println("�ܹ���Ҫ��" + year);
				break;
			}
	
		}
		
	}
}
