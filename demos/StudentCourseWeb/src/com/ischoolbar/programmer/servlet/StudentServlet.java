  package com.ischoolbar.programmer.servlet;

import java.io.IOException;
import java.text.ParseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ischoolbar.programmer.dao.StudentDao;
import com.ischoolbar.programmer.model.Page;
import com.ischoolbar.programmer.model.Student;
import com.ischoolbar.programmer.util.SnGenerateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 * @author future
 *本科生信息管理功能实现servlet
 */
public class StudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String method = request.getParameter("method");
		if("toStudentListView".equals(method)){
			studentList(request,response);
		}else if("AddStudent".equals(method)){
			try {
				addStudent(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("StudentList".equals(method)){
			getStudentList(request,response);
		}else if("EditStudent".equals(method)){
			try {
				editStudent(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("DeleteStudent".equals(method)){
			deleteStudent(request,response);
		}
	}
	//删除
	private void deleteStudent(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String[] ids = request.getParameterValues("ids[]");
		String idStr = "";
		for(String id : ids){
			idStr += id + ",";
		}
		idStr = idStr.substring(0, idStr.length()-1);
		StudentDao studentDao = new StudentDao();
		if(studentDao.deleteStudent(idStr)){
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				studentDao.closeCon();
			}
		}
	}
	
	//修改
	private void editStudent(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		// TODO Auto-generated method stub
		String sn = request.getParameter("sn");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String sex = request.getParameter("sex");	
//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    //string---Date
//		Date bd = null;
//		Date birthday = sdf.parse(request.getParameter("birthday"));
		String birthday = request.getParameter("birthday");
		String grade = request.getParameter("grade");
		String major = request.getParameter("major");
		String headteacher = request.getParameter("headteacher");
		int clazzId = Integer.parseInt(request.getParameter("clazzid"));
		Student student = new Student();
		student.setSn(sn);
		student.setClazzId(clazzId);
		student.setBirthday(birthday);
		student.setGrade(grade);
		student.setName(name);
		student.setId(id);
		student.setHeadteacher(headteacher);
		student.setMajor(major);
		student.setSex(sex);
		StudentDao studentDao = new StudentDao();
		if(studentDao.editStudent(student)){
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				studentDao.closeCon();
			}
		}
	}
	private void getStudentList(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("studentName");
		Integer currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Integer pageSize = request.getParameter("rows") == null ? 999 : Integer.parseInt(request.getParameter("rows"));
		Integer clazz = request.getParameter("clazzid") == null ? 0 : Integer.parseInt(request.getParameter("clazzid"));
		//获取当前登录用户类型
		int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
		Student student = new Student();
		student.setName(name);
		student.setClazzId(clazz);
		if(userType == 2){
			//如果是学生，只能查看自己的信息
			Student currentUser = (Student)request.getSession().getAttribute("user");
			student.setId(currentUser.getId());
		}
		StudentDao studentDao = new StudentDao();
		List<Student> clazzList = studentDao.getStudentList(student, new Page(currentPage, pageSize));
		int total = studentDao.getStudentListTotal(student);
		studentDao.closeCon();
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("total", total);
		ret.put("rows", clazzList);
		try {
			String from = request.getParameter("from");
			if("combox".equals(from)){
				response.getWriter().write(JSONArray.fromObject(clazzList).toString());
			}else{
				response.getWriter().write(JSONObject.fromObject(ret).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//添加
	private void addStudent(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		// TODO Auto-generated method stub
		//String sn = request.getParameter("sn");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date birthday = sdf.parse(request.getParameter("birthday"));
		String birthday = request.getParameter("birthday");
		String grade = request.getParameter("grade");
		String headteacher = request.getParameter("headteacher");
		String major = request.getParameter("major");
		int clazzId = Integer.parseInt(request.getParameter("clazzid"));
		Student student = new Student();
		student.setClazzId(clazzId);
		student.setBirthday(birthday);
		student.setName(name);
		student.setPassword(password);
		student.setGrade(grade);
		student.setHeadteacher(headteacher);
		student.setMajor(major);
		student.setSex(sex);
		student.setSn(SnGenerateUtil.generateSn(clazzId));
		StudentDao studentDao = new StudentDao();
		if(studentDao.addStudent(student)){
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				studentDao.closeCon();
			}
		}
	}
	//学生列表
	private void studentList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		try {
			request.getRequestDispatcher("view/studentList.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
