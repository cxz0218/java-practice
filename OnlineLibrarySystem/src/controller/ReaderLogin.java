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
 * ʵ���û���¼����
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
	 * ʵ��Reader�û���½���ж������ID�Ƿ����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String usersid = (String) request.getParameter("userID");// ��ȡ�ͻ����û������id
		int userid = Integer.MAX_VALUE;
		if (usersid != null && !usersid.isEmpty()) {
			userid = Integer.valueOf(usersid);// ת��Ϊint����
			String password = (String) request.getParameter("password");
			System.out.println("readerLogin �û���" + usersid);
			System.out.println("readerLogin  ����" + password);
			if (request.getParameter("userID") == null || request.getParameter("password") == null
					|| request.getParameter("userID").equals("") || request.getParameter("password").equals("")) {
				out.print(
						"<script language='javascript'>alert('Reader ID or Password Can Not Be Empty!');window.location.href='login.jsp';</script>");
			} else {
				ReaderDAO readerDAO = new ReaderDAO();
				Reader reader = null;
				if (CharacterFilterUtil.isNumeric(usersid)) {
					System.out.println("����Chara"+ usersid );
					reader = readerDAO.getReaderById(userid);
				}
				if (reader == null) {
					out.print(
							"<script language='javascript'>alert('ReaderID Not Exist!');window.location.href='login.jsp';</script>");
				} else {
					password = SecurityUtil.md5(password);
					System.out.println(reader.getPassword());
					System.out.println(password);
					if (reader.getPassword().equals(password)) {// ������ȷ
						if (reader.getState().equals("unlock")) {
							System.out.println("���˻�unlock");
							HttpSession session = request.getSession();// ����session
							session.setAttribute("ReaderEntity", reader);// ����session���ԣ��Ա����ʹ��
							response.sendRedirect("libraryHome.jsp");// ��¼�ɹ�����ͼ��ݹ��ܽ���
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