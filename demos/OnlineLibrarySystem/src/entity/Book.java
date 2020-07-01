/**
 * 
 */
package entity;

import java.math.BigDecimal;

/**
 * @author future
 *
 */
public class Book {
	private int id;
	private String ISBN;// in table Book
	private String name;// in table Book
	private BigDecimal price;
	private String description;// in table Book
	private Publisher publisher;// in table Book publisher_id
	private String authors;// in table Book author_id
	private String location;
	private String state; // 书的状态为"inlib"(在库), "borrowed"(借出), "reserve"(待审批)
	/**
	 * 无参构造函数
	 */
	public Book() {

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
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
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
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN=" + ISBN + ", name=" + name + ", price=" + price + ", description="
				+ description + ", publisher=" + publisher + ", authors=" + authors + ", location=" + location
				+ ", state=" + state + "]";
	}
	

}
