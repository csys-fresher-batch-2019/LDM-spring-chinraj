package com.chainsys.chinlibapp.dao;

import com.chainsys.chinlibapp.model.FinesInfo;

public interface FineInfoDAO {
	public void AddFineInfo(FinesInfo FI);
	public void AddFineInfo1(FinesInfo FO);
	public int TotalFinesAmt(FinesInfo FT);
	public int FinePerStudent(int studentId, long ISBN) throws Exception;
	public int bookreturned(int studentId,long ISBN);
	public int renewal(int studentId, Long isbn);
public int PenalityForBookLost(int studentId, long ISBN);
public int renewalCount(int studentId, long isbn) ;
}