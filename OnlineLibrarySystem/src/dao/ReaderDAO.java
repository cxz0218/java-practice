package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.Reader;
import util.DatabaseUtil;

public class ReaderDAO {
	/**
	 * ��ȡreader����
	 * 
	 */
	public int getTotal() {
		Connection conn = null;// �������Ӷ���con
		Statement st = null;// statement����
		ResultSet rs = null;// �����
		try {
			conn = DatabaseUtil.getInstance().getConnection();// �������
			st = conn.createStatement();
			String sql = "SELECT COUNT(*) AS total FROM reader";
			System.out.println("�������ݿ������" + sql);
			rs = st.executeQuery(sql);
			int total = 0;
			while (rs.next()) {
				total = rs.getInt("total");
			}
			rs.close();
			st.close();
			conn.close();
			return total;
		} catch (Exception e) {
			System.out.println("--ReaderDAO--,--getTotal--,suffers exception");
			// TODO: handle exception
			return 0;
		}
	}

	/**
	 * ��ȡ���е�reader����ҳ��ʾ
	 * 
	 */
	public List getAllReaders(int start, int count) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Reader> list = new ArrayList<>();
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "SELECT * FROM reader LIMIT " + start + "," + count;
			System.out.println("�������ݿ������" + sql);
			rs = st.executeQuery(sql);
			while (rs.next()){
				Reader reader = getReaderById(rs.getInt("reader_id"));
				list.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
			return list;
		} catch (Exception e) {
			System.out.println("--ReaderDAO--,--getAllReaders--,suffers exception");
			return null;
		}
	}


	
	/**
	 * ��ȡ���е�reader����ҳ��ʾ
	 */
	public List<Reader> getAllReaders(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Reader> list = new ArrayList<>();
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "SELECT * FROM reader";
			System.out.println("�������ݿ������" + sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = getReaderById(rs.getInt("reader_id"));
				list.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
			return list;
		} catch (Exception e) {
			System.out.println("--ReaderDAO--,--getAllReaders--,suffers exception");
			return null;
		}	
	}
	/**
	 *  librarian���reader����Ϣ
	 *  @return �������ɹ����򷵻�id���������ʧ�ܣ��򷵻�-1
	 */
	public int addReaderByName_Passowrd_State(String name, String password, String state) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int readerId = -1;// ��ʼ��Ϊ-1
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			// ��������
			conn.setAutoCommit(false);
			st= conn.createStatement();
			// �������
			String sql = "insert into reader(reader_name,reaber_password,state,reader_email) values('"+ name + "','"
			+ password + "','"+ state + "','default')";
			st.executeUpdate(sql);
			// ��ȡ���ݣ�����reader_idΪ��������˻�ȡ�������ֵ����Ϊ�ո���ӵ�����
			sql = "select reader_id from reader order by reader_id desc limit 1";
			rs = st.executeQuery(sql);
			if(rs.next()) {
				readerId = rs.getInt("reader_id");
			}
			// �ύ����
						conn.commit();
						// �ر�����
						st.close();
						conn.close();
						return readerId;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--ReaderDAO--,--addReaderByName_Passowrd_State()--,suffers exception");
			return readerId;
		}
		
	}
/**
 * �����û�������Ϣ
 */
	public int updateReaderInformation(int id, String name, String password, String email) {
		int flag = 0;
		Connection conn = null;
		Statement st = null;
		boolean rs;
		String sql = null;
		sql = "update reader set reader_name= \'" + name + "\' ,reader_password=\'" + password + "\', reader_email=\'"
				+ email + "\' where reader_id=" + String.valueOf(id);
		System.out.println("update reader info sql:" + sql);
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.execute(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return flag;
	}
/**
 *  ����id��nameɾ��Reader
 *  @return id��name��ƥ�����id�����ڷ���false��ɾ���ɹ�����true
 */
	public boolean deleteReaderById(int id, String name) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			String query = "select * from reader where reader_id=" + id + " and reader_name='" + name + "'";
			rs = st.executeQuery(query);
			if (rs.next()) {
				String sql = "delete from reader where reader_id=" + id;
				int row = st.executeUpdate(sql);
				if (row == 1) {//����һ����¼
					flag = true;
				}
			} else {
				System.out.println("--ReaderDAO--,--deleteReaderById()--,id��nam��ƥ��");
				flag = false;
			}
			conn.commit();
			rs.close();
			st.close();
			conn.close();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--ReaderDAO--,--deleteReaderById()--,suffers exception");
			return false;
		}
	}
