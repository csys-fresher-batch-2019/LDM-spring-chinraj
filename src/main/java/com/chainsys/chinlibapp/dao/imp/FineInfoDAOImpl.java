package com.chainsys.chinlibapp.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.chinlibapp.dao.FineInfoDAO;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.exception.InfoMessages;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.FinesInfo;
import com.chainsys.chinlibapp.util.ConnectionUtil;

@Repository
public class FineInfoDAOImpl implements FineInfoDAO {
	Logger logger = Logger.getInstance();

	@Override
	public void addFineInfo(FinesInfo f) throws DbException {

		String sqlinsert = "insert into fine_amount(student_id,ISBN,fines_per_day) values(?,?,?)";
		logger.info(sqlinsert);
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
			stmt.setInt(1, f.getStudentId());
			stmt.setLong(2, f.getISBN());
			stmt.setInt(3, f.getFinePerDay());
			int rows = stmt.executeUpdate();
			logger.info("" + rows);

			if (rows == 1) {
				updateFineInfo(f);
				updateFineAmount(f);
				totalFine(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_ADD_FINE_INFO, e);
		}
	}

	@Override
	public void updateFineInfo(FinesInfo i) throws DbException {
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql1 = " update fine_amount set no_of_extra_days = trunc(sysdate - (select due_date from book_summary where ISBN=? ))";
			try (PreparedStatement stmt4 = con.prepareStatement(sql1);) {
				stmt4.setLong(1, i.getISBN());
				int row1 = stmt4.executeUpdate();
				logger.info(row1);
				logger.info(sql1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_UPDATE_FINE_INFO, e);
		}
	}

	@Override
	public int updateFineAmount(FinesInfo j) throws DbException {

		try (Connection con = ConnectionUtil.getConnection();) {

			String sql5 = "  update fine_amount set fines= no_of_extra_days * fines_per_day where student_id= ? and ISBN=?";
			try (PreparedStatement s = con.prepareStatement(sql5);) {
				s.setInt(1, j.getStudentId());
				s.setLong(2, j.getISBN());
				int rowq = s.executeUpdate();
				logger.info(rowq);
				logger.info(sql5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_UPDATE_FINE_AMOUNT, e);
		}
		return 0;
	}

	@Override
	public int totalFine(FinesInfo t) throws DbException {
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql0 = "update fine_amount set fines=0, no_of_extra_days=0,fine_status='paid' where "
					+ " trunc(( sysdate-(select due_date from book_summary where ISBN=?)))<=0 ";
			try (PreparedStatement stm = con.prepareStatement(sql0);) {
				stm.setLong(1, t.getISBN());
				int row = stm.executeUpdate();
				logger.info(row);
				logger.info(sql0);

				updateFineAmount(t);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_UPDATE_TOTAL_FINE_AMOUNT, e);
		}
		return 0;
	}

