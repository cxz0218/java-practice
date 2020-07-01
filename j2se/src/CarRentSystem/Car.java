package CarRentSystem;
import java.util.Scanner;
public class Car {
	
		public static void main(String[] args) {

			
			Scanner s = new Scanner(System.in);
			welcome();
			System.out.println("您是否需要租车:1是 0否");	
			int choose = s.nextInt();
			
			//租车列表
			if(choose == 1){
				System.out.println("您可租用的类型及其价目表:");
				String number = "序号";
				String carName = "汽车名称";
				String rent = "租金";
				String capacity = "容量";
				System.out.println(number + "\t"+ carName + "\t" + rent + "\t" + capacity);
				System.out.println("1	奥迪A4	500	载人:4人");
				System.out.println("2	马自达6	400	载人:4人");
				System.out.println("3	皮卡雪6	450	载人:4 载货：2吨");
				System.out.println("4	金龙	800	载人:20人");
				System.out.println("5	松花江	400	载货：4吨");
				System.out.println("6	金龙	1000	载货：20吨");
				
				//租车数量和序号
				System.out.println("请输入您要租汽车的数量：");
				int carNumber = s.nextInt();
				Qiche[] save= new Qiche[carNumber];
				
				//用户选择和计算
				int kecheMounts = 0;
				int huocheMounts = 0;
				int sumRent = 0; 
				
				for(int i = 0;i < save.length ;i++){ //
					System.out.println("请输入第"+ (i+1) + "辆车的序号:");
					int carIndex = s.nextInt();
					save[i] =new Qiche(carIndex);
					
					//计算客车数量
					if(0 == save[i].capacityGoods){
						kecheMounts++;
						 System.out.println(save[i].carName);
					}
					
					//计算货车数量
					 if(0 == save[i].capacityPerson){
						huocheMounts++;
					System.out.println(save[i].carName);
					}
						
					if((0 != save[i].capacityGoods) && (0 != save[i].capacityPerson)){
						kecheMounts++;	
						huocheMounts++;
						System.out.println(save[i].carName);
					}
					//计算总花费
					sumRent+=save[i].rent;
					System.out.println(sumRent);
				}
	 System.out.println(kecheMounts);	
	 System.out.println(huocheMounts);

				//储存客车和货车的类型
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
					
					//计算货车数量
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
				//租车天数
				System.out.println("请输入租车天数：");
				int days = s.nextInt();
				
				//你的账单
				System.out.println("您的账单：");
				System.out.println("***" + "可载人的车有:");
				
				//打印客车
				for(int i = 0;i < kecheMounts;i++)
					System.out.print(kecheName[i] + "  ");
				System.out.printf("共载人：" + manSum + "人" );
				System.out.println();
				
				//打印货车
				System.out.println("***" + "载货的车有:");
				for(int i =0;i < huocheMounts;i++)
					System.out.printf(huocheName[i] + "  ");	
				System.out.printf("共载货：%d吨",loadSum);
				System.out.println();
				System.out.println("***租车总价格：" + sumRent*days + "元");

			}
			else{
				System.out.println("欢迎使用本系统");
			}
			
			
		}
		
		protected static void welcome(){
			//欢迎语
			System.out.println("欢迎使用答答租车系统:");
		}


		
}
