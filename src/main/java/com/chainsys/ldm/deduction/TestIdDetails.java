package com.chainsys.ldm.deduction;

import java.util.Scanner;

import com.chainsys.chinlibapp.dao.imp.IdDetailsDAOImpl;
import com.chainsys.chinlibapp.logger.Logger;

public class TestIdDetails {
         
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		IdDetailsDAOImpl ii = new IdDetailsDAOImpl();
		Scanner s = new Scanner(System.in);
	
       logger.info("\n 1.AddAmount\n 2.UpadateAmountInIdAfterFine\n  \n3.Library Wallet\n 4. updateMoneyInId");
   	int n = s.nextInt();
		switch (n) {
		case 1: {

			logger.info("Enter studentId :");
			int studentId = s.nextInt();
			
		
			logger.info("Enter Amount to be added:");
			int deposit = s.nextInt();
			ii.addMoneyInId(studentId, deposit);
		}
			break;
		case 2: {
			logger.info("Enter studentId :");
			int studentId = s.nextInt();
			logger.info("Enter ISBN :");
			long ISBN = s.nextLong();
			ii.updateAfterFinePay(studentId, ISBN);
		}
			break;

	

		case 4: {
			ii.libraryWallet();
	}
		case 5:{
			
			logger.info("Enter Amount :");
			int studentId1 = s.nextInt();
			
			logger.info("Enter Student Id:");
			int Amount = s.nextInt();
			ii.updateMoneyInId(studentId1,Amount);
		}
		}
		s.close();
	}}	
	