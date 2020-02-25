package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.studentInfo.StudentInfo;
import com.chainsys.ldm.studentInfo.StudentInfoImpl;
@WebServlet("/RemoveStudents")
public class RemoveStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RemoveStudents() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String StudentId = request.getParameter("Student Id");
		    int id=Integer.parseInt(StudentId);
		     
		    StudentInfo a =new  StudentInfo();
		    
		    a.setStudentId(id);		    
		    StudentInfoImpl b = new StudentInfoImpl();
		    
		    int v= b.removeStudent(a);
		    if(v==1) {
		    	 PrintWriter out = response.getWriter();
	
					out.println("\n <h1>Student removed </h1>");
		    }
		    else {
		    	 PrintWriter out = response.getWriter();
				 out.println("\n");
					out.println("\n<body style='background-color:powderblue'> <h1>Student id not exists</h1></body>");
		    }
}}