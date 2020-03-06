package com.chainsys.ldm.deduction;

public interface IdDetailsDAO {
	public int addMoneyInId(int a,int b);
	public int updateAmtInId (int studentId, long ISBN); 
	public int updateAmtInWallet (int studentId, long ISBN); 
	public int libraryWallet();
}
