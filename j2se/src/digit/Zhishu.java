package digit;

public class Zhishu {
	public static void main(String[] args) {
		int max = 1000*10000;
		int count = 0;
		short start = '0';
        short end = 'z'+1;
		char c = (char) ((Math.random() * (end - start)) + start);
		for(int i = 1;i <= max ;i++){
			if(isPrime(i))
				count++;
		}
		System.out.println("一千万以内的质数一共有 :"+ count);
	}
	private static boolean isPrime(int i){
		for(int j = 2;j <= Math.sqrt(i);j++){
			if(0 == i % j)
				return false;
		}
		return true;
	}
}
