package com.chainsys.chinlibapp.Controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookList;

@RestController
@RequestMapping("api")
public class BookController {
	BookListDAOImpl a = new BookListDAOImpl();

	@PostMapping("/addbooks")
	public void addBooks(@RequestParam("ISBN") Long isbn, @RequestParam("book_name") String bookName,
			@RequestParam("pages") Integer pages, @RequestParam("author_name") String authorName,
			@RequestParam("publication") String publication, @RequestParam("released_date") String date,
			@RequestParam("category") String category, @RequestParam("price") Integer price,
			@RequestParam("rack_no") Integer rackNo) {

		BookList b = new BookList();

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
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@GetMapping("/viewBooks")
	public List<BookList> viewBooks() throws DbException {
		return a.findBooks();
	}

	@PostMapping("/removeBooks")
	public void removeBooks(@RequestParam long isbn) throws DbException {
		a.deleteBook(isbn);

	}

}
