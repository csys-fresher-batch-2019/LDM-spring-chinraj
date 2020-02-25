package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.deduction.IdDetailsImp;

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
		    IdDetailsImp j = new IdDetailsImp();   
		
	int s=j.updateAmtInId(id, IsBN);
	int k=j.updateAmtInWallet(id, IsBN);
		
	

	
	
	if(s==1 && k==1) {
		 PrintWriter out = response.getWriter();
			out.println("\n <h1>Amount Detected and Added in wallet </h1>");
	}
	else {
		 PrintWriter out = response.getWriter();
			out.println("\n <h1>Invalid Data</h1>");
		
	}
		
}}
