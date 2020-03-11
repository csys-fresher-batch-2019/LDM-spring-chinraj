package com.chainsys.chinlibapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.BookListDAO;
import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookList;

@Service
public class BookListService {

	BookListDAO bookListDAO = new BookListDAOImpl();

	public int addBooks(BookList books) throws DbException {
		return bookListDAO.saveBooks(books);

	}

	public int removeBooks(long isbn) throws DbException {
		return bookListDAO.deleteBook(isbn);

	}

	public List<BookList> viewBooks() throws DbException {
		return bookListDAO.findBooks();

	}

	public List<BookList> searchByBook(String name) throws DbException {
		return bookListDAO.searchByBook(name);

	}

}
