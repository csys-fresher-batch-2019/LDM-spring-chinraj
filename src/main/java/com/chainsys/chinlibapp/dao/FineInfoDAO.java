package com.chainsys.chinlibapp.dao;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;

public interface FineInfoDAO {
	void addFineInfo(FinesInfo f) throws DbException;

	void updateFineInfo(FinesInfo i) throws DbException;

	int totalFine(FinesInfo j) throws DbException;

	int finePerStudent(int studentId, long isbn) throws Exception;

	int bookReturn(int studentId, long isbn) throws DbException;

	int renewal(int studentId, Long isbn) throws DbException;

	int penalityForBookLost(int studentId, long isbn) throws DbException;

	int renewalCount(int studentId, long isbn) throws DbException;

	int updateFineAmount(FinesInfo a) throws DbException;

	public int deleteFineAmount() throws DbException;

	public int updateBookStatus(long isbn) throws DbException;

	public int updateBookSummary(int studentId, long isbn) throws DbException;

	public int getBookPrice(long isbn) throws DbException;

	public int updateRenewalCount(int studentId, Long isbn) throws DbException;

}