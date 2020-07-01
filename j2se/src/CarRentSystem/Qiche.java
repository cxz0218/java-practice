package CarRentSystem;

public class Qiche {

		
		protected int number;//序号
		
		protected String carName;//汽车名称
		
		protected int rent;//租金
		
		protected int capacityPerson;//载人容量
		
		protected int capacityGoods;//载物容量
		
		public Qiche( int options){
			switch(options){
			case 1:
				this.carName = "奥迪A4";
				this.rent = 500;
				this.capacityPerson = 4;
				this.capacityGoods = 0;
				break;
			case 2:
				this.carName = "马自达6";
				this.rent = 400;
				this.capacityPerson = 4;
				this.capacityGoods = 0;
				break;
			case 3:
				this.carName = "皮卡雪6";
				this.rent = 450;
				this.capacityPerson = 4;
				this.capacityGoods = 2;
				break;
			case 4:
				this.carName = "金龙";
				this.rent = 800;
				this.capacityPerson = 20;
				this.capacityGoods = 0;
				break;
			case 5:
				this.carName = "松花江";
				this.rent = 400;
				this.capacityGoods = 4;
				this.capacityPerson = 0;
				break;
			case 6:
				this.carName = "金龙";
				this.rent = 1000;
				this.capacityGoods = 20;
				this.capacityPerson = 0;
				break;
			}
		}
	
}
