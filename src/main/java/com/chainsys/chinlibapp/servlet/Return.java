package com.chainsys.chinlibapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.chinlibapp.dao.imp.FineInfoDAOImpl;

@WebServlet("/Return")
public class Return extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String StudentId = request.getParameter("student_Id");
		int id = Integer.parseInt(StudentId);
		String ISBN = request.getParameter("ISBN");
		long IsBN = Long.parseLong(ISBN);

		FineInfoDAOImpl S = new FineInfoDAOImpl();

		try {
			int i = S.bookReturn(id, IsBN);
			int a1 = S.finePerStudent(id, IsBN);
			if (i == 1 && a1 == 0) {
				request.setAttribute("infoMessage", "Return Sucess");
				RequestDispatcher rd = request.getRequestDispatcher("ReturnRenewal.jsp");
				rd.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("ISBN", IsBN);
				RequestDispatcher rd = request.getRequestDispatcher("Fines.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
