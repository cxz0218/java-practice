package file;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {
	public static void main(String[] args) {
		File file = new File ("c:\\windows");
		 File[] fi = file.listFiles();
		 if(null==fi)
	            return;
		
		File maxFile = null;//最大问价
		File minFile = null;//最小文件
		
		long minSize = Integer.MAX_VALUE;
        long maxSize = 0;
		//数组返回当前所有文件下的问价夹
		File[] fs = file.listFiles();
//		System.out.println(file);
//		System.out.println(file.exists());
//		System.out.println(file.length());
//		
//		long time = file.lastModified();
//		Date d = new Date(time);
//		System.out.println(time);
//		System.out.println(d);
//
//        File f2 =new File("d:/LOLFolder/DOTA.exe");
//		file.renameTo(f2);//真的改了。
//		System.out.println(file.list());
//		System.out.println(file.listRoots());
		
			for(File f : fi){
				if(f.isDirectory())
					 continue;	
				if(f.length()>maxSize){
					  maxSize = f.length();
		                maxFile = f;			
				}
				if(f.length()!= 0 && f.length() < minSize){
					minSize = f.length();
					minFile = f;
				}
			}
			
			 System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
		        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());
		}
		
	
}
  


