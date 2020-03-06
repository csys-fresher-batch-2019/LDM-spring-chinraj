package com.chainsys.chinlibapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.IdDetailsDAO;
import com.chainsys.chinlibapp.dao.imp.IdDetailsImp;
@Service
public class IdService {

	IdDetailsDAO i = new IdDetailsImp();
	
	public int addMoneyInId(int a,int b) {
		return i.addMoneyInId(a, b);
		
	}
	public int updateAmtInId (int studentId, long ISBN) {
		return i.updateAmtInId(studentId, ISBN);
		
	}
	public int updateAmtInWallet (int studentId, long ISBN) {
		return i.updateAmtInWallet(studentId, ISBN);
		
	}
	public int updateMoneyInId(int a ,int b) {
		return i.updateMoneyInId(a, b);
	}
	public int libraryWallet() {
		return i.libraryWallet();
		
	}
	
	
}
