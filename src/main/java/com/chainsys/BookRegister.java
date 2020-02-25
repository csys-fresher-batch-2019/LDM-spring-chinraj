package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.bookList.BookList;
import com.chainsys.ldm.bookList.BookListDAO;
import com.chainsys.ldm.bookList.BookListImpl;

@WebServlet("/BookRegister")
public class BookRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ISBN = request.getParameter("ISBN");
		long IsBN = Long.parseLong(ISBN);
		System.out.println(IsBN);
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

		BookListDAO S = new BookListImpl();
		try {
			BookList b = new BookList();
			b.setISBN(IsBN);
			b.setBookName(BookName);
			b.setPages(page);
			b.setAuthorName(AuthorName);
			b.setPublication(publication);
			b.setReleasedDate(ld);
			b.setPrice(pric);
			b.setRackNo(rcno);
			int a = S.addBooks(b);

			if (a == 1) {
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n <h1>Book Added</h1>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n <h1>ISBN already exits (or) invalid </h1>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
