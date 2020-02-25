package com.chainsys;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.bookList.BookList;
import com.chainsys.ldm.bookList.BookListImpl;

@WebServlet("/SearchByBook")
public class SearchByBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchByBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Bookname = request.getParameter("bookname");
		System.out.println(Bookname);
		BookListImpl S = new BookListImpl();

		ArrayList<BookList> n = S.category(Bookname);

		request.setAttribute("searchlist", n);

		RequestDispatcher rd = request.getRequestDispatcher("SeBooks.jsp");
		rd.forward(request, response);

	}

}
