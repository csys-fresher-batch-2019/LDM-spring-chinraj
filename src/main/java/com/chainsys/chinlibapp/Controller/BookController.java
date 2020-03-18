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

import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.dto.Message;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.Book;
import com.chainsys.chinlibapp.model.BookSummary;

@RestController
@RequestMapping("api")
public class BookController {
	BookListDAOImpl a = new BookListDAOImpl();
	Message msg = new Message();
	@PostMapping("/addbooks")
	public ResponseEntity<Message> addBooks(@RequestParam("ISBN") Long isbn, @RequestParam("book_name") String bookName,
			@RequestParam("pages") Integer pages, @RequestParam("author_name") String authorName,
			@RequestParam("publication") String publication, @RequestParam("released_date") String date,
			@RequestParam("category") String category, @RequestParam("price") Integer price,
			@RequestParam("rack_no") Integer rackNo) {

		Book b = new Book();

		b.setISBN(isbn);
		b.setBookName(bookName);
		b.setPages(pages);
		b.setAuthorName(authorName);
		b.setPublication(publication);
		b.setPrice(price);
		LocalDate ld = LocalDate.parse(date);
		b.setReleasedDate(ld);
		b.setCategory(category);
		b.setRackNo(rackNo);

		try {
		
		 a.saveBooks(b);
			
			return new ResponseEntity<Message>(HttpStatus.OK);
		}
			
			
			catch (Exception e) {
			e.printStackTrace();
		
			msg.setErrorMessage(e.getMessage());
		
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
			
		}
	}	

	@GetMapping("/viewBooks")

	public List<Book> viewBooks() throws DbException {
		
		return a.findBooks();
		}

	
	
	@PostMapping("/removeBooks")
	public ResponseEntity<?> removeBooks(@RequestParam long isbn) throws DbException {
		
	try {	
	a.deleteBook(isbn);
	return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	catch (Exception e) {
	e.printStackTrace();

	msg.setErrorMessage(e.getMessage());

	return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}
}}

