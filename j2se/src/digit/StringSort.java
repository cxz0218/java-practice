package digit;
import java.util.Arrays;
public class StringSort {
	public static void main(String[] args) {
		String[] ss = new String[8];
		
		//初始化
		for (int i = 0;i < ss.length;i++){
			String randomString = randomString(5);
			ss[i] = randomString;
		}
		System.out.println("未排序之前的字符串数组:");
		System.out.println(Arrays.toString(ss));
		
		//冒泡排序
		for (int i = ss.length - 1;i > 0;i--){
			for(int j = 0; j < i ;j++){
				char firstChild1 = ss[j].charAt(0);
				char firstChild2 = ss[j + 1].charAt(0);
				firstChild1 = Character.toLowerCase(firstChild1);
				firstChild2 = Character.toLowerCase(firstChild2);
				
				if(firstChild1 > firstChild2){
					String temp = ss[j];
					ss[j] = ss[j + 1];
					ss[j + 1] = temp;
				}
			}
		}
		
		System.out.println("排序之后的字符串数组:");
		System.out.println(Arrays.toString(ss));	
	}
	private  static String randomString(int length){
		String loop = "";
		for(short i = '0';i <= '9';i++)
			loop+=(char) i;
		for(short i = 'a';i <= 'z';i++)
			loop+=(char) i;
		for(short i = 'A';i <= 'Z';i++)
			loop+=(char) i;
		
		char cs[] = new char[length];
		for(int i = 0;i < cs.length;i++){
			int index = (int) (Math.random()*loop.length());
			cs[i] = loop.charAt(index);
		}
		String result = new String(cs);
		return result;
		
	}
}
