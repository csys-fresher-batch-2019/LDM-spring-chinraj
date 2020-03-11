package com.chainsys.chinlibapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.chinlibapp.service.FineInfoService;

@WebServlet("/ReturnRenewal")
public class ReturnRenewal extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String StudentId = request.getParameter("student_Id");
		int id = Integer.parseInt(StudentId);
		String ISBN = request.getParameter("ISBN");
		long IsBN = Long.parseLong(ISBN);
       
		String type = request.getParameter("Name");
		FineInfoService S = new FineInfoService();

		if (type.equals("Renewal")) {

			try {

				int i = S.renewal(id, IsBN);
				int a =S.renewalCount(id, IsBN);
				//int b = S.FinePerStudent(id, IsBN);
				if (a<=2 && i==1){
					request.setAttribute("infoMessage", "<h2>Renewal Sucess!!</h2");
					RequestDispatcher rd = request.getRequestDispatcher("ReturnRenewal.jsp");
					rd.forward(request, response);
				}
				else if(a>=2) {
					request.setAttribute("errorMessage", "<h2>Renewal Count More than 2 !!</h2");
					RequestDispatcher rd = request.getRequestDispatcher("ReturnRenewal.jsp");
					rd.forward(request, response);
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
				 HttpSession session = request.getSession();
				 session.setAttribute("id", id);
					session.setAttribute("ISBN", IsBN);
					RequestDispatcher rd = request.getRequestDispatcher("Fines.jsp");
					rd.forward(request, response);
			}
			
		} else {
			try {
				int i = S.bookreturned(id, IsBN);
				int a1 = S.FinePerStudent(id, IsBN);
				if (i == 1 && a1 == 0) {
					request.setAttribute("infoMessage", "<h2>Return Sucess Sucess!!</h2");
					RequestDispatcher rd = request.getRequestDispatcher("ReturnRenewal.jsp");
					rd.forward(request, response);
				} 
			} catch (Exception e) {

				e.printStackTrace();
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("ISBN", IsBN);
				RequestDispatcher rd = request.getRequestDispatcher("Fines.jsp");
				rd.forward(request, response);
				
			}
		}
	}	
}
