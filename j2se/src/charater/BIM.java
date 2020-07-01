package charater;

import java.util.Scanner;

public class BIM {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

        float height = s.nextFloat();
        
        System.out.println("请输入身高（m）："+ height);
        
        float weight = s.nextFloat();
        
        System.out.println("请输入体重（kg）"+ weight);
        
        float BIM = weight / (height * height);
        
        System.out.println("当前的BIM是："+ BIM);

        System.out.println("当前身体状态是：");
        if(BIM < 18.5)
        	System.out.println("体重过轻");
        else if(BIM < 24)
        	System.out.println("正常范围");
        else if(BIM < 27)
        	System.out.println("体重过重");
        else if(BIM < 30)
        	System.out.println("轻度肥胖");
        else if (BIM < 35)
        	System.out.println("中度肥胖");
        else
        	System.out.println("重度肥胖");
	}
}

// 可以定义一个status的字符串变量，最后输出为  System.out.println("身体状态是: " + status);