package com.chainsys.chinlibapp.dao;

public interface IdDetailsDAO {
	public int addMoneyInId(int a,int b);
	public int updateAmtInId (int studentId, long ISBN); 
	public int updateAmtInWallet (int studentId, long ISBN); 
	public int updateMoneyInId(int a ,int b);
	public int libraryWallet();
}
