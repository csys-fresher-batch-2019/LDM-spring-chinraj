package com.chainsys.ldm.bookList;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.chinlibapp.dao.imp.BookListDAOImpl;
import com.chainsys.chinlibapp.model.Book;

public class TestBooListAddBooks {

	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		Book List1 = new Book();
		BookListDAOImpl Book1 = new BookListDAOImpl();
		System.out.println("Enter ISBN :");
		List1.setISBN(s.nextLong());
		System.out.println("Enter BookName :");
		List1.setBookName(s.next());
		System.out.println("Enter No of pages :");
		List1.setPages(s.nextInt());
		System.out.println("Enter Authorname :");
		List1.setAuthorName(s.next());
		System.out.println("Enter Publications :");
		List1.setPublication(s.next());
		System.out.println("Enter releasedDate:");
		String date1 = s.next();
		List1.setReleasedDate(LocalDate.parse(date1));
		System.out.println("Enter price :");
		List1.setPrice(s.nextInt());
	
		System.out.println("Enter rackNo :");
		List1.setRackNo(s.nextInt());

		Book1.saveBooks(List1);
		s.close();

	}

}
