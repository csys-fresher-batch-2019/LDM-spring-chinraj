package com.chainsys.chinlibapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.FineInfoImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;

@RestController
@RequestMapping("api")
public class FineInfoController {
	
    FinesInfo m = new FinesInfo();
	FineInfoImpl b = new FineInfoImpl();
	
	
	@PostMapping("/addFine")
	public void AddFineInfo(
			@RequestParam("student_id") Integer studentId,
			@RequestParam("ISBN") long isbn, 
			@RequestParam("fines_per_day") Integer finePerDay

			) throws DbException {
	
	m.setStudentId(studentId);
	m.setISBN(isbn);
	m.setFinePerDay(finePerDay);
	
	
	b.AddFineInfo(m);
	b.AddFineInfo1(m);
	b.TotalFinesAmt(m);
}


	@PostMapping("/finePerStudent")
	public int FinePerStudent(
			@RequestParam("student_id") Integer studentId,
			@RequestParam("ISBN") long isbn) throws DbException {
				return b.FinePerStudent(studentId, isbn);
	}

	@PostMapping("/bookReturn")
	public void BookReturn(
			@RequestParam("student_id") Integer studentId,
			@RequestParam("ISBN") long isbn) throws DbException {
				 b.bookreturned(studentId, isbn);
	}


	@PostMapping("/BookRenewal")
	public void BookRenewal(
			@RequestParam("student_id") Integer studentId,
			@RequestParam("ISBN") long isbn) throws DbException {
				 b.renewal(studentId, isbn);

	}

	@PostMapping("/PenalityForBookLost")
	public int PenalityForBookLost(
			@RequestParam("student_id") Integer studentId,
			@RequestParam("ISBN") long isbn) throws DbException {
				return b.PenalityForBookLost(studentId, isbn);
	}
	@PostMapping("/renewalCount")
	public int renewalCount(
			@RequestParam("student_id") Integer studentId,
			@RequestParam("ISBN") long isbn) throws DbException {
				return b.renewalCount(studentId, isbn);
}
}