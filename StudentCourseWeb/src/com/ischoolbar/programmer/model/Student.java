package com.ischoolbar.programmer.model;



/**
 * 
 * @author future
 *学生实体类
 */
public class Student {
	private int id;
	private String sn;
	private String name;
	private String sex = "男";
	private String birthday;
	private String grade;
	private String major;
	private int clazzId;
	private String headteacher;
	private String password;

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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
	 * @return the sn
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * @param sn the sn to set
	 */
	public void setSn(String sn) {
		this.sn = sn;
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
	 * @return the clazzId
	 */
	public int getClazzId() {
		return clazzId;
	}
	/**
	 * @param clazzId the clazzId to set
	 */
	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the headteacher
	 */
	public String getHeadteacher() {
		return headteacher;
	}
	/**
	 * @param headteacher the headteacher to set
	 */
	public void setHeadteacher(String headteacher) {
		this.headteacher = headteacher;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	
	
}
