package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.deduction.IdDetailsImp;

@WebServlet("/IdServlet")
public class IdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String StudentId = request.getParameter("Student Id");
		int id = Integer.parseInt(StudentId);

		String AmountInId = request.getParameter("Amount In Id");
		int Amount = Integer.parseInt(AmountInId);

		IdDetailsImp j = new IdDetailsImp();

		int a = j.addMoneyInId(id, Amount);
		
		if (a==1) {
			 PrintWriter out = response.getWriter();
				out.println("\n <h1>Amount Added</h1>");
		}
		else {
			 PrintWriter out = response.getWriter();
				out.println("\n <h1>Invalid data</h1>");
		}
	}
}