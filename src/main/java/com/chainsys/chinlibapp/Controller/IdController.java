package com.chainsys.chinlibapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.IdDetailsImp;
import com.chainsys.chinlibapp.model.IdDetails;



	
	@RestController
	@RequestMapping("api")
	public class IdController {	
		IdDetails n = new IdDetails();
		IdDetailsImp b = new IdDetailsImp();
		@PostMapping("/addAmount")
		public void addAmount(

				@RequestParam("student_id") Integer studentId, 
				@RequestParam("amount_in_id") Integer amount) {
			//@RequestParam("library_wallet") Integer wallet){
			
			
			
			n.setStudentId(studentId);
			n.setDepositAmtInId(amount);
	
			b.addMoneyInId(studentId,amount);
		}
		
@PostMapping("/updateMoney")
public void updateMoneyInId (
		@RequestParam("student_id") Integer studentId, 
        @RequestParam("amount_in_id") Integer amount) {
	
	n.setStudentId(studentId);
	n.setDepositAmtInId(amount);
	
	
   b.updateAmtInId(studentId,amount);

}

	@PostMapping("/updateAmtAftFine")
	public void updateAmtInId( 
			@RequestParam("student_id") Integer studentId, 
			@RequestParam("ISBN") long isbn) {
	
	    b.updateAmtInId(studentId, isbn);
	}
	
	@PostMapping("/updateAmtInWallet")
	public void updateAmtInWallet(
			@RequestParam("student_id") Integer studentId, 
			@RequestParam("ISBN") long isbn) {
	
		b.updateAmtInWallet(studentId, isbn);
		
	}
	@PostMapping("/libWallet")
	public void updateAmtInWallet() {
		b.libraryWallet();
		

	}

	
	}
