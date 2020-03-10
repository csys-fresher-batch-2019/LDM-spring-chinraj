package com.chainsys.chinlibapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.IdDetailsDAO;
import com.chainsys.chinlibapp.dao.imp.IdDetailsDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
@Service
public class IdService {

	IdDetailsDAO i = new IdDetailsDAOImpl();
	
	public int addMoneyInId(int a,int b) throws DbException {
		return i.addMoneyInId(a, b);
		
	}

	public int updateMoneyInId(int a ,int b) throws DbException {
		return i.updateMoneyInId(a, b);
	}
	
	public int updateAfterFinePay(int studentId, long iSBN) throws DbException {
		return i.updateAfterFinePay(studentId, iSBN);
	}
		
	
	public int libraryWallet() throws DbException {
		return i.libraryWallet();
		
	}
	
	
}
