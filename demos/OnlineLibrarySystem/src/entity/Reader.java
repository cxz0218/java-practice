package entity;

import java.util.ArrayList;
/**
 * ���ߵ�ʵ����
 * @author future
 *
 */
public class Reader {
	private int id;
	private String name;
	private String password;
	private String email;
	private String state; // ��ʾ�˺�״̬ ����blockade��Ϊ���������Ҳ��ɵ��룻��unlock��Ϊ����״
	private ArrayList<Cart> cartList;// ���ĳ�
	private ArrayList<BorrowItem> borrowHistory;// ������ʷ
	/**
	 * 
	 */
	public Reader() {
		cartList = new ArrayList<Cart>();
		borrowHistory = new ArrayList<BorrowItem>();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	/**
	 * @return the cartList
	 */
	public ArrayList<Cart> getCartList() {
		return cartList;
	}
	/**
	 * @param cartList the cartList to set
	 */
	public void setCartList(ArrayList<Cart> cartList) {
		this.cartList = cartList;
	}
	/**
	 * @return the borrowHistory
	 */
	public ArrayList<BorrowItem> getBorrowHistory() {
		return borrowHistory;
	}
	/**
	 * @param borrowHistory the borrowHistory to set
	 */
	public void setBorrowHistory(ArrayList<BorrowItem> borrowHistory) {
		this.borrowHistory = borrowHistory;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", state="
				+ state + ", cartList=" + cartList + ", borrowHistory=" + borrowHistory + "]";
	}
	
	

}
