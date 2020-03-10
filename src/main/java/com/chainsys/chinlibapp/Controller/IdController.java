package com.chainsys.chinlibapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.IdDetailsDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.IdDetails;



	
	@RestController
	@RequestMapping("api")
	public class IdController {	
		IdDetails n = new IdDetails();
		IdDetailsDAOImpl b = new IdDetailsDAOImpl();
		@PostMapping("/addAmount")
		public void addAmount(

				@RequestParam("student_id") Integer studentId, 
				@RequestParam("amount_in_id") Integer amount) {
			//@RequestParam("library_wallet") Integer wallet){
			
			
			
			n.setStudentId(studentId);
			n.setDepositAmtInId(amount);
	
			try {
				b.addMoneyInId(studentId,amount);
				
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
@PostMapping("/updateMoney")
public void updateMoneyInId (
		@RequestParam("student_id") Integer studentId, 
        @RequestParam("amount_in_id") Integer amount) throws DbException {
	
	n.setStudentId(studentId);
	n.setDepositAmtInId(amount);
	
	
   b.updateMoneyInId(studentId, amount);

}

	@PostMapping("/updateAfterFine")
	public void updateAmtInId( 
			@RequestParam("student_id") Integer studentId, 
			@RequestParam("ISBN") long isbn) throws DbException {
	
	    b.updateAfterFinePay(studentId, isbn);
	}
	
	@PostMapping("/libWallet")
	public void updateAmtInWallet() throws DbException {
		b.libraryWallet();
		

	}

	
	}
