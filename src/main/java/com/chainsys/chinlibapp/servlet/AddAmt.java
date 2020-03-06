package com.chainsys.chinlibapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.service.IdService;

@WebServlet("/IdServlet")
public class AddAmt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddAmt() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String StudentId = request.getParameter("Student Id");
		int id = Integer.parseInt(StudentId);

		String AmountInId = request.getParameter("Amount In Id");
		int Amount = Integer.parseInt(AmountInId);

		IdService j = new IdService();
		try {

			int a = j.addMoneyInId(id, Amount);

			if (a == 1) {

				request.setAttribute("infoMessage", "<h2>Money Added !</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("AddAmount.jsp");
				rd.forward(request, response);
			} else {

				request.setAttribute("errorMessage", "<h2>Failed Id Already Exists !!</h2");
				RequestDispatcher rd = request.getRequestDispatcher("AddAmount.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}