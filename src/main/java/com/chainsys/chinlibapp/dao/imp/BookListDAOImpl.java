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
import com.chainsys.chinlibapp.model.BookList;
import com.chainsys.chinlibapp.util.TestConnection;

@Repository
public class BookListDAOImpl implements BookListDAO {
	Logger logger = Logger.getInstance();

	public int saveBooks(BookList books) throws DbException {
		int rows = 0;
		String sqlinsert = "insert into booklist(ISBN,book_name,pages,author_name,publication,category,released_date,price,rack_no) values (?,?,?,?,?,?,?,?,?)";
		try (Connection con = TestConnection.getConnection();) {
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

	public List<BookList> findBooks() throws DbException {
		List<BookList> list = null;

		String sqlinsert = "Select * from Booklist ";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				try (ResultSet rs = stmt.executeQuery();) {
					list = new ArrayList<BookList>();
					while (rs.next()) {
						BookList b = new BookList();
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

	public int deleteBook(long isbn) throws DbException {
		int row = 0;
		String sqlinsert = "delete booklist where ISBN=?";
		try (Connection con = TestConnection.getConnection();
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

	public List<BookList> searchByBook(String name) throws DbException {

		ArrayList<BookList> n = new ArrayList<>();

		String sqlinsert = "select * from booklist where book_name like ?";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setString(1, "%" + name + "%");
				try (ResultSet rs = stmt.executeQuery();) {
					while (rs.next()) {
						BookList b = new BookList();
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
