package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.deduction.IdDetailsImp;

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

		IdDetailsImp j = new IdDetailsImp();

	int k= j.updateMoneyInId(Amount,id );
	 
	 if(k==1) {
		 PrintWriter out = response.getWriter();
			out.println("<h1>Money updated</h1>");
			
	 }
	 else {
		 PrintWriter out = response.getWriter();
			out.println("<h1>Failed to update</h1>");
	 }

}
}