package digit;
import java.util.Scanner;
public class Huanghe {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//地名
		
		System.out.println("请输入地名:");
		String place = s.nextLine();

		//System.out.printf("请输入地名:%n%s",place);
		//公司类型
		System.out.println("请输入公司类型:");
		String firmStyle = s.nextLine();
		//System.out.printf("请输入公司类型:%n%s",firmStyle);

		//公司名称
		System.out.println("请输入公司名称");
		String firmName = s.nextLine();
		System.out.println(":" + firmName);
		
		//老板名称
		System.out.println("请输入老板名称：");
		String boxName = s.nextLine();

		
		//欠债金额
		System.out.println("请输入金额:");
		float money = s.nextFloat();
		
		s.nextLine();

		//钱包
		System.out.println("请输入铲平:");
		String product = s.nextLine();

		//计量单位
		System.out.println("请输入价格计量单位:");
		String hundred = s.nextLine();
		
		String model = "%s最大的%s%s倒闭了，王八蛋老板%s吃喝嫖赌，欠下了%f个亿,%n"
				+ "带着他的小姨子跑了!我们没有办法，拿着钱包抵工资!原价都是一%s多、两%s多、三%s多的%s，%n"+ 
				"现在全部只卖二十块，统统只要二十块!%s王八蛋，你不是人!我们辛辛苦苦给你干了大半年，%n"+
				"你不发工资，你还我血汗钱，还我血汗钱!";
		System.out.printf(model,place,firmName,firmStyle,boxName,money,
				hundred,hundred,hundred,product,boxName);

	}
}
