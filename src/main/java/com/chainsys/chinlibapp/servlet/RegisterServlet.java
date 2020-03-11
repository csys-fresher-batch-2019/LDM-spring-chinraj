package com.chainsys.chinlibapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.chinlibapp.model.StudentInfo;
import com.chainsys.chinlibapp.service.StudentInfoService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentInfoService S = new StudentInfoService();
		StudentInfo SS = new StudentInfo();

		String Name = request.getParameter("name");
		String DeptName = request.getParameter("Department Name");
		String StudentId = request.getParameter("Student Id");
		int id = Integer.parseInt(StudentId);
		String MailId = request.getParameter("mail_id");

		SS.setStudentName(Name);
		SS.setDepartmentName(DeptName);
		SS.setStudentId(id);
		SS.setMailId(MailId);

		try {
			int a = S.addStudents(SS);

			if (a != 0) {
				request.setAttribute("infoMessage", "<h2>Student Added !</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("AddStudents.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "<h2>Student Id Already Exists !!</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("AddStudents.jsp");
			rd.forward(request, response);
		}
	}

}
