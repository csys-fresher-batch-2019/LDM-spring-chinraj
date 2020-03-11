package com.chainsys.chinlibapp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.model.BookSummary;
import com.chainsys.chinlibapp.service.BookSumService;


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
	  
	    
	    BookSumService S = new  BookSumService();
	    

	    try {
		int a = S.addBookInfo(SS);
				if (a == 1) {
					request.setAttribute("infoMessage", "<h2>Borrow Sucess And Mail Sent!! !</h2>");
					RequestDispatcher rd = request.getRequestDispatcher("BS.jsp");
					rd.forward(request, response);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "<h2> Borrow Failed ISBN or StudentId not Avilable !!</h2");
				RequestDispatcher rd = request.getRequestDispatcher("BS.jsp");
				rd.forward(request, response);
			}
	   
	}}