/**
 * 
 */
package entity;

/**
 * 系统管理员的实体类
 * @author future
 *
 */
public class Administrator {

	private int id;
	private String name;
	private String password;
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public Administrator(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}
