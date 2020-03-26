package com.chainsys.chinlibapp.dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.chainsys.chinlibapp.dao.IdDetailsDAO;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.exception.InfoMessages;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.IdDetails;
import com.chainsys.chinlibapp.util.ConnectionUtil;

@Repository
public class IdDetailsDAOImpl implements IdDetailsDAO {
	Logger logger = Logger.getInstance();
	IdDetails bb = new IdDetails();

	@Override
	public int addMoneyInId(int a, int b) throws DbException {
		int rows = 0;
		String sqlinsert = "insert into amount(student_id,amount_in_id) values(?,?)";
		logger.info(sqlinsert);
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setInt(1, a);
				stmt.setInt(2, b);
				rows = stmt.executeUpdate();
				return rows;
			}
		} catch (SQLException e) {

			throw new DbException(InfoMessages.FAILED_TO_ADD_MONEY, e);

		}

	}

	@Override
	public int updateMoneyInId(int a, int b) throws DbException {
		int rows = 0;
		String sqlinsert = "update amount set amount_in_id= amount_in_id + ? where student_id=?";

		logger.info(sqlinsert);
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setInt(1, a);
				stmt.setInt(2, b);
				rows = stmt.executeUpdate();
				logger.info(rows);
			}

		} catch (SQLException e) {
			throw new DbException(InfoMessages.FAILED_TO_UPDATE_MONEY, e);

		}
		return rows;
	}

	@Override
	public int updateAfterFinePay(int studentId, long iSBN) throws DbException {
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql5 = "update amount set amount_in_id = amount_in_id-(select fines from fine_amount where student_id=? and ISBN=?)where student_id=?";
			try (PreparedStatement s = con.prepareStatement(sql5);) {
				s.setInt(1, studentId);
				s.setLong(2, iSBN);
				s.setInt(3, studentId);
				row = s.executeUpdate();
				logger.info(sql5);
				logger.info(row);

				if (row == 1) {
					updateFineStatus(studentId, iSBN);
					updateAmtInWallet(studentId, iSBN);
				}

			}
		} catch (SQLException e) {

			throw new DbException(InfoMessages.FAILED_TO_UPDATE_AFTER_FINE_PAY, e);

		}
		return row;
	}

	public int updateFineStatus(int studentId, long isbn) throws DbException {
		int row1 = 0;
		String sql8 = " update fine_amount set fines =0 ,no_of_extra_days=0,fine_status= 'paid' where student_id= ? and ISBN =?";
		try (Connection con = ConnectionUtil.getConnection();) {

			try (PreparedStatement s1 = con.prepareStatement(sql8);) {
				s1.setInt(1, studentId);
				s1.setLong(2, isbn);
				row1 = s1.executeUpdate();
				logger.info(row1);
				logger.info(sql8);

			}
		} catch (SQLException e) {

			throw new DbException(InfoMessages.FAILED_TO_UPDATE_FINE_STATUS, e);
		}
		return row1;

	}

	@Override
	public int updateAmtInWallet(int studentId, long isbn) throws DbException {
		int row0 = 0;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql7 = "update amount set library_wallet = library_wallet + (select fines from fine_amount where student_id=? and ISBN=?) where student_id=?";
			try (PreparedStatement s = con.prepareStatement(sql7);) {
				s.setInt(1, studentId);
				s.setLong(2, isbn);
				s.setInt(3, studentId);
				row0 = s.executeUpdate();
				logger.info(row0);
				logger.info(sql7);
				if (row0 == 1) {
					updateFineStatus(studentId, isbn);

				} else {
					logger.info("Enter valid data ");
				}
			}
		} catch (SQLException e) {

			throw new DbException(InfoMessages.FAILED_TO_UPDATE_AMOUNT_IN_ID, e);

		}
		return row0;
	}

	@Override
	public int libraryWallet() throws DbException {
		int libraryWallet = 0;
		try (Connection con = ConnectionUtil.getConnection();) {
			try (CallableStatement stmt = con.prepareCall("{call LIB_WALLET_PROC(?)}");) {
				stmt.registerOutParameter(1, Types.INTEGER);
				stmt.executeUpdate();
				libraryWallet = stmt.getInt(1);
				logger.info(libraryWallet);
			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.FAILED_TO_CALL_LIB_WALLET_PROC, e);

		}
		return libraryWallet;
	}

}