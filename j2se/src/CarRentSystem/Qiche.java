package CarRentSystem;

public class Qiche {

		
		protected int number;//���
		
		protected String carName;//��������
		
		protected int rent;//���
		
		protected int capacityPerson;//��������
		
		protected int capacityGoods;//��������
		
		public Qiche( int options){
			switch(options){
			case 1:
				this.carName = "�µ�A4";
				this.rent = 500;
				this.capacityPerson = 4;
				this.capacityGoods = 0;
				break;
			case 2:
				this.carName = "���Դ�6";
				this.rent = 400;
				this.capacityPerson = 4;
				this.capacityGoods = 0;
				break;
			case 3:
				this.carName = "Ƥ��ѩ6";
				this.rent = 450;
				this.capacityPerson = 4;
				this.capacityGoods = 2;
				break;
			case 4:
				this.carName = "����";
				this.rent = 800;
				this.capacityPerson = 20;
				this.capacityGoods = 0;
				break;
			case 5:
				this.carName = "�ɻ���";
				this.rent = 400;
				this.capacityGoods = 4;
				this.capacityPerson = 0;
				break;
			case 6:
				this.carName = "����";
				this.rent = 1000;
				this.capacityGoods = 20;
				this.capacityPerson = 0;
				break;
			}
		}
	
}
