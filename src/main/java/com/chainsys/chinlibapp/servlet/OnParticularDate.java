package com.chainsys.chinlibapp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.service.BookSumService;


@WebServlet("/OnParticularDate")
public class OnParticularDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookSumService n = new  BookSumService();
		
		 String date1 =request.getParameter("BorrowedDate");
		    LocalDate ld = LocalDate.parse(date1);
		
		    
		     
			request.setAttribute("searchlist",n.onParticularDate(ld));

			RequestDispatcher rd = request.getRequestDispatcher("OnBorrowDate.jsp");
			rd.forward(request, response);

	}
}
