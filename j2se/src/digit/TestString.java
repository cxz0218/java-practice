package digit;

public class TestString {
	
	public static void main(String[] args) {
		
		String password = randomString(3);//返回一个随机密码
		
		System.out.println("密码是:"+ password);
		
		char [] testPassword = new char[3];
		
		outloop://多层循环结束条件，记得是: 不是;
		//开始判断
		for(short i = '0';i <= 'z';i++){
			for(short j = '0';j <= 'z';j++){
				for(short k = '0';k <= 'z';k++){
					if(!isLetterOrDigit(i,j,k))
						continue;
					//筛掉了不符合条件的数
					testPassword[0] = (char) i ;//这里每次都需要把short转换成char吧
					testPassword[1] = (char) j;
					testPassword[2]	= (char) k;
					
					//数组转化成字符串
					String test = new String(testPassword);
					//System.out.println("穷举出来的密码是:" + test);
					
					if(test.equals(password)){
					System.out.println("找到密码了:" + test);
					break outloop;						
					}

				}
			}
		}
		
	}
	
	//判断是否是数字或者字符
	private static boolean isLetterOrDigit(short i,short j,short k){
		return Character.isLetterOrDigit(i) && 
				Character.isLetterOrDigit(j) &&
				Character.isLetterOrDigit(k);
	}
	//创建随机数组
	 private static String randomString(int length){
		 String loop = "";
		 for(short i= '0';i <= '9';i++)
			 loop += (char) i;
		 for(short i = 'a';i <= 'z'; i++)
			 loop += (char) i;
		 for(short i = 'A';i <= 'Z';i++	)
			 loop += (char) i;
		 char[] cs = new char[length];
		 
		 for(int i = 0;i < cs.length;i++){
			 int index = (int)(Math.random()*loop.length());
			 cs[i] = loop.charAt(index);
		 }
		 
		String result = new String(cs);
		return result;
		 
			 
	 }
}
