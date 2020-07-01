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
 * 该类用于处理登录请求，根据权限（Reader/Librarian/Administrator）分发到不同的servlet
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
		// 如果用户的身份，登录id，密码三者中任何一种没有填写则让用户重新填写
		if (request.getParameter("authority") == null || request.getParameter("userID") == null
				|| request.getParameter("password") == null || request.getParameter("authority").equals("")
				|| request.getParameter("userID").equals("") || request.getParameter("password").equals("")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			// 获取参数
			String authority = (String) request.getParameter("authority");
			String userId = request.getParameter("userID");
			int id = Integer.parseInt(userId);
			System.out.println("loginService 学号" + id);
			String password = request.getParameter("password");
			System.out.println("loginService 密码" + password);
			String isRemember = request.getParameter("isRemember");
			System.out.println("isRemember=" + isRemember);
			// 如果用户选择记住密码
			if (isRemember != null) {
				rememberPassword(userId, password, authority, request, response);// 保存密码
			} else {
				forgetPassword(userId, request, response);
			}
			// 判断用户的身份转向不同的servlet
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

	// 保存用户账号
	private void rememberPassword(String userId, String password, String authority, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();//获取cookies
		System.out.println(cookies);
		boolean hasAccountCookie = false;	// 开始设置用户账号没有cookies
		Cookie accountCookie = null; //创建accountCookie
		if (cookies != null) {// 如果cookies不为空（一定不为空，有系统自带的cookie）
			for (Cookie cookie : cookies) {
				// 遍历cookies，找到名称为account的cookie
				if (cookie.getName().equals("account")) {
					accountCookie = cookie;// 初始化
					hasAccountCookie = true;
					break;
				}
			}

			if (hasAccountCookie == true) {
				String cookieValue = accountCookie.getValue();
				System.out.println("--LoginService--,cookieValue=" + cookieValue);
				boolean hasStore = false; // 开始设置没有保存账号
				// 查找是否保存过账号
				if (cookieValue.contains("&")) {//有多个账号
					String[] accounts = cookieValue.split("&");
					for (int i = 0; i < accounts.length; i++) {
						System.out.println("accounts[" + i + "]=" + accounts[i]);
						if (accounts[i].split("=")[0].equals(userId)) {
							hasStore = true;
							break;
						}
					}
				} else {//只有一个账户
					if (cookieValue.split("=")[0].equals(userId)) {
						hasStore = true;
					}
				}

				// 如果没有保存账号，则把账户保存到cookies里面
				if (hasStore == false) {
					System.out.println("userId=" + userId);
					System.out.println("password=" + password);
					System.out.println("authority=" + authority);
					cookieValue += "&" + userId + "=" + password + "=" + authority;
					Cookie cookie = new Cookie("account", cookieValue);// 更新cookie的值
					cookie.setMaxAge(60 * 60 * 24);
					response.addCookie(cookie);
					System.out.println("--LoginService--,添加新的账户");
				} else {
					System.out.println("--LoginService--,该账户已被保存");
				}
			} else {// 首次保存密码，直接初始化一个cookie
				Cookie cookie = new Cookie("account", userId + "=" + password + "=" + authority);
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
			}
		} else {
			return;
		}
	}

	// 忘记密码之后修改密码
	private void forgetPassword(String userId, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		boolean hasAccountCookie = false;
		Cookie accountCookie = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// 遍历cookies，找到名称为account的cookie
				if (cookie.getName().equals("account")) {
					accountCookie = cookie;// 初始化
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
							k = i ;//记住之前密码的位置
							break;
						}
					}
					String newCookieValue = "";
//					如果修改的账户不是cookie中的第一个
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
//						若果修改的账户是cookie中的第一个
						newCookieValue = accounts [1];
						for(int i = 2;i < accounts.length;i++){
							newCookieValue += "&" + accounts[i];
						}
					}
					System.out.println("newCookieValue=" + newCookieValue);
					Cookie cookie = new Cookie("account", newCookieValue);
					response.addCookie(cookie);
				} else {//仅有一个account
					System.out.println("--LoginServcie--,--forgetPassword()--,仅有一个账号");
					if(cookieValue.split("=")[0].equals(userId)){
						Cookie cookie = new Cookie("account", "");
						cookie.setMaxAge(1);// 失效
						response.addCookie(cookie);
					}
				}
			} else {//密码没有保存到cookies中
				System.out.println("--LoginServcie--,--forgetPassword()--,没有记录");
				return;
			}
		} else {
			return ;
		}
	}

}
