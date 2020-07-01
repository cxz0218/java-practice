package text2;

import text2.*;

public class Book extends CatalogItem {
	private String author;
	private int numberOfPages;
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}
	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
//		super();
//		return "_" + author + "_" + numberOfPages ;
		return "Book_"+super.toString() + "_"+getAuthor()+"_"+getNumberOfPages()+'\n';
	}

	
	
}
