package com.chainsys.chinlibapp.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.BookSummaryImpl;
import com.chainsys.chinlibapp.model.BookSummary;

@RestController
@RequestMapping("api")
public class BookSumControl {

	BookSummaryImpl a = new BookSummaryImpl();

	@PostMapping("/BookSummary")
	public void borrowBook(
			@RequestParam("studnt_id") Integer id, 
			@RequestParam("ISBN") Long isbn,
			@RequestParam("borrowed_date") String date,
			@RequestParam("renewal_count") Integer renewalCount,
			@RequestParam("due_date") String date1,
			@RequestParam("return_date") String date2,
			@RequestParam("status") String status){

		BookSummary b = new BookSummary();

		b.setISBN(isbn);
		b.setstudentId(id);
		LocalDate ld = LocalDate.parse(date);
		b.setBorrowedDate(ld);
		b.setRenewalCount(renewalCount);
		LocalDate ld1 = LocalDate.parse(date);
		b.setDueDate(ld1);
		LocalDate ld2 = LocalDate.parse(date);
		b.setReturnDate(ld2);
		b.setStatus(status);

		try {
			a.addBookInfo(b);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@GetMapping("/viewBookSummary")
	public List<BookSummary> viewBookSummary() {
		return a.viewBookSummary();
	}

	@GetMapping("/onParticularDate")
	public List<BookSummary> onParticularDate(@RequestParam("borrowed_date") String date){
		
		LocalDate ld = LocalDate.parse(date);
		
		return a.onParticularDate(ld);
	}
	
	
	
	
}
