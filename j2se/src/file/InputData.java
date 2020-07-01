package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class InputData {

	public static void main(String[] args) {
		try{
			//建立一个文件变量
			File f = new File("d:/lol2.txt");
			
			//提供数据初始化
			byte data[] = {23,56,45};
			
			//创建基于文件的输出流
			FileOutputStream fos = new  FileOutputStream (new File("d:/lol2.txt"));
			
			//将数据写到输出流中
			fos.write(data);
			
			fos.close();
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
