package Assignment;



import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 */
public class LibrarySystem {
    static Catalog catalog = new Catalog();

    public static void main(String[] args) throws IOException, ParseException {
        LibrarySystem librarySystem = new LibrarySystem();
        String fileName = "catalog.dat";
        librarySystem.loadCatalogFromFile(fileName);
        Scanner scanner = new Scanner(System.in);
        while(true){
            librarySystem.initInterface();
            String option;
            option = scanner.next();
            switch (option){
                case "1"://显示所有记录
                    librarySystem.displayCatalogItem();
                    break;
                case "2"://根据标题显示对应记录信息
                    Scanner scanner2 = new Scanner(System.in);
                    String title;
                    System.out.println("请输入所查记录标题:");
                    title = scanner2.nextLine();
                    boolean flag = false;
                    for (CatalogItem e:catalog.list) {
                        if (title.equals(e.getTitle())){
                            System.out.println(e.toString());
                            flag = true;
                        }
                    }
                    if (!flag)
                        System.out.println("没有找到指定内容!");
                    break;
                case "3"://添加新记录
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.print("请按照对应格式输入信息:");
                    System.out.println("Book_Code_Title_year-month-day_Author_NumberOfPages");
                    System.out.println("或者:Recording_Code_Title_year-month-day_Performer_Format");
                    String itemNotes = scanner3.nextLine();
                    //把string -- CatalogItem
                    catalog.addItem(addList(itemNotes));
                    break;
                case "4"://根据标题或者标号删除指定记录
                    Scanner scanner4 = new Scanner(System.in);
                    String titleOrIndex;
                    System.out.print("请输入标题或者标号删除记录(标号可根据功能1查看):");
                    titleOrIndex = scanner4.nextLine();
                    for (CatalogItem c:catalog.list) {
                        if (titleOrIndex.equals(c.getTitle())){
                        	//给我一个文件 每次都把他当做一个有内容的文件而已，从表中删除这个文件
                            catalog.removeItem(c);
                        }
                        else if (catalog.getItem(Integer.valueOf(titleOrIndex)) == c){
                            catalog.removeItem(c);
                        }
                    }
                    break;
                case "5":
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("保存所有修改,请输入新文件的名字:");
                    String fileName1 = scanner5.nextLine();
                    librarySystem.saveCatalogToFile(fileName1);
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
//输入
    public void loadCatalogFromFile(String fileName) throws IOException, ParseException {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+fileName;
        BufferedReader br = new BufferedReader(new FileReader(path));
        String temp;
        while((temp = br.readLine() )!= null){
        	//catalog.itemList 
            catalog.list.add(addList(temp));

        }
        br.close();
    }

 //输出
    public void saveCatalogToFile(String fileName) throws IOException {
       // String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+fileName;
        //创建基于文件的输出流
        //FileOutputStream fos = new FileOutputStream(filName);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (CatalogItem e:catalog.list) {
            bw.write(e.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
 //展示
    public void displayCatalogItem(){
        int i = 0;
        
        //从最开始的位置判断"下一个"位置是否有数据
        //如果有就通过next取出来，并且把指针向下移动
        //直到"下一个"位置没有数据
        
        //使用迭代器
//        Iterator<CatalogItem> e =  catalog.list.iterator();
//        while(e.hasNext()){
//        	CatalogItem item = e.next();
//        	//println 实现了 toString的方法
//        	System.out.println("index:"  + i + " " + item);
//        	i++;
//        }
        
        for (CatalogItem e:catalog.list) {
            System.out.println("index:"+ i +"  "+e);
            i++;
        }
    }
 //把String -- CatalogItem
    public static CatalogItem addList(String str) throws ParseException {
        String[] strArr = str.split("_");
        //这个格式有问题
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (strArr[0].equals("Book")){
            Book book = new Book();
            book.setCode(strArr[1]);
            book.setTitle(strArr[2]);
            //讲String -- Date
            book.setPublishDate(sdf.parse(strArr[3]));
            book.setAuthor(strArr[4]);
            //将string -- int 
            book.setNumberOfPages(Integer.valueOf(strArr[5]));
            return book;
        }
        else {
            Recording recording = new Recording();
            recording.setCode(strArr[1]);
            recording.setTitle(strArr[2]);
            recording.setPublishDate(sdf.parse(strArr[3]));
            recording.setPerformer(strArr[4]);
            recording.setFormat(strArr[5]);
            return recording;
        }
    }
    public void initInterface(){
        System.out.println("欢迎使用图书系统!请选择要使用的功能:");
        System.out.println("1) display all catalogitems");
        System.out.println("2) display detail info of one item by title user input");
        System.out.println("3) add a new Book/Record");
        System.out.println("4) delete a Book/Record by title or index number user input");
        System.out.println("5) save all catalogitems to file with the file name user input");
        System.out.println("6) exit");
        System.out.print("请输入相应数字:");
    }
}

//
//import java.io.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//public class LibrarySystem {
//
////	// 加载和保存
////	public int  StringToInt (String str){
////		
////	}
//	public CatalogItem addList(CatalogItem item){
//		
//		
//		return item;
//		
//	}
//	public static ArrayList<CatalogItem>  loadCatalogFromFile(String fileName) {
//		ArrayList<CatalogItem> list = new ArrayList<>();
//		// File file = new File(fileName);
//		try {
//			// 创建一个读取流
//			BufferedReader br = new BufferedReader(new FileReader(fileName));
//
//			String line = "";
//
//			// 用来存储字符的数组
//			String[] arrays = null;
//
//			while ((line = br.readLine()) != null) {
//				arrays = line.split("_");
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//				Date date = format.parse(arrays[3]);
//				if (arrays[0].equals("Book")) {
//					Book book = new Book();
//					list.add(book);
//					book.setCode(arrays[1]);
//					book.setTitle(arrays[2]);
//					book.setPublishDate(date);
//					book.setAuthor(arrays[4]);
//					int pages = Integer.parseInt(arrays[5]);
//					book.setNumberOfPages(pages);
//				}
//				if (arrays[0].equals("Recording")) {
//					Recording recording = new Recording();
//					list.add(recording);
//					recording.setCode(arrays[1]);
//					recording.setTitle(arrays[2]);
//					recording.setPublishDate(date);
//					recording.setFormat(arrays[4]);
//					recording.setPerformer(arrays[5]);
//				}
//
//			}
//			br.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException | ParseException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	
//	 public void saveCatalogToFile(String fileName) throws IOException{
//	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));	 
//	 }
////	public static ArrayList<CatalogItem> loadAndSaveCatalogFromFile(String fileName) {
////		ArrayList<CatalogItem> tempList = new ArrayList<>();
////
////		File file = new File(fileName);
////		if (file.exists()) {
////			try {
////				FileInputStream fInput = new FileInputStream(file);
////				InputStreamReader iReader = new InputStreamReader(fInput);
////				BufferedReader bReader = new BufferedReader(iReader);
////				String str = "";
////				String[] arrays = null;
////				int i = 1;
////				while ((str = bReader.readLine()) != null) {
////					arrays = str.split("_");
////					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////					Date date = format.parse(arrays[3]);
////					if (arrays[0].equals("Book")) {
////						Book book = new Book();
////						tempList.add(book);
////						book.setCode(arrays[1]);
////						book.setTitle(arrays[2]);
////						book.setPublishDate(date);
////						book.setAuthor(arrays[4]);
////						// book.setNumberOfPages(); 此处少string转int的操作
////					}
////
////					if (arrays[0].equals("Recording")) {
////						Recording recording = new Recording();
////						tempList.add(recording);
////						recording.setCode(arrays[1]);
////						recording.setTitle(arrays[2]);
////						recording.setPublishDate(date);
////						recording.setFormat(arrays[4]);
////						recording.setPerformer(arrays[5]);
////					}
////				}
////				bReader.close();
////				iReader.close();
////				fInput.close();
////			} catch (FileNotFoundException e) {
////				e.printStackTrace();
////			} catch (UnsupportedEncodingException e) {
////				e.printStackTrace();
////			} catch (IOException | ParseException e) {
////				e.printStackTrace();
////			}
////		}
////		System.out.println("登录成功!");
////		return tempList;
////	}
//
//	// 显示目录
//	public static void displayCatalogItems(ArrayList<CatalogItem> arrayList) {
//		int num = arrayList.size();
//		for (CatalogItem item : arrayList){
//			System.out.print("编号:" + item.getCode() + "题目:" + item.getTitle() + " ");
//	System.out.println("出版日期:" + item.getPublishDate());
//		  }
////		for (int i = 0; i < num; i++) {
////			System.out.print("编号:" + arrayList.get(i).getCode() + "题目:" + arrayList.get(i).getTitle() + " ");
////			System.out.println("出版日期:" + arrayList.get(i).getPublishDate());
////		}
//
//	}
//
//	// 显示菜单
//	public static void showMenu() {
//		System.out.println("--- 菜单");
//		System.out.println("1.显示目录");
//		System.out.println("2.按图书编号查找");
//		System.out.println("3.添加一本新书或者一个新的音频");
//		System.out.println("4.删除一本书或者一个音频");
//		System.out.println("5.当前资源数量");
//		System.out.println("--- 输入 exit 退出");
//	}
//
//	public static void main(String[] args) {
//
//		String str = "E:\\how2j\\j2se\\catalog.dat";
//
//		ArrayList myList = loadCatalogFromFile(str);
//		// Book book=new Book();
//		Scanner scanner = new Scanner(System.in);
//		String optionString = "";
//		while (true) {
//			showMenu();
//			optionString = scanner.next();
//			// 如果用户输入exit 则退出循环
//			if (optionString.startsWith("e")) {
//				break;
//			}
//			try {
//			int option = Integer.parseInt(optionString);
//				// 根据菜单栏进行选择
//				switch (option) {
//				case 1:
//					System.out.println("数据库资源如下：");
//					displayCatalogItems(myList);
//					break;
//				case 2:
//					System.out.println("请输入相应的图书编号:");
//					String code = scanner.next();
//					
//				case 3:
//					System.out.println("您要新增的资源类别 1—图书 2-音频：");
//					SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
//					try {
//						int kind = scanner.nextInt();
//						if (kind == 1) {
//							Book book = new Book();
//							System.out.println("输入书编号：");
//							book.setCode(scanner.next());
//							scanner.nextLine();// 读取回车
//							System.out.println("输入书名：");
//
//							book.setTitle(scanner.nextLine());
//							System.out.println("输入日期：(例如：20019-09-14)");
//							book.setPublishDate(dateFormat.parse(scanner.nextLine()));
//							System.out.println("输入作者：");
//							book.setAuthor(scanner.nextLine());
//							System.out.println("输入书的页数");
//							book.setNumberOfPages(scanner.nextInt());
//							// librarySystem.getCatalog().addItem(book);
//							System.out.println("添加成功");
//						} else if (kind == 2) {
//							
//							Recording recording = new Recording();
//							System.out.println("输入音频编号：");
//							recording.setCode(scanner.next());
//							System.out.println("输入音频名：");
//							recording.setTitle(scanner.nextLine());
//							scanner.nextLine();// 读取回车
//							System.out.println("输入日期：(例如：20019-09-14)");
//							recording.setPublishDate(dateFormat.parse(scanner.nextLine()));
//							System.out.println("输入表演家：");
//							recording.setPerformer(scanner.nextLine());
//							System.out.println("输入资源格式");
//							recording.setFormat(scanner.nextLine());
//							// librarySystem.getCatalog().addItem(recording);
//							System.out.println("添加成功");
//						} else {
//							System.out.println("输入有误！");
//						}
//					} catch (Exception e) {
//						System.out.println("输入有误！");
//					}
//					break;
//				case 4:
//					// 选择book或者recording删除
////					System.out.println("您要删除的资源类别 1—图书 2-音频：");
////					try {
////						int kind = scanner.nextInt();
////						if (kind == 1) {
////							Book book = new Book();
////							System.out.println("输入书编号：");
////							book.setCode(scanner.next());
////							scanner.nextLine();// 读取回车
////							System.out.println("输入书名：");
////
////							book.setTitle(scanner.nextLine());
////							System.out.println("输入日期：(例如：20019-09-14)");
////							book.setPublishDate(dateFormat.parse(scanner.nextLine()));
////							System.out.println("输入作者：");
////							book.setAuthor(scanner.nextLine());
////							System.out.println("输入书的页数");
////							book.setNumberOfPages(scanner.nextInt());
////							// librarySystem.getCatalog().addItem(book);
////							System.out.println("添加成功");
////						} else if (kind == 2) {
////							
////							Recording recording = new Recording();
////							System.out.println("输入音频编号：");
////							recording.setCode(scanner.next());
////							System.out.println("输入音频名：");
////							recording.setTitle(scanner.nextLine());
////							scanner.nextLine();// 读取回车
////							System.out.println("输入日期：(例如：20019-09-14)");
////							recording.setPublishDate(dateFormat.parse(scanner.nextLine()));
////							System.out.println("输入表演家：");
////							recording.setPerformer(scanner.nextLine());
////							System.out.println("输入资源格式");
////							recording.setFormat(scanner.nextLine());
////							// librarySystem.getCatalog().addItem(recording);
////							System.out.println("添加成功");
////						} else {
////							System.out.println("输入有误！");
////						}
////					} catch (Exception e) {
////						System.out.println("输入有误！");
////					}
////					break;
//
//				case 5:
//					System.out.println("当前书库共有：");
//				default:
//					System.out.println("输入有误，请重新输入!");
//					break;
//				}
//			} catch (Exception e) {
//				System.out.println("输入有误，请重新输入!");
//			}
//		}
//
//	}
//
//
//
//
//
//
//
//	 }
//
