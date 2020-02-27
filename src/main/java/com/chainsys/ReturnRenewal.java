package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.ldm.fines.FineInfoImpl;

@WebServlet("/ReturnRenewal")
public class ReturnRenewal extends HttpServlet {
	
	public ReturnRenewal() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String StudentId = request.getParameter("student_Id");
		int id = Integer.parseInt(StudentId);
		String ISBN = request.getParameter("ISBN");
		long IsBN = Long.parseLong(ISBN);

		String type = request.getParameter("Name");
		FineInfoImpl S = new FineInfoImpl();

		if (type.equals("Renewal")) {

			try {

				int i = S.renewal(id, IsBN);
				int a =S.renewalCount(id, IsBN);
				int b = S.FinePerStudent(id, IsBN);
				if (b==0 && a<=2 && i==1){
					PrintWriter out = response.getWriter();
					out.println("\n");
					out.println("\n <h1>RENEWAL SUCCESS</h1>");
				}
				else if(a>=2) {
					PrintWriter out = response.getWriter();
					out.println("\n");
					out.println("\n <h1>RENEWAL COUNT MORE THAN 2</h1>");
				}
				 else if (b>0){
					PrintWriter out = response.getWriter();
					out.println("\n");
					out.println("\n <h1> pay fine amount </h1>" + a);
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("ISBN", IsBN);
					RequestDispatcher rd = request.getRequestDispatcher("Fines.jsp");
					rd.forward(request, response);
					
				 }
				 else {
					 
					 HttpSession session = request.getSession();
					 session.setAttribute("id", id);
						session.setAttribute("ISBN", IsBN);
						RequestDispatcher rd = request.getRequestDispatcher("Fines.jsp");
						rd.forward(request, response);
					 
					 
				 }
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				int i = S.bookreturned(id, IsBN);
				int a1 = S.FinePerStudent(id, IsBN);
				if (i == 1 && a1 == 0) {
					PrintWriter out = response.getWriter();
					out.println("\n");
					out.println("\n <h1>RETURN SUCESS</h1>");
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
}
