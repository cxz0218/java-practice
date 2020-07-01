package com.ischoolbar.programmer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ischoolbar.programmer.model.Page;
import com.ischoolbar.programmer.model.Postgraduate;

import com.ischoolbar.programmer.util.DbUtil;
import com.ischoolbar.programmer.util.StringUtil;

public class PostgraduateDao extends StudentDao {
	public boolean addStudent(Postgraduate student){
		Connection con = new DbUtil().getConnection();
		String sql = "insert into postgraduate (id,sn,name,sex,birthday,grade,major,password,researchDir,tutor) values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getSn());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getBirthday());
			preparedStatement.setString(5, student.getGrade());
			preparedStatement.setString(6, student.getMajor());
			preparedStatement.setString(7, student.getPassword());
			preparedStatement.setString(8, student.getResearchDir());
			preparedStatement.setString(9, student.getTutor());
			return preparedStatement.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public boolean editStudent(Postgraduate student) {
		// TODO Auto-generated method stub
		String sql = "update postgraduate set name = '"+student.getName()+"'";
		sql += ",sn = '" + student.getSn() + "'";
		sql += ",sex = '" + student.getSex() + "'";
		sql += ",birthday = '" + student.getBirthday() + "'";
		sql += ",grade = '" + student.getGrade() + "'";
		sql += ",major = '" + student.getMajor() + "'";
		sql += ",tutor = '" + student.getTutor() + "'";
		sql += ",researchDir = " + student.getResearchDir();
		sql += " where id = " + student.getId();
		return update(sql);
	}
	public boolean deleteStudent(String ids) {
		// TODO Auto-generated method stub
		String sql = "delete from postgraduate where id in("+ids+")";
		return update(sql);
	}
	public Postgraduate getStudent(int id){
		String sql = "select * from postgraduate where id = " + id;
		Postgraduate student = null;
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				student = new Postgraduate();
				student.setId(resultSet.getInt("id"));
				student.setResearchDir(resultSet.getString("researchDir"));
				student.setBirthday(resultSet.getString("birthday"));
				student.setName(resultSet.getString("name"));
				student.setPassword(resultSet.getString("password"));
				student.setTutor(resultSet.getString("tutor"));
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
	public List<Postgraduate> getStudentList(Postgraduate student,Page page){
		List<Postgraduate> ret = new ArrayList<Postgraduate>();
		String sql = "select * from postgraduate ";
		if(!StringUtil.isEmpty(student.getName())){
			sql += "and name like '%" + student.getName() + "%'";
		}
		if(student.getId() != 0){
			sql += " and id = " + student.getId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				Postgraduate s = new Postgraduate();
				s.setId(resultSet.getInt("id"));
				s.setResearchDir(resultSet.getString("researchDir"));
				s.setBirthday(resultSet.getString("birthday"));
				s.setName(resultSet.getString("name"));
				s.setPassword(resultSet.getString("password"));
				s.setTutor(resultSet.getString("tutor"));
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
	
	public int getStudentListTotal(Postgraduate student){
		int total = 0;
		String sql = "select count(*)as total from postgraduate ";
		if(!StringUtil.isEmpty(student.getName())){
			sql += "and name like '%" + student.getName() + "%'";
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

	public Postgraduate login(String name ,String password){
		String sql = "select * from postgraduate where name = '" + name + "' and password = '" + password + "'";
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				Postgraduate student = new Postgraduate();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setPassword(resultSet.getString("password"));
				student.setResearchDir(resultSet.getString("researchDir"));
				student.setBirthday(resultSet.getString("birthday"));
				student.setTutor(resultSet.getString("tutor"));
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
	public boolean editPassword(Postgraduate student,String newPassword) {
		// TODO Auto-generated method stub
		String sql = "update postgraduate set password = '"+newPassword+"' where id = " + student.getId();
		return update(sql);
	}
}
