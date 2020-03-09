package com.chainsys.chinlibapp.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.chainsys.chinlibapp.dao.FineInfoDAO;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.exception.InfoMessages;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.FinesInfo;
import com.chainsys.ldm.bookSummary.TestConnection;

@Repository
public class FineInfoImpl implements FineInfoDAO {
	Logger logger = Logger.getInstance();

	public void AddFineInfo(FinesInfo FI) throws DbException {

		String sqlinsert = "insert into fine_amount(student_id,ISBN,fines_per_day) values(?,?,?)";
		logger.info(sqlinsert);
		try (Connection con = TestConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
			stmt.setInt(1, FI.getStudentId());
			stmt.setLong(2, FI.getISBN());
			stmt.setInt(3, FI.getFinePerDay());
			int rows = stmt.executeUpdate();
			logger.info("" + rows);
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_INSERT);
		}
	}

	public void AddFineInfo1(FinesInfo FO) throws DbException {
		try (Connection con = TestConnection.getConnection();) {
			String sql1 = " update fine_amount set no_of_extra_days = trunc(sysdate - (select due_date from book_summary where ISBN=? ))";
			try (PreparedStatement stmt4 = con.prepareStatement(sql1);) {
				stmt4.setLong(1, FO.getISBN());
				int row1 = stmt4.executeUpdate();
				logger.info(row1);
				logger.info(sql1);
			}
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_UPDATE);
		}
	}

	public int updateFineAmount(FinesInfo FT) throws DbException {

		try (Connection con = TestConnection.getConnection();) {

			String sql5 = "  update fine_amount set fines= no_of_extra_days * fines_per_day where student_id= ? and ISBN=?";
			try (PreparedStatement s = con.prepareStatement(sql5);) {
				s.setInt(1, FT.getStudentId());
				s.setLong(2, FT.getISBN());
				int rowq = s.executeUpdate();
				logger.info(rowq);
				logger.info(sql5);
			}

		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_UPDATE);
		}
		return 0;
	}

	public int TotalFinesAmt(FinesInfo FT) throws DbException {
		try (Connection con = TestConnection.getConnection();) {
			String sql0 = "update fine_amount set fines=0, no_of_extra_days=0,fine_status='paid' where "
					+ " trunc(( sysdate-(select due_date from book_summary where ISBN=?)))<=0 ";
			try (PreparedStatement stm = con.prepareStatement(sql0);) {
				stm.setLong(1, FT.getISBN());
				int row = stm.executeUpdate();
				logger.info(row);
				logger.info(sql0);

				
				 updateFineAmount( FT);
				
			}
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_UPDATE);
		}
		return 0;
	}

	public int FinePerStudent(int studentId, long ISBN) throws DbException {
		int fines = 0;
		String sql6 = "select fines from fine_amount where student_id = ? and ISBN = ?";
		try (Connection con = TestConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql6);) {
			pst.setInt(1, studentId);
			pst.setLong(2, ISBN);
			logger.info(sql6);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					fines = rs.getInt("fines");
					logger.info(fines);

				}
			}
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_SELECT);
		}
		return fines;

	}



	public int deleteFineAmount() throws DbException {
		int rows = 0;
		String sql6 = " delete fine_amount where fine_status ='paid'";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement s2 = con.prepareStatement(sql6);) {
				rows = s2.executeUpdate();
				logger.info(rows);
				logger.info(sql6);
			}
		}
		 catch (Exception e) {
				logger.error(e);
				throw new DbException(InfoMessages.INVALID_SELECT);
			}
		return rows;
	}
	public int updateBookStatus(long iSBN) throws DbException {
		int row=0;
		String sql0 = "update booklist set book_status = 'Available' where ISBN = ?";
		try (Connection con = TestConnection.getConnection();) {
		try (PreparedStatement stmt5 = con.prepareStatement(sql0);) {
			stmt5.setLong(1, iSBN);
			row = stmt5.executeUpdate();
			logger.info(row);
			logger.info(sql0);
		
		}
		}
		catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_SELECT);
		}
		return row;
	}
	
	public int updateBookSummary(int studentId, long iSBN) throws DbException {
		int row =0;
		String sql3 = "update book_summary set status ='Returned',return_date=sysdate where student_id =? and ISBN = ?";
		try (Connection con = TestConnection.getConnection();) {
			
		try (PreparedStatement stmt = con.prepareStatement(sql3);) {
			stmt.setInt(1, studentId);
			stmt.setLong(2, iSBN);
		    row = stmt.executeUpdate();
			logger.info(row);
			logger.info(sql3);
		}}
		catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_SELECT);
		}
		return row;
	}
	public int bookreturned(int studentId, long iSBN) throws DbException {
		int row4 = 0;
		try (Connection con = TestConnection.getConnection();) {
			String sqll = "select fine_status from fine_amount where student_id=? and ISBN =?";
			try (PreparedStatement pst = con.prepareStatement(sqll);) {
				pst.setInt(1, studentId);
				pst.setLong(2, iSBN);

				try (ResultSet row3 = pst.executeQuery();) {

					while (row3.next()) {

						String status = row3.getString("fine_status");
						if (status.contentEquals("paid")) {

							updateBookSummary( studentId, iSBN);
							
							row4 = updateBookStatus(iSBN);
								if (row4 == 1) {
									deleteFineAmount();
								}

							
						} else {

							logger.info("Pay Fine amount");
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_SELECT);
		}
		return row4;
	}

	public int getBookPrice( long ISBN) throws DbException {
	
		int price = 0;
		try (Connection con = TestConnection.getConnection();) {
			String sql3 = "select price from booklist where ISBN =?";
			try (PreparedStatement stmt = con.prepareStatement(sql3);) {
				stmt.setLong(1, ISBN);

				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					price = rs.getInt("price");
				}
				
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_UPDATE);
		}	
		
		return price;
	}
	
	
	
	public int PenalityForBookLost(int studentId, long ISBN) throws DbException {
			int price = getBookPrice(ISBN);
		try (Connection con = TestConnection.getConnection();) {
			String sql3 = "update fine_amount set lost_penality = ? ";
			try (PreparedStatement stmt = con.prepareStatement(sql3);) {
				stmt.setInt(1, price);
               int row3 = stmt.executeUpdate();
				logger.info(row3);
				logger.info(sql3);

				
			}
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_UPDATE);
		}
		logger.info(price);
		return price;
	}

	public int updateRenewalCount(int studentId, Long isbn) throws Exception {
	 int row =0;
	 
		Connection con1 = TestConnection.getConnection();
		String sql3 = "update book_summary set renewal_count =  renewal_count+1, due_date=due_date+10"
				+ " where student_id=? and ISBN = ?";
		try (PreparedStatement stmt = con1.prepareStatement(sql3);) {
			stmt.setInt(1, studentId);
			stmt.setLong(2, isbn);
			row = stmt.executeUpdate();
			logger.info(sql3);
			logger.info(row);
		}
			 catch (Exception e) {
					logger.error(e);
					throw new DbException(InfoMessages.INVALID_SELECT);
			 }
		return row;		
		}
	
	
	public int renewal(int studentId, Long isbn) throws DbException {
		int row = 0;
		try (Connection con = TestConnection.getConnection();) {
			String sqll = "select fine_status from fine_amount where student_id=? and ISBN =?";
			try (PreparedStatement pst = con.prepareStatement(sqll);) {
				pst.setInt(1, studentId);
				pst.setLong(2, isbn);

				try (ResultSet row3 = pst.executeQuery();) {

					while (row3.next()) {

						String status = row3.getString("fine_status");
						logger.info(status);
						if (status.contentEquals("paid")) {
							 updateRenewalCount(studentId,isbn);
							
						} else {
							logger.info("Pay Fine amount");
						}
					}

				}

			}
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_SELECT);
		}
		return row;
	}

	public int renewalCount(int studentId, long isbn) throws DbException {
		int k = 0;
		String sql = "select renewal_count from book_summary where student_id=? and ISBN = ?";

		try (Connection con = TestConnection.getConnection();

				PreparedStatement pst1 = con.prepareStatement(sql);) {

			pst1.setInt(1, studentId);
			pst1.setLong(2, isbn);
			try (ResultSet rs = pst1.executeQuery();) {
				if (rs.next()) {
					k = rs.getInt("renewal_count");
				}
			}
		} catch (Exception e) {
			logger.error(e);
			throw new DbException(InfoMessages.INVALID_SELECT);
		}
		return k;
	}
}
