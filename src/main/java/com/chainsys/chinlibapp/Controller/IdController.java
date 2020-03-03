package com.chainsys.chinlibapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.ldm.deduction.IdDetails;
import com.chainsys.ldm.deduction.IdDetailsImp;



	
	@RestController
	@RequestMapping("api")
	public class IdController {	
	
		@PostMapping("/addAmount")
		public void addAmount(

				@RequestParam("student_id") Integer studentId, 
				@RequestParam("amount_in_id") Integer amount) {
			//@RequestParam("library_wallet") Integer wallet){
			
			IdDetails n = new IdDetails();
			
			n.setStudentId(studentId);
			n.setDepositAmtInId(amount);
			
			IdDetailsImp b = new IdDetailsImp();
			
			b.addMoneyInId(studentId,amount);
		}
		

}
