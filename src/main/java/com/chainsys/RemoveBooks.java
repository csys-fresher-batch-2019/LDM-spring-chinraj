package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.bookList.BookList;
import com.chainsys.ldm.bookList.BookListImpl;
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
	  BookListImpl c = new BookListImpl();
	 int s1=  c.removeBooks(b);
	 
	   if(s1==1) {
		   PrintWriter out = response.getWriter();
			 out.println("\n");
				out.println("\n <h1>Delete Sucess </h1>");
	   }
				else {
					PrintWriter out = response.getWriter();
					 out.println("\n");
						out.println("\n <h1>ISBN invalid</h1>");
				}
	   }
	
	   
	 
	   
	 
	   
	   
	}

