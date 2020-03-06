package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.bookSummary.BookSummary;
import com.chainsys.ldm.bookSummary.BookSummaryDAO;
import com.chainsys.ldm.bookSummary.BookSummaryImpl;


@WebServlet("/BsServlet")
public class BsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	
	   BookSummary SS = new BookSummary();
		String StudentId = request.getParameter("StudentId");
	    int id=Integer.parseInt(StudentId);
	    
	    
	    String ISBN = request.getParameter("ISBN");
	    long IsBN=Long.parseLong(ISBN);
	    
	    
	    String date1 =request.getParameter("BorrowedDate");
	    LocalDate ld = LocalDate.parse(date1);
	    String date2 =request.getParameter("DueDate");
        LocalDate d = LocalDate.parse(date2);
	 
	    
     
	 
	    SS.setstudentId(id); 
	    SS.setISBN(IsBN);
	    SS.setBorrowedDate(ld);
	    SS.setDueDate(d);
	  
	    
	    BookSummaryDAO S  = new BookSummaryImpl();
	    

	    try {
		int a = S.addBookInfo(SS);
		if (a==1) {
	
			PrintWriter out = response.getWriter();
			 out.println("\n");
				out.println("\n <h1>Borrow Sucess and mail sent</h1>");
	
		} else {
			PrintWriter out = response.getWriter();
			 out.println("\n");
				out.println("\n <h1>Book is not available (or) book already taken</h1>");
	}		  
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	}}