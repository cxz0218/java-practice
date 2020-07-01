/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���õ�һʵ������ɶ����ݿ�����ӣ�ͬʱ�ṩ�ر����ݿⷽ��
 * @author future
 *
 */
public class DatabaseUtil {

	 // ?useUnicode=true&characterEncoding=UTF-8�ǽ�������ȡ���ݿ�ʱ������������,
	// &serverTimezone=GMT������ݿ����ӳ���ʱ����������
		private String url = "jdbc:mysql://localhost:3306/librarysystem?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
		private String userName = "root";
		private String password = "admin";
		private static DatabaseUtil instance = null;//��һʵ��ģʽ

		static {
			// ��̬ģ��ע�ᣬ��ֻ֤ע��һ��
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("--DatabaseUtil--,Cannot find Class : MySQL Jdbc Driver");
			}

		}

		private DatabaseUtil() {
		}

		/**
		 * ͨ���÷�����ȡ���󣬱�֤��һʵ��
		 * 
		 * @return DatabaseUtil
		 */
		public static DatabaseUtil getInstance() {
			// ��������ֹ����
			synchronized (DatabaseUtil.class) {
				if (instance == null) {
					instance = new DatabaseUtil();
				}
			}
			return instance;
		}

		/**
		 *  ��ȡ���ݿ�����
		 * 
		 * @return Connection
		 */
		public Connection getConnection() throws SQLException {
			return DriverManager.getConnection(url, userName, password);
		}

		/**
		 * �رյ�ǰ���ݿ������
		 * 
		 * @param conn
		 * @param st
		 * @param rs
		 */
		public void closeConnection(Connection conn, Statement st, ResultSet rs) {
			try {
				if (rs != null) {
					rs.close();
					System.out.println("���ݿ������ѹرգ�");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (st != null) {
						st.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

