package com.chainsys.chinlibapp.dao;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;

public interface FineInfoDAO {
	void addFineInfo(FinesInfo FI) throws DbException;

	void updateFineInfo(FinesInfo FO) throws DbException;

	int totalFine(FinesInfo FT) throws DbException;

	int finePerStudent(int studentId, long ISBN) throws Exception;

	int bookReturn(int studentId, long ISBN) throws DbException;

	int renewal(int studentId, Long isbn) throws DbException;

	int penalityForBookLost(int studentId, long ISBN) throws DbException;

	int renewalCount(int studentId, long isbn) throws DbException;

	int updateFineAmount(FinesInfo FT) throws DbException;

	public int deleteFineAmount() throws DbException;

	public int updateBookStatus(long iSBN) throws DbException;

	public int updateBookSummary(int studentId, long iSBN) throws DbException;

	public int getBookPrice(long ISBN) throws DbException;

	public int updateRenewalCount(int studentId, Long isbn) throws Exception;

}