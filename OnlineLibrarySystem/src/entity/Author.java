package entity;
/**
 * 作者的实体类
 * @author future
 *
 */
public class Author {

	private int id;
	private String name;
	private String description;
	/**
	 * 无参构造函数
	 */
	public Author() {
	}
	/**
	 * 对Author进行是初始化
	 * @param id
	 * @param name
	 * @param description
	 */
	public Author(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
		return "Author [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
