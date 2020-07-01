package com.ischoolbar.programmer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ischoolbar.programmer.model.Course;
import com.ischoolbar.programmer.model.Page;
import com.ischoolbar.programmer.util.StringUtil;

/**
 * 
 *  @author future
 *课程数据库操作类
 */
public class CourseDao extends BaseDao {
	public boolean addCourse(Course course){
		String sql = "insert into course values(null,'"+course.getName()+"',"+course.getTeacherId()+",'"+course.getCredit()+"',0,"+course.getMaxNum()+",'"+course.getInfo()+"') ";
		return update(sql);
	}
	
	public List<Course> getCourseList(Course course,Page page){
		List<Course> ret = new ArrayList<Course>();
		String sql = "select * from course ";
		if(!StringUtil.isEmpty(course.getName())){
			sql += "and name like '%" + course.getName() + "%'";
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				Course cl = new Course();
				cl.setId(resultSet.getInt("id"));
				cl.setName(resultSet.getString("name"));
				cl.setTeacherId(resultSet.getInt("teacher_id"));
				cl.setCredit(resultSet.getString("credit"));
				cl.setSelectedNum(resultSet.getInt("selected_num"));
				cl.setMaxNum(resultSet.getInt("max_num"));
				cl.setInfo(resultSet.getString("info"));
				ret.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public int getCourseListTotal(Course course){
		int total = 0;
		String sql = "select count(*)as total from course ";
		if(!StringUtil.isEmpty(course.getName())){
			sql += "and name like '%" + course.getName() + "%'";
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
	public boolean editCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "update course set name = '"+course.getName()+"',teacher_id = "+course.getTeacherId()+",credit = '"+course.getCredit()+"',max_num = "+course.getMaxNum()+" ,info = '"+course.getInfo()+"' where id = " + course.getId();
		return update(sql);
	}
	public boolean deleteCourse(String ids) {
		// TODO Auto-generated method stub
		String sql = "delete from course where id in("+ids+")";
		return update(sql);
	}
	/**
	 * 检查该课程是否已选满
	 * @param courseId
	 * @return
	 */
	public boolean isFull(int courseId){
		boolean ret = false;
		String sql = "select * from course where selected_num >= max_num and id = " + courseId;
		ResultSet query = query(sql);
		try {
			if(query.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 更新课程已选人数
	 * @param courseId
	 */
	public void updateCourseSelectedNum(int courseId ,int num){
		String sql = "";
		if(num > 0){
			sql = "update course set selected_num = selected_num + "+ num + " where id = " + courseId;
		}else{
			sql = "update course set selected_num = selected_num - " + Math.abs(num) + " where id = " + courseId;
		}
		update(sql);
	}
	
}
