package com.chainsys.chinlibapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookList;

public interface BookListDAO {
int addBooks(BookList books) throws DbException;
int removeBooks(long isbn) throws DbException;
public List<BookList> viewBooks() throws DbException;
public  ArrayList<BookList> category(String name) throws DbException;
}