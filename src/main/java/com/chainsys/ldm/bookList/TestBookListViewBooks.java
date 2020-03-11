package com.chainsys.ldm.bookList;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.model.BookList;

public class TestBookListViewBooks {
	public static void main(String[] args) throws Exception {
		
		BookListDAOImpl obj = new BookListDAOImpl();
		System.out.println(" BookList  :");
		List<BookList> li = new ArrayList<BookList>();
	   li = obj.findBooks();
	   for(Object object:li)
		   System.out.println(object);
	 
	}
}
