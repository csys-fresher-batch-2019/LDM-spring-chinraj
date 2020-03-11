package com.chainsys.chinlibapp.dao;

import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookList;

public interface BookListDAO {
	int saveBooks(BookList books) throws DbException;

	int deleteBook(long isbn) throws DbException;

	public List<BookList> findBooks() throws DbException;

	public List<BookList> searchByBook(String name) throws DbException;
}