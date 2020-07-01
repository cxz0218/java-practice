package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import entity.Book;
import entity.Publisher;
import util.DatabaseUtil;

public class BookDAO {
	/**
	 * ����ISBN����ÿ���鼮��Ϣ,����ID����ҳչʾ
	 * @param isbn
	 * @param start
	 * @param count
	 * @return
	 */
	public Collection<Book> getBookListByIsbn(String isbn, int start, int count) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs;
		Book book = null;
		Collection bookColle = new ArrayList();
		String sql = null;
		if (isbn != "all" && isbn != "" && isbn != null) {
			sql = "select book_id,book.isbn,book_name,book_price,book_description,publisher.publisher_id,publisher_name,publisher_description,"
					+ "book_location,state,GROUP_CONCAT(distinct author.author_name SEPARATOR ',') "
					+ "from (((book join book_in_library on book.isbn=book_in_library.isbn) "
					+ " left join publisher on publisher.publisher_id=book.publisher_id) "
					+ " left join writes on writes.isbn=book.isbn "
					+ " left join author on author.author_id=writes.author_id) " + " where book.isbn = " + "\'" + isbn
					+ "\' group by book_id LIMIT " + start + "," + count;
		}else {
			return bookColle;
		}
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setISBN(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getBigDecimal("book_price"));
				book.setDescription(rs.getString("book_description"));
				// set publisher
				Publisher publisher1 = new Publisher();
				publisher1.setId(rs.getInt("publisher_id"));
				publisher1.setName(rs.getString("publisher_name"));
				publisher1.setDescription(rs.getString("publisher_description"));
				book.setPublisher(publisher1);
				// set author
				book.setAuthors(rs.getString("GROUP_CONCAT(distinct author.author_name SEPARATOR ',')"));
				book.setLocation(rs.getString("book_location"));
				book.setState(rs.getString("state"));
				bookColle.add(book);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookColle;
	}
	/**
	 * ͨ����Ŀ����ͼ��
	 */
	public Collection searchByTitle(String title) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs;
		Book book = null;
		Collection bookColle = new ArrayList();
		String sql = null;
		if (title != "all" && title != "" && title != null) {
			sql = "select book_id,book.isbn,book_name,book_price,book_description,publisher.publisher_id,publisher_name,publisher_description,book_location,state,GROUP_CONCAT(author.author_name SEPARATOR ',') from (((book left join book_in_library on book.isbn=book_in_library.isbn) "
					+ " left join publisher on publisher.publisher_id=book.publisher_id) "
					+ " left join writes on writes.isbn=book.isbn) "
					+ " left join author on author.author_id=writes.author_id " + " where book_name like " + "\'%"
					+ title + "%\' group by book_id ";
		} else {
			return bookColle;
		}
		System.out.println("searchByTitle sql:" + sql);
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getBigDecimal("book_price"));
				book.setDescription(rs.getString("book_description"));
				// set publisher
				Publisher publisher = new Publisher();
				publisher.setId(rs.getInt("publisher_id"));
				publisher.setName(rs.getString("publisher_name"));
				publisher.setDescription(rs.getString("publisher_description"));
				book.setPublisher(publisher);
				// set author
				book.setAuthors(rs.getString("GROUP_CONCAT(author.author_name SEPARATOR ',')"));
				book.setLocation(rs.getString("book_location"));
				book.setState(rs.getString("state"));
				bookColle.add(book);
			}
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bookColle;
	}
		/**
		 * ͨ����������ͼ��
		 * @param author
		 * @return
		 */
	public Collection searchByAuthor(String author) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs;
		Book book = null;
		Collection bookColle = new ArrayList();
		String sql = null;
		if (author != "all" && author != "" && author != null) {
			sql = "select book_id,book.isbn,book_name,book_price,book_description,publisher.publisher_id,publisher_name,publisher_description,book_location,state,GROUP_CONCAT(author.author_name SEPARATOR ',') from (((book left join book_in_library on book.isbn=book_in_library.isbn) "
					+ "left join publisher on publisher.publisher_id=book.publisher_id) "
					+ " left join writes on writes.isbn=book.isbn "
					+ " left join author on author.author_id=writes.author_id) " + " where author.author_name like "
					+ "\'%" + author + "%\'  group by book_id ";
		} else {
			return bookColle;
		}
		System.out.println("SearchByAuthor sql:" + sql);
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getBigDecimal("book_price"));
				book.setDescription(rs.getString("book_description"));
				// set publisher
				Publisher publisher = new Publisher();
				publisher.setId(rs.getInt("publisher_id"));
				publisher.setName(rs.getString("publisher_name"));
				publisher.setDescription(rs.getString("publisher_description"));
				book.setPublisher(publisher);
				// set author
				book.setAuthors(rs.getString("GROUP_CONCAT(author.author_name SEPARATOR ',')"));

				book.setLocation(rs.getString("book_location"));
				book.setState(rs.getString("state"));
				bookColle.add(book);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookColle;
		
	}
	/**
	 * ͨ������������ͼ��
	 * @param publisher
	 * @return
	 */
	public Collection searchByPublisher(String publisher) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs;
		Book book = null;
		Collection bookColle = new ArrayList();
		String sql = null;
		if (publisher != "all" && publisher != "" && publisher != null) {
			sql = "select book_id,book.isbn,book_name,book_price,book_description,publisher.publisher_id,publisher_name,publisher_description,book_location,state,GROUP_CONCAT(author.author_name SEPARATOR ',') from (((book join book_in_library on book.isbn=book_in_library.isbn) "
					+ " left join publisher on publisher.publisher_id=book.publisher_id) "
					+ " left join writes on writes.isbn=book.isbn "
					+ " left join author on author.author_id=writes.author_id) "
					+ " where publisher.publisher_name like " + "\'%" + publisher + "%\'  group by book_id";
		} else {
			return bookColle;
		}
		System.out.println("SearchByPublisher sql:" + sql);
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getBigDecimal("book_price"));
				book.setDescription(rs.getString("book_description"));
				// set publisher
				Publisher publisher1 = new Publisher();
				publisher1.setId(rs.getInt("publisher_id"));
				publisher1.setName(rs.getString("publisher_name"));
				publisher1.setDescription(rs.getString("publisher_description"));
				book.setPublisher(publisher1);
				// set author
				book.setAuthors(rs.getString("GROUP_CONCAT(author.author_name SEPARATOR ',')"));

				book.setLocation(rs.getString("book_location"));
				book.setState(rs.getString("state"));
				bookColle.add(book);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookColle;
	}
	
	/**
	 * ͨ��id��ѯͼ��
	 * @param id
	 * @return
	 */
	public Book searchByID(int id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs;
		Book book = null;
		String sql = null;
		sql = "select book_id,book.isbn,book_name,book_price,book_description,publisher.publisher_id,publisher_name,publisher_description,book_location,state,GROUP_CONCAT(author.author_name SEPARATOR ',') from (((book join book_in_library on book.isbn=book_in_library.isbn) "
				+ " left join publisher on publisher.publisher_id=book.publisher_id) "
				+ " left join writes on writes.isbn=book.isbn "
				+ " left join author on author.author_id=writes.author_id) " + " where book_in_library.book_id=" + id
				+ " group by book_id ";
		System.out.println("SearchByID sql:" + sql);
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("book_id"));// zengyaoNPU���
				book.setISBN(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getBigDecimal("book_price"));
				book.setDescription(rs.getString("book_description"));
				// set publisher
				Publisher publisher1 = new Publisher();
				publisher1.setId(rs.getInt("publisher_id"));
				publisher1.setName(rs.getString("publisher_name"));
				publisher1.setDescription(rs.getString("publisher_description"));
				book.setPublisher(publisher1);
				// set author
				book.setAuthors(rs.getString("GROUP_CONCAT(author.author_name SEPARATOR ',')"));

				book.setLocation(rs.getString("book_location"));
				book.setState(rs.getString("state"));

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
		
	}
	/**
	 * ͨ��isbn����ͼ��
	 * @param isbn
	 * @return
	 */
	public Book searchByIsbn(String isbn) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs;
		Book book = null;
		String sql = null;
		if (isbn != "all" || isbn != null || isbn != "") {
			sql = "select book_id,book.isbn,book_name,book_price,book_description,publisher.publisher_id,publisher_name,publisher_description,book_location,state,GROUP_CONCAT(author.author_name SEPARATOR ',') from (((book join book_in_library on book.isbn=book_in_library.isbn) "
					+ " left join publisher on publisher.publisher_id=book.publisher_id) "
					+ " left join writes on writes.isbn=book.isbn "
					+ " left join author on author.author_id=writes.author_id) " + " where book_in_library.isbn=" + isbn
					+ "group by book_id ";
		} else {
			return book;
		}
		System.out.println("SearchByID sql:" + sql);
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getBigDecimal("book_price"));
				book.setDescription(rs.getString("book_description"));
				// set publisher
				Publisher publisher1 = new Publisher();
				publisher1.setId(rs.getInt("publisher_id"));
				publisher1.setName(rs.getString("publisher_name"));
				publisher1.setDescription(rs.getString("publisher_description"));
				book.setPublisher(publisher1);
				// set author
				book.setAuthors(rs.getString("GROUP_CONCAT(author.author_name SEPARATOR ',')"));

				book.setLocation(rs.getString("book_location"));
				book.setState(rs.getString("state"));

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	/**
	 * ���������Ϣ
	 */
	public boolean updateBookInfoById(int bookId, String location, String state) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			String sql = "UPDATE book_in_library SET book_location=?,state=? WHERE book_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			pstmt.setString(2, state);
			pstmt.setInt(3, bookId);
			int row = pstmt.executeUpdate();
			if (row == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("--BookDAO--,--updateBookInfoById--,suffers exception");
			return false;
		}		
	}
	
	/**
	 * �÷���������������Ϣ
	 * @param start
	 * @param count
	 * @return 
	 */
	public Collection<Book> getAllBook(int start, int count) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs;
		Book book = null;
		Collection bookColle = new ArrayList();
		String sql = null;

		sql = "select book_id,book.isbn,book_name,book_price,book_description,publisher.publisher_id,publisher_name,publisher_description,book_location,state from (((book_in_library join book on book.isbn=book_in_library.isbn) "
				+ " left join publisher on publisher.publisher_id=book.publisher_id) "
				+ " left join writes on writes.isbn=book.isbn "
				+ " left join author on author.author_id=writes.author_id) " + " order by book_id asc limit ?,? ";

		System.out.println("getAllBook sql:" + sql);
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			st = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				book.setPrice(rs.getBigDecimal("book_price"));
				book.setDescription(rs.getString("book_description"));
				// set publisher
				Publisher publisher1 = new Publisher();
				publisher1.setId(rs.getInt("publisher_id"));
				publisher1.setName(rs.getString("publisher_name"));
				publisher1.setDescription(rs.getString("publisher_description"));
				book.setPublisher(publisher1);

				book.setLocation(rs.getString("book_location"));
				book.setState(rs.getString("state"));
				bookColle.add(book);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookColle;
	}
	
	/**
	 * �������
	 * @param bookId
	 * @param readerId
	 * @param librarianId
	 * @return
	 */
	public boolean lendBook(int bookId, int readerId, int librarianId) {
		Connection conn = null;
		Statement st = null;
		PreparedStatement pstmt = null;
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			conn.setAutoCommit(false);
			// �ı�book_in_library�� state
			String sql = "update book_in_library set state='borrowed' where book_id=" + bookId;
			st = conn.createStatement();
			st.executeUpdate(sql);
			// ��borrow_item�����һ������
			Timestamp time = new Timestamp(Calendar.getInstance().getTimeInMillis());
			sql = "insert into borrow_item(reader_id,book_id,borrow_librarian_id,borrow_time) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, readerId);
			pstmt.setInt(2, bookId);
			pstmt.setInt(3, librarianId);
			pstmt.setTimestamp(4, time);
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			st.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("--BookDAO--,--borrowBook()--, suffers exception");
			return false;
		}
	}
	/**
	 * �鼮���
	 * @param isbn
	 * @param location
	 * @param number
	 * @return
	 */
	public List<Integer> addBookInLib(String isbn, String location, int number)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> bookIdList = new ArrayList<Integer>();		
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			conn.setAutoCommit(false);
			// ����鱾�� book_in_library
			String sql = "insert into book_in_library (isbn,book_location,state) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.setString(2, location);
			pstmt.setString(3, "inlib");
			// ��Ӷ౾��
			for (int i = 0; i < number; i++) {
				pstmt.executeUpdate();
				System.out.println("in");
			}
			// ��������ӵ��鱾��book_Id
			sql = "SELECT * FROM book_in_library ORDER BY book_id DESC LIMIT " + number;
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				bookIdList.add(rs.getInt("book_id"));
			}
			conn.commit();
			return bookIdList;
		} catch (Exception e) {
			System.out.println("--BookDAO--,--addBookInLib()--,suffers exception");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �������
	 * @param ISBN
	 * @param price
	 * @param name
	 * @param description
	 * @param publisher
	 * @param author
	 * @return
	 */
	public boolean addNewBook(String ISBN, BigDecimal price, String name, String description, String publisher,
			String author) {	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			// ��ѯbook���Ƿ����ͬһ��isbn���鼮
			String sql = "select * from book where isbn='" + ISBN + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
			// ������ͬisbn���鼮�������
			sql = "insert into book(isbn,book_price,book_name,book_description,publisher_id) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ISBN);
			pstmt.setBigDecimal(2, price);
			pstmt.setString(3, name);
			pstmt.setString(4, description);
			PublisherDAO publisherDAO = new PublisherDAO();
			int publisherID = publisherDAO.searchPublisherByName(publisher).getId();
			pstmt.setInt(5, publisherID);
			pstmt.executeUpdate();
			AuthorDAO authorDAO = new AuthorDAO();
			int authorId = authorDAO.searchAuthorByName(author).getId();
			sql = "SELECT * FROM writes WHERE author_id=" + authorId + " AND isbn='" + ISBN + "'";
			pstmt = conn.prepareStatement(sql);
			if (rs.next()) {
				return true;
			} else {
				sql = "insert into writes(isbn,author_id) values(?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ISBN);
				pstmt.setInt(2, authorId);
				pstmt.executeUpdate();
				return true;
				}
			}
		} catch (Exception e) {
			System.out.println("--BookDAO--,--addNewBook()--,suffers exception");
			return false;
		}
	}
	
	/**
	 * ͨ��ͼ���idɾ��ͼ��
	 * @param bookId
	 * @return
	 */
	public int deleteBookById(int bookId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getInstance().getConnection();
			conn.setAutoCommit(false);
			// ��book_in_library���������飨�ж����ޣ�����ȡ״̬
			String sql = "SELECT * FROM book_in_library where book_id=" + bookId;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String state = rs.getString("state");
				if (state.equals("inlib")) {
					sql = "DELETE FROM book_in_library\r\n" + "WHERE book_id=" + bookId;
					pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
					conn.commit();
					rs.close();
					pstmt.close();
					conn.close();
					return 1;
				} else {// ״̬����inlib
					conn.commit();
					rs.close();
					pstmt.close();
					conn.close();
					return 2;
				}
			}  else {// ���鲻���ڣ��������÷�֧��
				conn.commit();
				rs.close();
				pstmt.close();
				conn.close();
				return 3;
			}
		} catch (Exception e) {
			System.out.println("--BookDAO--,--deleteBookById()--,suffers exception");
			return 4;
		}
		
	}
}
