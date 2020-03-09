package com.chainsys.chinlibapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;
import com.chainsys.chinlibapp.service.FineInfoService;

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
		  FineInfoService m = new FineInfoService();
		  
		  n.setFinePerDay(Fd);
		  n.setStudentId(id);
		  n.setISBN(IsBN);
		  
		  
		  
		  try {
			m.AddFineInfo(n);
		} catch (DbException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			m.AddFineInfo1(n);
		} catch (DbException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	try {
		m.TotalFinesAmt(n);
	} catch (DbException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
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
	request.setAttribute("errorMessage", "<h2> No Fine !!</h2");
	HttpSession session = request.getSession();
	session.setAttribute("id",id);
	session.setAttribute("ISBN", IsBN);
	RequestDispatcher rd = request.getRequestDispatcher("ReturnAndRenewal.jsp");
	rd.forward(request, response);
}
} catch (Exception e) {
e.printStackTrace();

}	
	}}