	@Override
	public int finePerStudent(int studentId, long isbn) throws DbException {
		int fines = 0;

		String sql6 = "select fines from fine_amount where student_id = ? and ISBN = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql6);) {
			pst.setInt(1, studentId);
			pst.setLong(2, isbn);
			logger.info(sql6);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					fines = rs.getInt("fines");
					logger.info(fines);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_SELECT_FINE, e);
		}
		return fines;

	}

	@Override
	public int deleteFineAmount() throws DbException {
		int rows = 0;
		String sql6 = " delete fine_amount where fine_status ='paid'";
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement s2 = con.prepareStatement(sql6);) {
				rows = s2.executeUpdate();
				logger.info(rows);
				logger.info(sql6);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_DELETE_FINE_AMOUNT, e);
		}
		return rows;
	}

	@Override
	public int updateBookStatus(long isbn) throws DbException {
		int row = 0;
		String sql0 = "update booklist set book_status = 'Available' where ISBN = ?";
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement stmt5 = con.prepareStatement(sql0);) {
				stmt5.setLong(1, isbn);
				row = stmt5.executeUpdate();
				logger.info(row);
				logger.info(sql0);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_UPDATE_BOOK_STATUS, e);
		}
		return row;
	}

	@Override
	public int updateBookSummary(int studentId, long isbn) throws DbException {
		int row = 0;
		String sql3 = "update book_summary set status ='Returned',return_date=sysdate where student_id =? and ISBN = ?";
		try (Connection con = ConnectionUtil.getConnection();) {

			try (PreparedStatement stmt = con.prepareStatement(sql3);) {
				stmt.setInt(1, studentId);
				stmt.setLong(2, isbn);
				row = stmt.executeUpdate();
				logger.info(row);
				logger.info(sql3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_UPDATE_BOOK_SUMMARY, e);
		}
		return row;
	}

	@Override
	public int bookReturn(int studentId, long isbn) throws DbException {
		int row4 = 0;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sqll = "select fine_status from fine_amount where student_id=? and ISBN =?";
			try (PreparedStatement pst = con.prepareStatement(sqll);) {
				pst.setInt(1, studentId);
				pst.setLong(2, isbn);

				try (ResultSet row3 = pst.executeQuery();) {

					while (row3.next()) {

						String status = row3.getString("fine_status");
						if (status.contentEquals("paid")) {

							updateBookSummary(studentId, isbn);
							row4 = updateBookStatus(isbn);
							if (row4 == 1) {
								deleteFineAmount();
							}

						} else {

							logger.info("Pay Fine amount");
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_RETURN_BOOK, e);
		}
		return row4;
	}

	@Override
	public int getBookPrice(long isbn) throws DbException {

		int price = 0;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql3 = "select price from booklist where ISBN =?";
			try (PreparedStatement stmt = con.prepareStatement(sql3);) {
				stmt.setLong(1, isbn);

				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					price = rs.getInt("price");
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FALED_TO_GET_BOOK_PRICE, e);
		}

		return price;
	}

	@Override
	public int penalityForBookLost(int studentId, long isbn) throws DbException {
		int price = getBookPrice(isbn);
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql3 = "update fine_amount set lost_penality = ? ";
			try (PreparedStatement stmt = con.prepareStatement(sql3);) {
				stmt.setInt(1, price);
				int row3 = stmt.executeUpdate();
				logger.info(row3);
				logger.info(sql3);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_UPDATE_LOST_PENALITY, e);
		}
		logger.info(price);
		return price;
	}

	@Override
	public int updateRenewalCount(int studentId, Long isbn) throws DbException {
		int row = 0;

		Connection con1 = ConnectionUtil.getConnection();
		String sql3 = "update book_summary set renewal_count =  renewal_count+1, due_date=due_date+10"
				+ " where student_id=? and ISBN = ?";
		try (PreparedStatement stmt = con1.prepareStatement(sql3);) {
			stmt.setInt(1, studentId);
			stmt.setLong(2, isbn);
			row = stmt.executeUpdate();
			logger.info(sql3);
			logger.info(row);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FALIED_TO_UPDATE_RENEWAL_COUNT, e);
		}
		return row;
	}

	@Override
	public int renewal(int studentId, Long isbn) throws DbException {
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sqll = "select fine_status from fine_amount where student_id=? and ISBN =?";
			try (PreparedStatement pst = con.prepareStatement(sqll);) {
				pst.setInt(1, studentId);
				pst.setLong(2, isbn);

				try (ResultSet row3 = pst.executeQuery();) {

					while (row3.next()) {

						String status = row3.getString("fine_status");
						logger.info(status);
						if (status.contentEquals("paid")) {
							row = updateRenewalCount(studentId, isbn);

						} else {
							logger.info("Pay Fine amount");
						}
					}

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_RENEWAL, e);
		}
		return row;
	}

	@Override
	public int renewalCount(int studentId, long isbn) throws DbException {
		int k = 0;
		String sql = "select renewal_count from book_summary where student_id=? and ISBN = ?";

		try (Connection con = ConnectionUtil.getConnection();

				PreparedStatement pst1 = con.prepareStatement(sql);) {

			pst1.setInt(1, studentId);
			pst1.setLong(2, isbn);
			try (ResultSet rs = pst1.executeQuery();) {
				if (rs.next()) {
					k = rs.getInt("renewal_count");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FAILED_TO_SELECT_RENEWAL_COUNT, e);
		}
		return k;

	}
}