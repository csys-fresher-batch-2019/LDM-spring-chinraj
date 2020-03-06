package com.chainsys.chinlibapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.BookListDAO;
import com.chainsys.chinlibapp.dao.imp.BookListImpl;
import com.chainsys.chinlibapp.model.BookList;

@Service
public class BookListService {
	
	BookListDAO bookListDAO = new BookListImpl();

	public int addBooks(BookList books) {
		return bookListDAO.addBooks(books);

	}

	public int removeBooks(long isbn) {
		return bookListDAO.removeBooks(isbn);

	}

	public List<BookList> viewBooks() {
		return bookListDAO.viewBooks();
		
	}

	public  ArrayList<BookList> category(String name) {
		return bookListDAO.category(name);
		
		
	}

}