/**
 * ����Reader ID��ȡReaderʵ��
 */
	public Reader getReaderById(int id) {
		Reader reader = new Reader();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		System.out.println("����byid����");
		try {
			System.out.println("�������ݿ�֮ǰ");
			conn = DatabaseUtil.getInstance().getConnection();
			System.out.println("�������ݿ�֮ǰ��");
			st = conn.createStatement();
			String sql = "select *from reader where reader_id = " + id; 
			System.out.println("���ݿ�Ľ��"+ sql);
			rs = st.executeQuery(sql);
			if (rs.next()) {
				//��ȡ����
				String  name = rs.getString("reader_name");
				String  password = rs.getString("reader_password");
				String email = rs.getString("reader_email");
				String state = rs.getString("state");
				System.out.println("����");
				System.out.println(name);
				//��װʵ��
				System.out.println("����:" + name);
				reader.setId(id);
				reader.setName(name);
				reader.setPassword(password);
				reader.setState(state);
				reader.setEmail(email);
				rs.close();
				st.close();
				conn.close();
				return reader;
			} else {
				System.out.println("--ReaderDAO--,--getReaderById()--,Cannot find the Reader by id=" + id);
				rs.close();
				st.close();
				conn.close();
				return null;
			}
		} catch (Exception e) {
			System.out.println("--ReaderDAO--,--getReaderById()--,suffers exception");
			return null;
		}
	}
	
/**
 * �޸��û���Ϣ
 */
	public boolean updateData(int id, String name, String password, String email, String state) {
		Connection conn = null;
		Statement st = null;
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "update reader set reader_name='" + name + "',reader_password='"+ password  
					+ "',reader_email ='" + email + "',state= '"+state+"' where reader_id =" + id;
			st.executeUpdate(sql);
			st.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("--Reader--,--updateData()--,suffers exception");
			return false;
		}
		
	}

	/**
	 * ����state��ѯ�û��������û��б�
	 */
	public List<Reader> getReaderByState(String state) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Reader> list = new ArrayList<Reader>();
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "select * from reader where state ='" + state + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = getReaderById(rs.getInt("reader_id"));
				list.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * ����reader_name��ȡ�����б����ǵ����readerͬһ��name�������
	 * 
	 */
	public List<Reader> getReaderByName(String name) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Reader> list = new ArrayList<Reader>();
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "select * from reader where reader_name like '%" + name + "%'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = getReaderById(rs.getInt("reader_id"));// ����reader_id��ȡһ��readerʵ��
				list.add(reader);// ��ӵ��б���
			}
			rs.close();
			st.close();
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * ����reader_name��ȡ�����б�,��ҳչʾ
	 */
	public List<Reader> getReaderByName(String name, int start, int count) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Reader> list = new ArrayList<Reader>();
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "select * from reader where reader_name like '%" + name + "%' LIMIT " + start + "," + count;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = getReaderById(rs.getInt("reader_id"));// ����reader_id��ȡһ��readerʵ��
				list.add(reader);// ��ӵ��б���
			}
			rs.close();
			st.close();
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * �����û�����state��ȡ�����б�
	 */
	public List<Reader> getReaderByName_State(String name, String state) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Reader> list = new ArrayList<Reader>();
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "select * from reader where state ='" + state + "' and name like '" + name + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = getReaderById(rs.getInt("reader_id"));
				list.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}

	}
	
	/**
	 * �����û�����state��ȡ�����б���ҳչʾ
	 * 
	 */
	public List<Reader> getReaderByName_State(String name, String state, int start, int count) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Reader> list = new ArrayList<Reader>();
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "select * from reader where state ='" + state + "' and name like ''%" + name + "%' LIMIT " + start + "," + count;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = getReaderById(rs.getInt("reader_id"));
				list.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
			return list;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * ����readerID��ȡ��reader����ͼ�������
	 * 
	 */
	public int getBorrowTotal(int readerId) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int total = 0;
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			String sql = "SELECT COUNT(*) AS borrowTotal  " + "FROM borrow_item " + "WHERE return_time IS NULL "
					+ "AND reader_id=" + readerId;
			rs = st.executeQuery(sql);
			if (rs.next()) {
				total = rs.getInt("borrowTotal");
			}
			rs.close();
			st.close();
			conn.close();
			return total;
		} catch (Exception e) {
			System.out.println("--ReaderDAO--,getBorrowTotal(),suffers exception");
			return -1;
		}

	}
}
