package Assignment;
import java.util.Date;
 
public class Book extends CatalogItem{
	
	
	private String author;
	private int numberOfPages;
	

	
	 //@return the author 
	public String getAuthor() {
		return author;
	}
	
	 //@param author the author to set
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// @return the numberOfPages
	public int getNumberOfPages() {
		return numberOfPages;
	}
	
	 //@param numberOfPages the numberOfPages to set 
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	@Override
	public String toString() {
		return "Book_"+super.toString() + "_"+getAuthor()+"_"+getNumberOfPages()+'\n';
	}
	
	

	
	
}
