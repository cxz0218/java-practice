package com.ischoolbar.programmer.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ischoolbar.programmer.dao.AdminDao;
import com.ischoolbar.programmer.dao.PostgraduateDao;
import com.ischoolbar.programmer.dao.StudentDao;
import com.ischoolbar.programmer.dao.TeacherDao;
import com.ischoolbar.programmer.model.Admin;
import com.ischoolbar.programmer.model.Postgraduate;
import com.ischoolbar.programmer.model.Student;
import com.ischoolbar.programmer.model.Teacher;

/**
 * 
 * @author future ��¼��֤servlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5870852067427524781L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String method = request.getParameter("method");
		// �˳���¼
		if ("logout".equals(method)) {
			logout(request, response);
			return;
		}
		String name = request.getParameter("account");
		String password = request.getParameter("password");
		int type = Integer.parseInt(request.getParameter("type"));// �ж��û�����
		// �Ա��û��������Ƿ���ȷ
		String loginStatus = "loginFaild";
		switch (type) {
		case 1: {
			AdminDao adminDao = new AdminDao();
			Admin admin = adminDao.login(name, password);
			adminDao.closeCon();
			if (admin == null) {
				response.getWriter().write("loginError");
				return;
			}
			// �û���������ȷ
			// �洢session������Ϣ
			HttpSession session = request.getSession();
			session.setAttribute("user", admin);
			session.setAttribute("userType", type);
			loginStatus = "loginSuccess";
			break;
		}
		case 2: {
			StudentDao studentDao = new StudentDao();
			Student student = studentDao.login(name, password);
			studentDao.closeCon();
			if (student == null) {
				response.getWriter().write("loginError");
				return;
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", student);
			session.setAttribute("userType", type);
			loginStatus = "loginSuccess";
			break;
		}
		case 3: {
			PostgraduateDao postgraduateDao = new PostgraduateDao();
			Postgraduate postgraduate = postgraduateDao.login(name, password);
			postgraduateDao.closeCon();
			if (postgraduate == null) {
				response.getWriter().write("loginError");
				return;
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", postgraduate);
			session.setAttribute("userType", type);
			loginStatus = "loginSuccess";
			break;
		}
		case 4: {
			TeacherDao teahcerDao = new TeacherDao();
			Teacher teacher = teahcerDao.login(name, password);
			teahcerDao.closeCon();
			if (teacher == null) {
				response.getWriter().write("loginError");
				return;
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", teacher);
			session.setAttribute("userType", type);
			loginStatus = "loginSuccess";
			break;
		}
		default:
			break;
		}
		response.getWriter().write(loginStatus);

	}

	// ��ȫ�˳�
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// remove �˳����ص�index.jsp
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("userType");
		response.sendRedirect("index.jsp");
	}
}
