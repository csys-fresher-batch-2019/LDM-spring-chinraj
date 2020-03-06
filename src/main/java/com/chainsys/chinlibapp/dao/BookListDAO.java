package com.chainsys.chinlibapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.chinlibapp.model.BookList;

public interface BookListDAO {
int addBooks(BookList books);
int removeBooks(long isbn);
public List<BookList> viewBooks();
public  ArrayList<BookList> category(String name);
}