package com.chainsys.chinlibapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.model.Book;
import com.chainsys.chinlibapp.service.BookListService;

@WebServlet("/SearchByBook")
public class SearchByBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchByBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Bookname = request.getParameter("bookname");
		BookListService S = new BookListService();

		List<Book> n = null;
		try {
			n = S.searchByBook(Bookname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("searchlist", n);

		RequestDispatcher rd = request.getRequestDispatcher("SeBooks.jsp");
		rd.forward(request, response);

	}
}
