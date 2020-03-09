package com.chainsys.chinlibapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;
import com.chainsys.chinlibapp.service.FineInfoService;

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
		FineInfoService j = new FineInfoService();
		
		k.setISBN(IsBN);
		k.setStudentId(id);
	
	int a;
	try {
		a = j.PenalityForBookLost(id,IsBN);
		request.setAttribute("infoMessage", "<h1>Penality for Book loss is "+a+"</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("Penality.jsp");
		rd.forward(request, response);
	
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			
	
	}

}
