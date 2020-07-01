package Assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog {
	List<CatalogItem> list = new ArrayList<CatalogItem>();
	
	public void addItem(CatalogItem item){
		list.add(item);
	}

	public void removeItem(CatalogItem item){
		list.remove(item);
	}
	
	public CatalogItem getItem(String code){
		for (CatalogItem e : list) {
			if (code.equals(e.getCode())) {
				return e;
			}
		}
		return null;
		
	}
	//BufferedReader br = new BufferedReader(new FileReader(fileName));

	//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	Date date = format.parse(arrays[3]);
	//book.setPublishDate(date);
	public CatalogItem getItem(int index){
		int i = 0;
		for (CatalogItem e : list) {
			if (i == index) {
				return e;
			}
			i++;
		}
		return null;
		
	}
	
	public int getNumberOfItems(){
		int nums = 0;
		for (CatalogItem e : list) {
			nums++;
		}
		return nums;
		
	}
}
