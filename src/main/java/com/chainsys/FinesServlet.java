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
import com.chainsys.ldm.fines.FinesInfo;

@WebServlet("/FinesServlet")
public class FinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FinesServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String ISBN = request.getParameter("ISBN");
		    long IsBN=Long.parseLong(ISBN);
		  String  StudentId = request.getParameter("Student Id");
		  int id = Integer.parseInt(StudentId);
		  String FinePerDay = request.getParameter("Fine per day");
		  int Fd = Integer.parseInt(FinePerDay); 
		  FinesInfo n = new FinesInfo();
		  FineInfoImpl m = new FineInfoImpl();
		  
		  n.setFinePerDay(Fd);
		  n.setStudentId(id);
		  n.setISBN(IsBN);
		  
		  
		  
		  m.AddFineInfo(n);
		m.AddFineInfo1(n);
		
	m.TotalFinesAmt(n);
	
	try {
		int a= m.FinePerStudent(id, IsBN);
if(a>0) {
		
		HttpSession session = request.getSession();
		session.setAttribute("id",id);
		session.setAttribute("ISBN", IsBN);
		RequestDispatcher rd = request.getRequestDispatcher("FineDetect.jsp");
		rd.forward(request, response);
		
}	
else{
{
	
	PrintWriter out = response.getWriter();
	 out.println("\n");
		out.println("<h1>No fine<h1>");	
}

}


	} catch (Exception e) {
		e.printStackTrace();
	}	
	}}
