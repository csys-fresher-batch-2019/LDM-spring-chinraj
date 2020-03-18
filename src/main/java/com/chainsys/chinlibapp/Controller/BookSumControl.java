package com.chainsys.chinlibapp.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.BookSummaryDAOImpl;
import com.chainsys.chinlibapp.dto.Message;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookSummary;

@RestController
@RequestMapping("api")
public class BookSumControl {

	BookSummaryDAOImpl a = new BookSummaryDAOImpl();

	@PostMapping("/BookSummary")
	public ResponseEntity<Message> borrowBook(
			@RequestParam("studnt_id") Integer id, 
			@RequestParam("ISBN") Long isbn,
			@RequestParam("borrowed_date") String date,
			@RequestParam("due_date") String date1)
		 
	{
		BookSummary b = new BookSummary();
	
		b.setISBN(isbn);
		b.setstudentId(id);
		LocalDate ld = LocalDate.parse(date);
		b.setBorrowedDate(ld);

		LocalDate ld1 = LocalDate.parse(date1);
		b.setDueDate(ld1);
	
		try {
			
			 a.saveBorrowInfo(b);
				
				return new ResponseEntity<Message>(HttpStatus.OK);
			}
				
				
				catch (Exception e) {
				e.printStackTrace();
			Message msg = new Message();
				msg.setErrorMessage(e.getMessage());
			
				return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
				
			}
		}	


	@GetMapping("/viewBookSummary")
	public List<BookSummary> viewBookSummary() throws DbException {
		return a.findBookSummary();
	}

	@GetMapping("/onParticularDate")
	public List<BookSummary> onParticularDate(@RequestParam("borrowed_date") String date) throws DbException {

		LocalDate ld = LocalDate.parse(date);

		return a.onParticularDate(ld);
	}

}
