package text2;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import text2.*;

public class LibrarySystem {
	static Catalog log = new Catalog();

	// 把文件从硬盘读到内存，之后再吧数据存储到list里面
	public void loadCatalogFromFile(String fileName) throws IOException {
		// 先建立字符输入流，以及缓存
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			String line = "";
			while ((line = br.readLine()) != null) {
				Catalog.list.add(StringToCatalogItem(line));
			}
			br.close();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/// 这里就是异常处理有问题
	}

	// 把String -- CatalogItem
	// 把一条记录变量值分开
	// ----- 这里为什么是有返回类型的
	private static CatalogItem StringToCatalogItem(String str) throws ParseException {

		String[] bs = str.split("_");

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 把string类型转化为date类型并设置格式
		// 这个格式有问题 必须是"yyyy-MM-dd"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// if("Book" == bs[0]){
		if (bs[0].equals("Book")) {
			// 建一个book类
			Book book = new Book();
			book.setCode(bs[1]);
			book.setTitle(bs[2]);
			book.setPublishDate(sdf.parse(bs[3]));
			book.setAuthor(bs[4]);
			// 把String-- int
			book.setNumberOfPages(Integer.parseInt(bs[5]));
			return book;
		} else if (bs[0].equals("Recording")) {
			// 建一个book类
			Recording recording = new Recording();
			recording.setCode(bs[1]);
			recording.setTitle(bs[2]);
			recording.setPublishDate(sdf.parse(bs[3]));
			recording.setPerformer((bs[4]));
			recording.setFormat(bs[5]);
			return recording;
		}
		return null;

	}

	// 输出就是把之前list里面的
	public void saveCatalogToFile(String fileName) throws IOException {

		// 开始的开始 建一条输出流 buffer
		// 这里变量错了
		// BufferedWriter pw = new BufferedWriter(new FileWriter(fileName));
		PrintWriter pw = new PrintWriter(new FileWriter(fileName));
		for (CatalogItem e : Catalog.list) {
			pw.write(e.toString());
		}
		pw.close();

		// 循环list
		// --------------------------------
		// 不是很懂
		// for(CatalogItem e : Catalog.list){
		// pw.write(e.toString());
		// pw.newLine();
		// pw.flush();
		// }
		// pw.close();

	}

	// 显示
	public void displayCatalogItem() {
		int index = 0;
		for (CatalogItem e : Catalog.list) {
			System.out.println(index++ + " " + e);
		}
		// 菜单
	}

	public static void initMenu() {
		System.out.println("欢迎使用图书系统!请选择要使用的功能:");
		System.out.println("1) display all catalogitems");
		System.out.println("2) display detail info of one item by title user input");
		System.out.println("3) add a new Book/Record");
		System.out.println("4) delete a Book/Record by title or index number user input");
		System.out.println("5) save all catalogitems to file with the file name user input");
		System.out.println("6) exit");
		System.out.print("请输入相应数字:");
	}

	public static void main(String[] args) throws IOException, ParseException {// 此处有错
		// 实例化
		LibrarySystem libs = new LibrarySystem();

		// String str = "E:\\how2j\\j2se\\catalog.dat";
		String fileName = "E:\\how2j\\j2se\\src\\catalog.dat";
		// 把所有的文件都存储到list里
		libs.loadCatalogFromFile(fileName);

		// 输入
		Scanner s = new Scanner(System.in);

		// 这是一个很好的方法去解决就是一一个主线任务重复多次
		// 比如这种菜单操作 多次输入 并且触动操作
		while (true) {
			initMenu();
			// 字符从键盘输入是.next()
			String option = s.next();
			switch (option) {
			case "1":// 显示记录
				libs.displayCatalogItem();
				break;
			case "2":// 根据题目显示记录
				String ways = s.next();
				// 这如何处理查找未查找到内容
				Boolean loop = false;
				for (CatalogItem e : Catalog.list) {
					if (e.getTitle().equals(ways)) {
						System.out.println(e);
						loop = true;
					}
				}
				if (!loop)
					System.out.println("未找到你所要检索的目录。");
				break;
			case "3": // 添加book / recording
				Scanner scanner3 = new Scanner(System.in);
				System.out.print("请按照对应格式输入信息:");
				System.out.println("Book_Code_Title_year-month-day_Author_NumberOfPages");
				System.out.println("或者:Recording_Code_Title_year-month-day_Performer_Format");
				String itemNotes = scanner3.nextLine();
				// 把string -- CatalogItem

				log.addItem(StringToCatalogItem(itemNotes));
				break;

			case "4":
				Scanner scanner4 = new Scanner(System.in);

				String TitleOrIndex = "";

				for (CatalogItem e : Catalog.list) {
					if (e.getTitle().equals(scanner4))
						log.removeItem(e);
					else if (log.getItem(String.valueOf(TitleOrIndex)) == e)
						log.removeItem(e);
				}
				break;
			case "5":
				Scanner scanner5 = new Scanner(System.in);
				System.out.println("保存所有修改,请输入新文件的名字:");
				String fileName1 = scanner5.nextLine();
				//
				libs.saveCatalogToFile(fileName1);
				break;
			case "6":
				System.out.println("感谢使用再见!");
				return;
			default:
				System.out.println("输入有误,请重新输入!");
				break;
			}

		}
	}
}
