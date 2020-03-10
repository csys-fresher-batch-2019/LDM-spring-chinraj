package com.chainsys.chinlibapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.service.IdService;

@WebServlet("/UpdateAmount")
public class UpdateAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateAmount() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String StudentId = request.getParameter("Student Id");
		int id = Integer.parseInt(StudentId);

		String AddAmt = request.getParameter("Amount In Id");
		int Amount = Integer.parseInt(AddAmt);

		IdService j = new IdService();

	
			try {
				int k= j.updateMoneyInId( Amount,id);
				 
				 if(k==1) {
							request.setAttribute("infoMessage", "<h2>Update Sucess!</h2>");
							RequestDispatcher rd = request.getRequestDispatcher("UpdateMoney.jsp");
							rd.forward(request, response);
						} else {
							request.setAttribute("errorMessage", "<h2>Id Not Exists !!</h2");
							RequestDispatcher rd = request.getRequestDispatcher("UpdateMoney.jsp");
							rd.forward(request, response);
						}
				 
					} catch (Exception e) {
						e.printStackTrace();

					}
}
}