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

@WebServlet("/RemoveStudents")
public class RemoveStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveStudents() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String StudentId = request.getParameter("Student Id");
		int id = Integer.parseInt(StudentId);

		StudentInfo a = new StudentInfo();

		a.setStudentId(id);
		StudentInfoService b = new StudentInfoService();

		try {
			int v = b.removeStudent(id);
			if (v == 1) {
				request.setAttribute("infoMessage", "<h2>Delete Sucess !</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("RemoveStudents.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "<h2>Student Id Not Exists !!</h2");
			RequestDispatcher rd = request.getRequestDispatcher("RemoveStudents.jsp");
			rd.forward(request, response);
		}
	}
}