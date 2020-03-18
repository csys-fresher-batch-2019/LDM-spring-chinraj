package com.chainsys.ldm.bookList;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.model.Book;

public class TestBookListViewBooks {
	public static void main(String[] args) throws Exception {
	
		List<Book> li = new ArrayList<Book>();

	
			BookListDAOImpl obj = new BookListDAOImpl();
			   li = obj.findBooks();
		
	
	   for(Object object:li)
		   
		   System.out.println(object);
	 
	}
}
