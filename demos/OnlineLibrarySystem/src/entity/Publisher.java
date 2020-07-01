/**
 * 
 */
package entity;

/**
 * @author future
 *
 */
public class Publisher {
	private int id;
	private String name;
	private String description;
	/**
	 * 无参构造方法
	 */
	public Publisher() {
		super();
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

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
