package com.chainsys.ldm.bookSummary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chainsys.chinlibapp.dao.imp.BookSummaryDAOImpl;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.BookSummary;


public class TestBookSummary {
	
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		
	logger.info(" 1.BookInfo\n 2.ParticularDate\n 3. View BookSummary ");

		Scanner n = new Scanner(System.in);

		BookSummaryDAOImpl BK = new BookSummaryDAOImpl();
		BookSummary obj = new BookSummary();
		int n1 = n.nextInt();
		switch (n1) {

		case 1: {  
			System.out.println("Enter ISBN:");
			long fg = n.nextLong();
			obj.setISBN(fg);
			if (BK.checkBookStatus(fg)) {
				 logger.info("Enter Student Id:");
				obj.setstudentId(n.nextInt());

				 logger.info("Enter borrowedDate:");
				String date = n.next();
				obj.setBorrowedDate(LocalDate.parse(date));
				 logger.info("Enter dueDate:");
				String date1 = n.next();

				obj.setDueDate(LocalDate.parse(date1));
				 logger.info("Enter ReturnDate:");
				obj.setReturnDate(LocalDate.now());
				
       

				obj.setStatus(n.next());

				BK.addBookInfo(obj);

			} else {
				 logger.info("book is Not Available");
			}

		}
			break;
		case 2: {
			 logger.info("Enter borrowedDate");
			String date = n.next();
			LocalDate d = LocalDate.parse(date);
			BK.onParticularDate(d);
		}
			break;
		
		case 3:{
				
			BookSummaryDAOImpl obj1 = new BookSummaryDAOImpl();
				System.out.println(" BookSummary :");
				List<BookSummary> li = new ArrayList<BookSummary>();
			   li = obj1.viewBookSummary();
			   for(Object object:li)
				   System.out.println(object);
			 
			}n.close();
		}
		}	
	}