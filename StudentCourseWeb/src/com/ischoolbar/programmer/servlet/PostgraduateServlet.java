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

import com.ischoolbar.programmer.dao.PostgraduateDao;
import com.ischoolbar.programmer.model.Page;
import com.ischoolbar.programmer.model.Postgraduate;

import com.ischoolbar.programmer.util.SnGenerateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject; 
/**
 * 
 * @author future
 *研究生信息管理功能实现servlet
 */
public class PostgraduateServlet extends HttpServlet {
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
			editStudent(request,response);
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
		PostgraduateDao studentDao = new PostgraduateDao();
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
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sn = request.getParameter("sn");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String grade = request.getParameter("grade");
		String major = request.getParameter("major");
		String tutor = request.getParameter("tutor");
		String researchDir = request.getParameter("researchDir");
		Postgraduate postgraduate = new Postgraduate();
		postgraduate.setSn(sn);
		postgraduate.setResearchDir(researchDir);
		postgraduate.setBirthday(birthday);
		postgraduate.setGrade(grade);
		postgraduate.setName(name);
		postgraduate.setId(id);
		postgraduate.setTutor(tutor);
		postgraduate.setMajor(major);
		postgraduate.setSex(sex);
		PostgraduateDao postgraduateDao = new PostgraduateDao();
		if(postgraduateDao.editStudent(postgraduate)){
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				postgraduateDao.closeCon();
			}
		}
	}
	private void getStudentList(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("studentName");
		Integer currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Integer pageSize = request.getParameter("rows") == null ? 999 : Integer.parseInt(request.getParameter("rows"));
		//Integer clazz = request.getParameter("clazzid") == null ? 0 : Integer.parseInt(request.getParameter("clazzid"));
		//获取当前登录用户类型
		int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
		Postgraduate postgraduate = new Postgraduate();
		postgraduate.setName(name);
		//postgraduate.setClazzId(clazz);
		if(userType == 4){
			//如果是研究生，只能查看自己的信息
			Postgraduate currentUser = (Postgraduate)request.getSession().getAttribute("user");
			postgraduate.setId(currentUser.getId());
		}
		PostgraduateDao postgraduateDao = new PostgraduateDao();
		List<Postgraduate> clazzList = postgraduateDao.getStudentList(postgraduate, new Page(currentPage, pageSize));
		int total = postgraduateDao.getStudentListTotal(postgraduate);
		postgraduateDao.closeCon();
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
		String birthday = request.getParameter("birthday");
		String grade = request.getParameter("grade");
		String tutor = request.getParameter("tutor");
		String major = request.getParameter("major");
		String researchDir = request.getParameter("researchDir");
		Postgraduate student = new Postgraduate();
		//student.setSn(sn);
		student.setResearchDir(researchDir);
		student.setBirthday(birthday);
		student.setName(name);
		student.setPassword(password);
		student.setGrade(grade);
		student.setTutor(tutor);
		student.setMajor(major);
		student.setSex(sex);
		student.setSn(SnGenerateUtil.generatePostgraduateSn(grade));
		System.out.println(SnGenerateUtil.generatePostgraduateSn(grade));
		PostgraduateDao studentDao = new PostgraduateDao();
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
			request.getRequestDispatcher("view/postStudentList.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
