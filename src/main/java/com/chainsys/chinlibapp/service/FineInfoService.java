package com.chainsys.chinlibapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.FineInfoDAO;
import com.chainsys.chinlibapp.dao.imp.FineInfoImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;
@Service
public class FineInfoService {

	private FineInfoDAO fineInfoDAO = new FineInfoImpl();
	
	public void AddFineInfo(FinesInfo FI) throws DbException {
		fineInfoDAO.AddFineInfo(FI);
	}
	public void AddFineInfo1(FinesInfo FO) throws DbException {
		fineInfoDAO.AddFineInfo1(FO);
	}
	public int TotalFinesAmt(FinesInfo FT) throws DbException {
	
		int rows = fineInfoDAO.updateFineAmount(FT);
		return rows;
		
		
	}
	public int FinePerStudent(int studentId, long ISBN) throws Exception{
		
		return fineInfoDAO.FinePerStudent(studentId, ISBN);
		
	}
	public int bookreturned(int studentId,long ISBN) throws DbException {
		fineInfoDAO.updateBookSummary(studentId, ISBN);
		
		
		return fineInfoDAO.bookreturned(studentId, ISBN);
		
		
	}
	public int renewal(int studentId, Long isbn) throws DbException {
		return fineInfoDAO.renewal(studentId, isbn);
		
	}
public int PenalityForBookLost(int studentId, long ISBN) throws DbException {

	return fineInfoDAO.PenalityForBookLost(studentId, ISBN);
	
}
public int renewalCount(int studentId, long isbn) throws DbException {
	return fineInfoDAO.renewalCount(studentId, isbn);
}
}



