package com.chainsys.chinlibapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.service.IdService;

@WebServlet("/FineDetect")
public class FineDetect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FineDetect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StudentId = request.getParameter("Student Id");
		int id = Integer.parseInt(StudentId);

		  String ISBN = request.getParameter("ISBN");
		    long IsBN=Long.parseLong(ISBN);    
		    IdService j = new IdService();   
		
	int s=j.updateAmtInId(id, IsBN);
	int k=j.updateAmtInWallet(id, IsBN);
		
	

	
	try {
	if(s==1 && k==1) {
		request.setAttribute("infoMessage", "<h2>Amount Detected and added in Lib wallet !</h2>");
		RequestDispatcher rd = request.getRequestDispatcher("ReturnRenewal.jsp");
		rd.forward(request, response);
	} else {
		request.setAttribute("errorMessage", "<h2>Invalid data !!</h2");
		
	}
} catch (Exception e) {
	e.printStackTrace();

}
}}
