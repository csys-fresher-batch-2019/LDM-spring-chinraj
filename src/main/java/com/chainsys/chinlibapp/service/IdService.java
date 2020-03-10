package com.chainsys.chinlibapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.IdDetailsDAO;
import com.chainsys.chinlibapp.dao.imp.IdDetailsImpl;
import com.chainsys.chinlibapp.exception.DbException;
@Service
public class IdService {

	IdDetailsDAO i = new IdDetailsImpl();
	
	public int addMoneyInId(int a,int b) throws DbException {
		return i.addMoneyInId(a, b);
		
	}
	public int updateAmtInId (int studentId, long ISBN) throws DbException {
		return i.updateAmtInId(studentId, ISBN);
		
	}
	public int updateAmtInWallet (int studentId, long ISBN) throws DbException {
		return i.updateAmtInWallet(studentId, ISBN);
		
	}
	public int updateMoneyInId(int a ,int b) throws DbException {
		return i.updateMoneyInId(a, b);
	}
	public int libraryWallet() throws DbException {
		return i.libraryWallet();
		
	}
	
	
}
