/**
 * 
 */
package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �������ڴ����¼���󣬸���Ȩ�ޣ�Reader/Librarian/Administrator���ַ�����ͬ��servlet
 * 
 * @author future
 *
 */
public class LoginService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����û�����ݣ���¼id�������������κ�һ��û����д�����û�������д
		if (request.getParameter("authority") == null || request.getParameter("userID") == null
				|| request.getParameter("password") == null || request.getParameter("authority").equals("")
				|| request.getParameter("userID").equals("") || request.getParameter("password").equals("")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			// ��ȡ����
			String authority = (String) request.getParameter("authority");
			String userId = request.getParameter("userID");
			int id = Integer.parseInt(userId);
			System.out.println("loginService ѧ��" + id);
			String password = request.getParameter("password");
			System.out.println("loginService ����" + password);
			String isRemember = request.getParameter("isRemember");
			System.out.println("isRemember=" + isRemember);
			// ����û�ѡ���ס����
			if (isRemember != null) {
				rememberPassword(userId, password, authority, request, response);// ��������
			} else {
				forgetPassword(userId, request, response);
			}
			// �ж��û������ת��ͬ��servlet
			if (authority.equals("reader")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ReaderLogin");
				dispatcher.forward(request, response);
			} else if (authority.equals("librarian")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("LibrarianLogin");
				dispatcher.forward(request, response);
			} else if (authority.equals("administrator")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdministratorLogin");
				dispatcher.forward(request, response);
			}
		}
	}

	// �����û��˺�
	private void rememberPassword(String userId, String password, String authority, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();//��ȡcookies
		System.out.println(cookies);
		boolean hasAccountCookie = false;	// ��ʼ�����û��˺�û��cookies
		Cookie accountCookie = null; //����accountCookie
		if (cookies != null) {// ���cookies��Ϊ�գ�һ����Ϊ�գ���ϵͳ�Դ���cookie��
			for (Cookie cookie : cookies) {
				// ����cookies���ҵ�����Ϊaccount��cookie
				if (cookie.getName().equals("account")) {
					accountCookie = cookie;// ��ʼ��
					hasAccountCookie = true;
					break;
				}
			}

			if (hasAccountCookie == true) {
				String cookieValue = accountCookie.getValue();
				System.out.println("--LoginService--,cookieValue=" + cookieValue);
				boolean hasStore = false; // ��ʼ����û�б����˺�
				// �����Ƿ񱣴���˺�
				if (cookieValue.contains("&")) {//�ж���˺�
					String[] accounts = cookieValue.split("&");
					for (int i = 0; i < accounts.length; i++) {
						System.out.println("accounts[" + i + "]=" + accounts[i]);
						if (accounts[i].split("=")[0].equals(userId)) {
							hasStore = true;
							break;
						}
					}
				} else {//ֻ��һ���˻�
					if (cookieValue.split("=")[0].equals(userId)) {
						hasStore = true;
					}
				}

				// ���û�б����˺ţ�����˻����浽cookies����
				if (hasStore == false) {
					System.out.println("userId=" + userId);
					System.out.println("password=" + password);
					System.out.println("authority=" + authority);
					cookieValue += "&" + userId + "=" + password + "=" + authority;
					Cookie cookie = new Cookie("account", cookieValue);// ����cookie��ֵ
					cookie.setMaxAge(60 * 60 * 24);
					response.addCookie(cookie);
					System.out.println("--LoginService--,����µ��˻�");
				} else {
					System.out.println("--LoginService--,���˻��ѱ�����");
				}
			} else {// �״α������룬ֱ�ӳ�ʼ��һ��cookie
				Cookie cookie = new Cookie("account", userId + "=" + password + "=" + authority);
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
			}
		} else {
			return;
		}
	}

	// ��������֮���޸�����
	private void forgetPassword(String userId, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		boolean hasAccountCookie = false;
		Cookie accountCookie = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// ����cookies���ҵ�����Ϊaccount��cookie
				if (cookie.getName().equals("account")) {
					accountCookie = cookie;// ��ʼ��
					hasAccountCookie = true;
					break;
				}
			}
			if (hasAccountCookie == true) {
				String cookieValue = accountCookie.getValue();
				if (cookieValue.contains("&")) {
					String[] accounts = cookieValue.split("&");
					int k = -1;
					for(int i = 0 ;i < accounts.length ;i++) {
						if(accounts[i].split("=")[0].equals(userId)) {
							k = i ;//��ס֮ǰ�����λ��
							break;
						}
					}
					String newCookieValue = "";
//					����޸ĵ��˻�����cookie�еĵ�һ��
					if (k != 0) {
						newCookieValue = accounts[0];
						for (int i = 1;i <accounts.length;i++) {
							if(k == i) {
								continue;
							} else {
								newCookieValue+= "&" + accounts[i];   
							}
						}
										
					} else {
//						�����޸ĵ��˻���cookie�еĵ�һ��
						newCookieValue = accounts [1];
						for(int i = 2;i < accounts.length;i++){
							newCookieValue += "&" + accounts[i];
						}
					}
					System.out.println("newCookieValue=" + newCookieValue);
					Cookie cookie = new Cookie("account", newCookieValue);
					response.addCookie(cookie);
				} else {//����һ��account
					System.out.println("--LoginServcie--,--forgetPassword()--,����һ���˺�");
					if(cookieValue.split("=")[0].equals(userId)){
						Cookie cookie = new Cookie("account", "");
						cookie.setMaxAge(1);// ʧЧ
						response.addCookie(cookie);
					}
				}
			} else {//����û�б��浽cookies��
				System.out.println("--LoginServcie--,--forgetPassword()--,û�м�¼");
				return;
			}
		} else {
			return ;
		}
	}

}
