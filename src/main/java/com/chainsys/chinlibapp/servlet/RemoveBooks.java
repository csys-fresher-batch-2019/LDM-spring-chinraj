package com.chainsys.chinlibapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.model.BookList;
import com.chainsys.chinlibapp.service.BookListService;
@WebServlet("/RemoveBooks")

public class RemoveBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public RemoveBooks() {
        super();
      }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String ISBN = request.getParameter("ISBN");
	long IsBN = Long.parseLong(ISBN);

	 BookList b = new BookList();
	b.setISBN(IsBN);
	BookListService c = new BookListService();
	
	 
	
			try {
				 int s1=  c.removeBooks(b.getISBN());
				   if(s1==1) {
							request.setAttribute("infoMessage", "<h2>Book Removed!</h2>");
							RequestDispatcher rd = request.getRequestDispatcher("RemoveBook.jsp");
							rd.forward(request, response);
						} else {
							request.setAttribute("errorMessage", "<h2>ISBN Not Exists !!</h2");
							RequestDispatcher rd = request.getRequestDispatcher("RemoveBook.jsp");
							rd.forward(request, response);
						}
					} catch (Exception e) {
						e.printStackTrace();

					}
				}
	 
	   
	   
	}

