package Assignment;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class CatalogItem {
	
	private String code;
	private String title;
	private Date publishDate;
	

	
	//@return the code
	public String getCode() {
		return code;
	}
	
	// @param code the code to set
	public void setCode(String code) {
		this.code = code;
	}
	
	//@return the title
	public String getTitle() {
		return title;
	}
	
	// @param title the title to set
	public void setTitle(String title) {
		this.title = title;
	}
	
	//@return the publishData
	public Date getPublishDate() {
		return publishDate;
	}
	
	// @param publishData the publishData to set
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}




	@Override
	public String toString() {
		
		//设置日期格式
		Date day = new Date();
		String strDateFormat = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		 
		return "_"+code+"_"+title+"_"+sdf.format(day);
	}

}
