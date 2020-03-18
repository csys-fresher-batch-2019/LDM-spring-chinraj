package com.chainsys.chinlibapp.dao;

import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.Book;

public interface BookListDAO {
	int saveBooks(Book books) throws DbException;

	int deleteBook(long isbn) throws DbException;

	public List<Book> findBooks() throws DbException;

	public List<Book> findIsbn() throws DbException ;

	public List<Book> searchByBook(String name) throws DbException;
}