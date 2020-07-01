package charater;

import java.io.File;

public class MyStringBuffer2 {
	public static void main(String[] args) {
		File f = new File("d:/LOLFolder/LOL.exe");
		System.out.println("当前文件是：" +f);
		System.out.println("判断是否存在："+f.exists());
		System.out.println("判断是否是文件夹："+f.isDirectory());
	}	
	}
	
