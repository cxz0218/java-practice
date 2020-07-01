package text2;

import java.util.ArrayList;
import java.util.List;

import text2.*;

public class Catalog {
	//建一个CatalogItem类的容器
	static List<CatalogItem> list = new ArrayList<CatalogItem>();
	
	public void addItem(CatalogItem item){
		list.add(item);
	}
	
	public void removeItem(CatalogItem item){
		list.remove(item);
	}
	
	//从list里面查找
	public CatalogItem getItem(String code){

		for(CatalogItem e : list){
			//error
//			if(e.getCode() == code)
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	//
	public CatalogItem getItem(int index){
		//自己计数
		int i = 0;
		for(CatalogItem e : list){
			if(index == i)
				return e;	
		}
		return null;
	}
	

	public int getNumberOfItems(){
		int i = 0;
		for(CatalogItem e : list){
			i++;	
		}
		return i;
		
	}
}
