/**
 * 
 */
package entity;

import java.util.Date;

/**
 * 借阅历史中的每条记录的实体类
 * @author future
 *
 */
public class BorrowItem {

	private int borrowId;
	private int bookId;
	private String bookName;
	private String readerName;
	private int readerId;// zengyaoNPU添加于2018-11-15 17:04
	private int borrowLibrarianId;
	private String borrowLibrarianName;
	private int returnLibrarianId;
	private String returnLibrarianName;
	private Date borrowTime;
	private Date returnTime;
	private String state; // 状态为已还“returned”跟未还“unreturned”
	
	/**
	 * @param borrowId
	 * @param bookId
	 * @param bookName
	 * @param borrowLibrarianId
	 * @param returnLibrarianId
	 * @param borrowTime
	 * @param returnTime
	 * @param state
	 */
	public BorrowItem(int borrowId, int bookId, String bookName, int borrowLibrarianId, int returnLibrarianId,
			Date borrowTime, Date returnTime, String state) {
		super();
		this.borrowId = borrowId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.borrowLibrarianId = borrowLibrarianId;
		this.returnLibrarianId = returnLibrarianId;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
		this.state = state;
	}
	/**
	 * @return the borrowId
	 */
	public int getBorrowId() {
		return borrowId;
	}
	/**
	 * @param borrowId the borrowId to set
	 */
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
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
	 * @return the borrowLibrarianId
	 */
	public int getBorrowLibrarianId() {
		return borrowLibrarianId;
	}
	/**
	 * @param borrowLibrarianId the borrowLibrarianId to set
	 */
	public void setBorrowLibrarianId(int borrowLibrarianId) {
		this.borrowLibrarianId = borrowLibrarianId;
	}
	/**
	 * @return the returnLibrarianId
	 */
	public int getReturnLibrarianId() {
		return returnLibrarianId;
	}
	/**
	 * @param returnLibrarianId the returnLibrarianId to set
	 */
	public void setReturnLibrarianId(int returnLibrarianId) {
		this.returnLibrarianId = returnLibrarianId;
	}
	/**
	 * @return the returnTime
	 */
	public Date getReturnTime() {
		return returnTime;
	}
	/**
	 * @param returnTime the returnTime to set
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "BorrowItem [borrowId=" + borrowId + ", bookId=" + bookId + ", bookName=" + bookName + ", readerName="
				+ readerName + ", readerId=" + readerId + ", borrowLibrarianId=" + borrowLibrarianId
				+ ", borrowLibrarianName=" + borrowLibrarianName + ", returnLibrarianId=" + returnLibrarianId
				+ ", returnLibrarianName=" + returnLibrarianName + ", borrowTime=" + borrowTime + ", returnTime="
				+ returnTime + ", state=" + state + "]";
	}
	

	
	
}
