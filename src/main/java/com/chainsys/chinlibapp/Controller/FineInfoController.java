package com.chainsys.chinlibapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.FineInfoDAO;
import com.chainsys.chinlibapp.dao.imp.FineInfoDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;

@RestController
@RequestMapping("api")
public class FineInfoController {

	FinesInfo m = new FinesInfo();
	FineInfoDAO b = new FineInfoDAOImpl();

	@PostMapping("/addFine")
	public void addFineInfo(@RequestParam("student_id") Integer studentId, @RequestParam("ISBN") long isbn,
			@RequestParam("fines_per_day") Integer finePerDay

	) throws DbException {

		m.setStudentId(studentId);
		m.setISBN(isbn);
		m.setFinePerDay(finePerDay);

		b.addFineInfo(m);

	}

	@PostMapping("/finePerStudent")
	public int finePerStudent(@RequestParam("student_id") Integer studentId, @RequestParam("ISBN") long isbn)
			throws Exception {
		return b.finePerStudent(studentId, isbn);
	}

	@PostMapping("/bookReturn")
	public void bookReturn(@RequestParam("student_id") Integer studentId, @RequestParam("ISBN") long isbn)
			throws DbException {
		b.bookReturn(studentId, isbn);
	}

	@PostMapping("/BookRenewal")
	public void bookRenewal(@RequestParam("student_id") Integer studentId, @RequestParam("ISBN") long isbn)
			throws DbException {
		b.renewal(studentId, isbn);

	}

	@PostMapping("/penalityForBookLost")
	public int penalityForBookLost(@RequestParam("student_id") Integer studentId, @RequestParam("ISBN") long isbn)
			throws DbException {
		return b.penalityForBookLost(studentId, isbn);
	}

	@PostMapping("/renewalCount")
	public int renewalCount(@RequestParam("student_id") Integer studentId, @RequestParam("ISBN") long isbn)
			throws DbException {
		return b.renewalCount(studentId, isbn);
	}
}