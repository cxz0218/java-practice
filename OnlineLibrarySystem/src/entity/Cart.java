/**
 * 
 */
package entity;

import java.util.Date;

/**
 * 借阅车实体类
 * @author future
 *
 */
public class Cart {
	private int bookId;
	private String bookName;
	private int readerId;
	private String readerName;
	private Date submitTime; // 当reader把借阅车中的的书提交借阅是，添加时间

	public Cart() {
		super();
	}
	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the readerId
	 */
	public int getReaderId() {
		return readerId;
	}
	/**
	 * @param readerId the readerId to set
	 */
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	/**
	 * @return the readerName
	 */
	public String getReaderName() {
		return readerName;
	}
	/**
	 * @param readerName the readerName to set
	 */
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	/**
	 * @return the submitTime
	 */
	public Date getSubmitTime() {
		return submitTime;
	}
	/**
	 * @param submitTime the submitTime to set
	 */
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	@Override
	public String toString() {
		return "Cart [bookId=" + bookId + ", bookName=" + bookName + ", readerId=" + readerId + ", readerName="
				+ readerName + ", submitTime=" + submitTime + "]";
	}


}
