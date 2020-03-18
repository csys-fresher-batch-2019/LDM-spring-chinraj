package com.chainsys.chinlibapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.BookListDAO;
import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.Book;

@Service
public class BookListService {

	BookListDAO bookListDAO = new BookListDAOImpl();

	public int addBooks(Book books) throws DbException {
		return bookListDAO.saveBooks(books);

	}

	public int removeBooks(long isbn) throws DbException {
		return bookListDAO.deleteBook(isbn);

	}

	public List<Book> viewBooks() throws DbException {
		return bookListDAO.findBooks();

	}
	public List<Book> findIsbn() throws DbException {
		return bookListDAO.findIsbn();
	}

	public List<Book> searchByBook(String name) throws DbException {
		return bookListDAO.searchByBook(name);

	}

}
