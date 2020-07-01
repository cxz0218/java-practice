/**
 * 
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReaderDAO;
import entity.Reader;
import util.CharacterFilterUtil;
import util.SecurityUtil;

/**
 * 实现用户登录功能
 * 
 * @author future
 *
 */
public class ReaderLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReaderLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 实现Reader用户登陆，判断密码和ID是否相符
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String usersid = (String) request.getParameter("userID");// 获取客户端用户输入的id
		int userid = Integer.MAX_VALUE;
		if (usersid != null && !usersid.isEmpty()) {
			userid = Integer.valueOf(usersid);// 转化为int类型
			String password = (String) request.getParameter("password");
			System.out.println("readerLogin 用户名" + usersid);
			System.out.println("readerLogin  密码" + password);
			if (request.getParameter("userID") == null || request.getParameter("password") == null
					|| request.getParameter("userID").equals("") || request.getParameter("password").equals("")) {
				out.print(
						"<script language='javascript'>alert('Reader ID or Password Can Not Be Empty!');window.location.href='login.jsp';</script>");
			} else {
				ReaderDAO readerDAO = new ReaderDAO();
				Reader reader = null;
				if (CharacterFilterUtil.isNumeric(usersid)) {
					System.out.println("进入Chara"+ usersid );
					reader = readerDAO.getReaderById(userid);
				}
				if (reader == null) {
					out.print(
							"<script language='javascript'>alert('ReaderID Not Exist!');window.location.href='login.jsp';</script>");
				} else {
					password = SecurityUtil.md5(password);
					System.out.println(reader.getPassword());
					System.out.println(password);
					if (reader.getPassword().equals(password)) {// 密码正确
						if (reader.getState().equals("unlock")) {
							System.out.println("改账户unlock");
							HttpSession session = request.getSession();// 创建session
							session.setAttribute("ReaderEntity", reader);// 设置session属性，以便后面使用
							response.sendRedirect("libraryHome.jsp");// 登录成功进入图书馆功能界面
						} else {
							out.print(
									"<script language='javascript'>alert('Your ReaderID has been locked!');windows.location.herf='login.jsp';</script>");
						}

					}else {
						out.print(
								"<script language='javascript'>alert('Your ReaderID or Password is Wrong!');window.location.href='login.jsp';</script>");
					}
				}
			}
		}
	}

}