/**
 * 
 */
package entity;

/**
 * ͼ�����Ա��ʵ����
 * @author future
 *
 */
public class Librarian {
	private int id;
	private String name;
	private String password;
	private String state; // ��ʾ�˺�״̬ ����blockade��Ϊ���������Ҳ��ɵ��룻��unlock��Ϊ����״̬


	public Librarian() {
		
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
		return "Librarian [id=" + id + ", name=" + name + ", password=" + password + ", state=" + state + "]";
	}

}
