package com.ischoolbar.programmer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ischoolbar.programmer.model.Page;
import com.ischoolbar.programmer.model.Student;
import com.ischoolbar.programmer.util.DbUtil;
import com.ischoolbar.programmer.util.StringUtil;

public class StudentDao extends BaseDao {
	public boolean addStudent(Student student){
		Connection con = new DbUtil().getConnection();
		//String sql = "insert into undergraduate values(null,'"+student.getSn()+"','"+student.getName()+"','"+student.getSex()+"','"+student.getBirthday()+"','"+student.getGrade()+"','"+student.getMajor()+"','"+student.getClazzId()+"','"+student.getHeadteacher()+"','"+student.getPassword()+"')";
//		String sql = "insert into undergraduate values(null,'"+student.getSn()+"','"+student.getName()+"'";
//		sql += ",'"+student.getSex()+"','"+student.getBirthday()+"','"+student.getGrade()+"'";
//		sql +=",'"+student.getMajor()+"','"+student.getClazzId()+"'";
//		sql +=",'"+student.getHeadteacher()+"','"+student.getPassword()+"')";
		//return update(sql);		
		String sql = "insert into undergraduate (id,sn,name,sex,birthday,grade,major,clazz_id,headteacher,password) values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			//Timestamp t = new Timestamp(student.getBirthday().getTime());
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getSn());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4,student.getBirthday() );
			preparedStatement.setString(5, student.getGrade());
			preparedStatement.setString(6, student.getMajor());
			preparedStatement.setInt(7, student.getClazzId());
			preparedStatement.setString(8, student.getHeadteacher());
			preparedStatement.setString(9, student.getPassword());
			return preparedStatement.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public boolean editStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "update undergraduate set name = '"+student.getName()+"'";
		sql += ",sn = '" + student.getSn() + "'";
		sql += ",sex = '" + student.getSex() + "'";
		sql += ",birthday = '" + student.getBirthday() + "'";
		sql += ",grade = '" + student.getGrade() + "'";
		sql += ",major = '" + student.getMajor() + "'";
		sql += ",headteacher = '" + student.getHeadteacher() + "'";
		sql += ",clazz_id = " + student.getClazzId();
		sql += " where id = " + student.getId();
		return update(sql);
	}
	public boolean deleteStudent(String ids) {
		// TODO Auto-generated method stub
		String sql = "delete from undergraduate where id in("+ids+")";
		return update(sql);
	}
	public Student getStudent(int id){
		String sql = "select * from undergraduate where id = " + id;
		Student student = null;
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setClazzId(resultSet.getInt("clazz_id"));
				student.setBirthday(resultSet.getString("birthday"));
				student.setName(resultSet.getString("name"));
				student.setPassword(resultSet.getString("password"));
				student.setHeadteacher(resultSet.getString("headteacher"));
				student.setMajor(resultSet.getString("major"));
				student.setGrade(resultSet.getString("grade"));
				student.setSex(resultSet.getString("sex"));
				student.setSn(resultSet.getString("sn"));
				return student;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	public List<Student> getStudentList(Student student,Page page){
		List<Student> ret = new ArrayList<Student>();
		String sql = "select * from undergraduate ";
		if(!StringUtil.isEmpty(student.getName())){
			sql += "and name like '%" + student.getName() + "%'";
		}
		if(student.getClazzId() != 0){
			sql += " and clazz_id = " + student.getClazzId();
		}
		if(student.getId() != 0){
			sql += " and id = " + student.getId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				Student s = new Student();
				s.setId(resultSet.getInt("id"));
				s.setClazzId(resultSet.getInt("clazz_id"));
				s.setBirthday(resultSet.getString("birthday"));
				s.setName(resultSet.getString("name"));
				s.setPassword(resultSet.getString("password"));
				s.setHeadteacher(resultSet.getString("headteacher"));
				s.setMajor(resultSet.getString("major"));
				s.setGrade(resultSet.getString("grade"));
				s.setSex(resultSet.getString("sex"));
				s.setSn(resultSet.getString("sn"));
				ret.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public int getStudentListTotal(Student student){
		int total = 0;
		String sql = "select count(*)as total from undergraduate ";
		if(!StringUtil.isEmpty(student.getName())){
			sql += "and name like '%" + student.getName() + "%'";
		}
		if(student.getClazzId() != 0){
			sql += " and clazz_id = " + student.getClazzId();
		}
		if(student.getId() != 0){
			sql += " and id = " + student.getId();
		}
		
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				total = resultSet.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public Student login(String name ,String password){
		String sql = "select * from undergraduate where name = '" + name + "' and password = '" + password + "'";
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setPassword(resultSet.getString("password"));
				student.setClazzId(resultSet.getInt("clazz_id"));
				student.setBirthday(resultSet.getString("birthday"));
				student.setHeadteacher(resultSet.getString("headteacher"));
				student.setMajor(resultSet.getString("major"));
				student.setGrade(resultSet.getString("grade"));
				student.setSex(resultSet.getString("sex"));
				student.setSn(resultSet.getString("sn"));
				return student;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean editPassword(Student student,String newPassword) {
		// TODO Auto-generated method stub
		String sql = "update undergraduate set password = '"+newPassword+"' where id = " + student.getId();
		return update(sql);
	}
}
