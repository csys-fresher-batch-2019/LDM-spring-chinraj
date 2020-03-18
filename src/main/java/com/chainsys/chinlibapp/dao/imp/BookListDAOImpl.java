package com.chainsys.chinlibapp.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.chinlibapp.dao.BookListDAO;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.exception.InfoMessages;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.Book;
import com.chainsys.chinlibapp.util.ConnectionUtil;

@Repository
public class BookListDAOImpl implements BookListDAO {
	Logger logger = Logger.getInstance();

	@Override
	public int saveBooks(Book books) throws DbException {
		int rows = 0;
		String sqlinsert = "insert into booklist(ISBN,book_name,pages,author_name,publication,category,released_date,price,rack_no) values (?,?,?,?,?,?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setLong(1, books.getISBN());
				stmt.setString(2, books.getBookName());
				stmt.setInt(3, books.getPages());
				stmt.setString(4, books.getAuthorName());
				stmt.setString(5, books.getPublication());
				stmt.setString(6, books.getCategory());
				Date bw = Date.valueOf(books.getReleasedDate());
				stmt.setDate(7, bw);
				stmt.setInt(8, books.getPrice());
				stmt.setInt(9, books.getRackNo());
				rows = stmt.executeUpdate();
				logger.info(rows);
			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.FAILED_TO_ADD_BOOK, e);
		}
		return rows;
	}

	@Override
	public List<Book> findBooks() throws DbException {
		List<Book> list = null;

		String sqlinsert = "Select * from Booklist ";
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				try (ResultSet rs = stmt.executeQuery();) {
					list = new ArrayList<Book>();
					while (rs.next()) {
						Book b = new Book();
						b.setISBN(rs.getLong("ISBN"));
						b.setBookName(rs.getString("book_name"));
						b.setAuthorName(rs.getString("author_name"));
						b.setPublication(rs.getString("publication"));
						b.setBookStatus(rs.getString("book_status"));
						b.setPrice(rs.getInt("price"));
						Date g = rs.getDate("released_date");
						b.setReleasedDate(g.toLocalDate());
						b.setCategory(rs.getString("category"));
						b.setPages(rs.getInt("pages"));
						list.add(b);
					}
				}
			}

		} catch (SQLException e) {

			throw new DbException(InfoMessages.FAILED_TO_SELECT_BOOKLIST, e);
		}
		return list;
	}

	@Override
	public List<Book> findIsbn() throws DbException {
		List<Book> list = null;

		String sqlinsert = "Select ISBN from Booklist ";
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				try (ResultSet rs = stmt.executeQuery();) {
					list = new ArrayList<Book>();
					while (rs.next()) {
						Book b = new Book();
						b.setISBN(rs.getLong("ISBN"));
						list.add(b);
					}
				}
			}

		} catch (SQLException e) {

			throw new DbException(InfoMessages.FAILED_TO_SELECT_BOOKLIST, e);
		}
		return list;
	}

	@Override
	public int deleteBook(long isbn) throws DbException {
		int row = 0;
		String sqlinsert = "delete booklist where ISBN=?";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
			stmt.setLong(1, isbn);
			row = stmt.executeUpdate();
			logger.info(sqlinsert);
			logger.info(row);
			if (row != 1) {
				logger.info("\n No book is available on" + isbn);
			}
		} catch (SQLException e) {

			throw new DbException(InfoMessages.FAILED_TO_DELETE_ISBN, e);
		}
		return row;
	}

	@Override
	public List<Book> searchByBook(String name) throws DbException {

		ArrayList<Book> n = new ArrayList<>();

		String sqlinsert = "select * from booklist where book_name like ?";
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setString(1, "%" + name + "%");
				try (ResultSet rs = stmt.executeQuery();) {
					while (rs.next()) {
						Book b = new Book();
						b.setISBN(rs.getLong("ISBN"));
						b.setBookName(rs.getString("book_name"));
						b.setAuthorName(rs.getString("author_name"));
						b.setPublication(rs.getString("publication"));
						b.setBookStatus(rs.getString("book_status"));
						b.setPrice(rs.getInt("price"));
						Date g = rs.getDate("released_date");
						b.setReleasedDate(g.toLocalDate());
						b.setPages(rs.getInt("pages"));
						b.setCategory(rs.getString("category"));
						n.add(b);

					}
				}

			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.FAILED_TO_SELECT_BOOKNAME, e);
		}
		return n;

	}
}
