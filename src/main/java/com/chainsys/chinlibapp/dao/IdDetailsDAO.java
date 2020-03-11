package com.chainsys.chinlibapp.dao;

import com.chainsys.chinlibapp.exception.DbException;

public interface IdDetailsDAO {
	public int addMoneyInId(int a, int b) throws DbException;

	public int updateAfterFinePay(int studentId, long ISBN) throws DbException;

	public int updateAmtInWallet(int studentId, long ISBN) throws DbException;

	public int updateMoneyInId(int a, int b) throws DbException;

	public int libraryWallet() throws DbException;
}
