package com.chainsys.chinlibapp.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.chinlibapp.dao.BookSummaryDAO;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.exception.InfoMessages;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.BookSummary;
import com.chainsys.chinlibapp.util.SendMail;
import com.chainsys.chinlibapp.util.TestConnection;

@Repository
public class BookSummaryDAOImpl implements BookSummaryDAO {
	Logger logger = Logger.getInstance();
	public boolean checkBookStatus(long isbn) throws DbException {
		String sql1 = "select book_name from booklist where ISBN = ? and book_status = 'Available'";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sql1);) {
				stmt.setLong(1, isbn);
				try (ResultSet row = stmt.executeQuery();) {
					if (row.next()) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			logger.error(e);
			logger.error(InfoMessages.INVALID_INSERT);
		}
		return false;
	

	}

	public int updateBookStatus(BookSummary BS) throws DbException {

		int row1 = 0;
		String sql1 = "update booklist set book_status = 'Notavailable' where ISBN = ?";
		try (Connection con = TestConnection.getConnection();

				PreparedStatement stmt1 = con.prepareStatement(sql1);) {
			stmt1.setLong(1, BS.getISBN());
			row1 = stmt1.executeUpdate();
			logger.info(row1);
			logger.info(sql1);

		} catch (SQLException e) {

			logger.error(e);
			logger.error(InfoMessages.INVALID_INSERT);
		}
		return row1;
	}

	public void sendMail(BookSummary BS) throws DbException {

		String sql0 = "Select  mail_id from student where student_id=? ";
		try (Connection con = TestConnection.getConnection();

				PreparedStatement stmt0 = con.prepareStatement(sql0);) {
			stmt0.setInt(1, BS.getStudentId());
			try (ResultSet rs = stmt0.executeQuery();) {
				String mail;
				if (rs.next()) {
					mail = rs.getString("mail_id");
					SendMail.chinlib(mail, BS.getISBN());
				}
				logger.info(sql0);
			}
		} catch (SQLException e) {

			logger.error(e);
			logger.error(InfoMessages.INVALID_INSERT);
		}

	}

	public int addBookInfo(BookSummary BS) throws DbException {
		int row = 0;
		boolean a = checkBookStatus(BS.getISBN());
		if(a==true) {
		String sql = "insert into book_summary(student_id,ISBN,borrowed_date,due_date)" + " values(?,?,?,?)";
		logger.info(sql);
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, BS.getStudentId());
			stmt.setLong(2, BS.getISBN());
			Date bw = Date.valueOf(BS.getBorrowedDate());
			stmt.setDate(3, bw);
			java.sql.Date dd = java.sql.Date.valueOf(BS.getDueDate());
			stmt.setDate(4, dd);

			row = stmt.executeUpdate();
			logger.info("Insert=" + row);

			if (row == 1) {

				updateBookStatus(BS);
				sendMail(BS);
			}}
		
		catch (SQLException e) {

			logger.error(e);
			logger.error(InfoMessages.INVALID_INSERT);
		}
		
	}
		return row;
	}

	public List<BookSummary> onParticularDate(LocalDate borrowedDate) throws DbException {
		List<BookSummary> li = new ArrayList<BookSummary>();

		String sql6 = "select * from book_summary where borrowed_date = ?";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement pst1 = con.prepareStatement(sql6);) {
				Date bw = Date.valueOf(borrowedDate);
				pst1.setDate(1, bw);
				try (ResultSet rs = pst1.executeQuery();) {
					while (rs.next()) {
						BookSummary BS = new BookSummary();
						int Id = rs.getInt("student_id");
						BS.setstudentId(Id);
						BS.setISBN(rs.getLong("ISBN"));
						Date g = rs.getDate("borrowed_date");
						BS.setBorrowedDate(g.toLocalDate());
						Date g1 = rs.getDate("due_date");
						BS.setDueDate(g1.toLocalDate());
						BS.setRenewalCount(rs.getInt("renewal_count"));
						BS.setStatus(rs.getString("status"));
						li.add(BS);
					}
					if (li.size() > 0) {
						for (BookSummary bookSummary : li) {
							logger.info(bookSummary);
						}
					} else {
						logger.info("No book is Taken On " + borrowedDate);
					}
				}
			}
		} catch (SQLException e) {

			logger.error(e);
			logger.error(InfoMessages.INVALID_INSERT);
		}
		return li;
	}

	public List<BookSummary> viewBookSummary() throws DbException {
		List<BookSummary> list = new ArrayList<BookSummary>();
		String sql = "Select * from book_summary";

		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sql);) {
				try (ResultSet rs = stmt.executeQuery();) {

					while (rs.next()) {
						BookSummary b = new BookSummary();
						b.setstudentId(rs.getInt("student_id"));
						b.setISBN(rs.getLong("ISBN"));
						Date g = rs.getDate("borrowed_date");
						b.setBorrowedDate(g.toLocalDate());
						Date g1 = rs.getDate("due_date");
						b.setDueDate(g1.toLocalDate());

						b.setRenewalCount(rs.getInt("renewal_count"));

						b.setStatus(rs.getString("status"));
						list.add(b);

					}
				}
			}
		} catch (SQLException e) {
			logger.error(e);
			logger.error(InfoMessages.INVALID_INSERT);
		}
		return list;
	}
}
