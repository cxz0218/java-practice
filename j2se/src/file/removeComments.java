package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 比如，移出以//开头的注释行
 * @author future
 *
 */
public class removeComments {
	
	public static void remove(File file) throws IOException{
		StringBuffer sb = new StringBuffer();

		
		//读取内容
		try(BufferedReader br = new BufferedReader (new FileReader (file))){
			String line = "";
			while((line = br.readLine())!= null){
				
				if(!line.trim().startsWith("//"))
					sb.append(line).append("\r\n");
			}
		}catch (IOException e) {
            e.printStackTrace();
        }
		try(PrintWriter pw = new PrintWriter(new FileWriter(file))){
			 //写出内容
            pw.write(sb.toString());
		}
	}
public static void main(String[] args) throws IOException {
    File javaFile = new File("E:\\how2j\\j2se\\src\\charater\\MyStringBuffer2.java");
    System.out.println(javaFile.exists());
    System.out.println(javaFile.length());
    remove(javaFile);
}
}
