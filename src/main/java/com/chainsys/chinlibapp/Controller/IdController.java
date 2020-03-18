package com.chainsys.chinlibapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.IdDetailsDAOImpl;
import com.chainsys.chinlibapp.dto.Message;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.IdDetails;

@RestController
@RequestMapping("api")
public class IdController {
	IdDetails n = new IdDetails();
	Message msg = new Message();
	IdDetailsDAOImpl b = new IdDetailsDAOImpl();

	@PostMapping("/addAmount")

	public Message addAmount(

			@RequestParam("student_id") Integer studentId, @RequestParam("amount_in_id") Integer amount)
			throws DbException {

		n.setStudentId(studentId);
		n.setDepositAmtInId(amount);

		int rows = b.addMoneyInId(studentId, amount);
		if (rows == 1) {
			msg.setInfoMessage("sucess");
		}
		return msg;
	}

	@PostMapping("/updateMoney")
	public void updateMoneyInId(@RequestParam("student_id") Integer studentId,
			@RequestParam("amount_in_id") Integer amount) throws DbException {

		n.setStudentId(studentId);
		n.setDepositAmtInId(amount);

		b.updateMoneyInId(studentId, amount);

	}

	@PostMapping("/updateAfterFine")
	public void updateAmtInId(@RequestParam("student_id") Integer studentId, @RequestParam("ISBN") long isbn)
			throws DbException {

		// b.updateAfterFinePay(studentId, isbn);
	}

	@PostMapping("/libWallet")
	public void updateAmtInWallet() throws DbException {
		b.libraryWallet();

	}

}
