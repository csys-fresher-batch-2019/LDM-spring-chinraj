package com.chainsys.ldm.bookList;

import java.util.Scanner;

import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.model.BookList;

public class TestBookListRemoveBooks {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		BookList b = new BookList();
		BookListDAOImpl obj = new BookListDAOImpl();
		System.out.println(" ISBN to be removed :");
		b.setISBN(s.nextLong());
	   obj.deleteBook(b.getISBN());
		s.close();
	}
}
