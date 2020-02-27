package com.chainsys;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.bookSummary.BookSummaryImpl;


@WebServlet("/OnParticularDate")
public class OnParticularDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public OnParticularDate() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String date1 =request.getParameter("BorrowedDate");
		    LocalDate ld = LocalDate.parse(date1);
		
		    BookSummaryImpl n = new  BookSummaryImpl();
		     
			request.setAttribute("searchlist",n.onParticularDate(ld));

			RequestDispatcher rd = request.getRequestDispatcher("OnBorrowDate.jsp");
			rd.forward(request, response);

	}
}
