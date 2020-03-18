package com.chainsys.chinlibapp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.model.Book;
import com.chainsys.chinlibapp.service.BookListService;

@WebServlet("/BookRegister")
public class BookRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ISBN = request.getParameter("ISBN");
		long IsBN = Long.parseLong(ISBN);

		String BookName = request.getParameter("book_name");
		String pages = request.getParameter("pages");
		int page = Integer.parseInt(pages);

		String AuthorName = request.getParameter("author_name");
		String publication = request.getParameter("publication");

		String date1 = request.getParameter("released_date");
		LocalDate ld = LocalDate.parse(date1);

		String price = request.getParameter("price");
		int pric = Integer.parseInt(price);

		String rackNo = request.getParameter("rack_no");
		int rcno = Integer.parseInt(rackNo);
		String category = request.getParameter("category");

		BookListService S = new BookListService();

		Book b = new Book();
		b.setISBN(IsBN);
		b.setBookName(BookName);
		b.setPages(page);
		b.setAuthorName(AuthorName);
		b.setPublication(publication);
		b.setReleasedDate(ld);
		b.setPrice(pric);
		b.setRackNo(rcno);
		b.setCategory(category);
		try {
			int a = S.addBooks(b);
			if (a == 1) {
				request.setAttribute("infoMessage", "<h2>Book Added !</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("AddBooks.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "<h2>ISBN Already Exists !!</h2");
			RequestDispatcher rd = request.getRequestDispatcher("AddBooks.jsp");
			rd.forward(request, response);
		}
	}
}
