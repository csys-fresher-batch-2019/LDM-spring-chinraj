package com.chainsys.chinlibapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.FineInfoDAO;
import com.chainsys.chinlibapp.dao.imp.FineInfoImpl;
import com.chainsys.chinlibapp.model.FinesInfo;
@Service
public class FineInfoService {

	FineInfoDAO f = new FineInfoImpl();
	
	public void AddFineInfo(FinesInfo FI) {
		f.AddFineInfo(FI);
	}
	public void AddFineInfo1(FinesInfo FO) {
		f.AddFineInfo1(FO);
	}
	public int TotalFinesAmt(FinesInfo FT) {
		return f.TotalFinesAmt(FT);
		
	}
	public int FinePerStudent(int studentId, long ISBN) throws Exception{
		return f.FinePerStudent(studentId, ISBN);
		
	}
	public int bookreturned(int studentId,long ISBN) {
		return f.bookreturned(studentId, ISBN);
		
	}
	public int renewal(int studentId, Long isbn) {
		return f.renewal(studentId, isbn);
		
	}
public int PenalityForBookLost(int studentId, long ISBN) {
	return f.PenalityForBookLost(studentId, ISBN);
	
}
public int renewalCount(int studentId, long isbn) {
	return f.renewalCount(studentId, isbn);
}
}
