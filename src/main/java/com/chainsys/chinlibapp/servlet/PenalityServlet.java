package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.fines.FineInfoImpl;
import com.chainsys.ldm.fines.FinesInfo;

@WebServlet("/PenalityServlet")
public class PenalityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PenalityServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String ISBN = request.getParameter("ISBN");
		long IsBN = Long.parseLong(ISBN);
		
		String StudentId = request.getParameter("StudentId");
	    int id=Integer.parseInt(StudentId);
		
		FinesInfo k = new FinesInfo();
		FineInfoImpl j = new FineInfoImpl();
		
		k.setISBN(IsBN);
		k.setStudentId(id);
	
	int a=	j.PenalityForBookLost(id,IsBN);
	
	PrintWriter out = response.getWriter();
		out.println("<h1>Penality for Book loss is "+a+"</h1>");
	
		
	
	}

}
