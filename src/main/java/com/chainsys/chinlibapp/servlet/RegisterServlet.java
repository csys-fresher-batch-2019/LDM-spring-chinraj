package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.ldm.studentInfo.StudentInfo;
import com.chainsys.ldm.studentInfo.StudentInfoDAO;
import com.chainsys.ldm.studentInfo.StudentInfoImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentInfoDAO S = new StudentInfoImpl();
		StudentInfo SS = new StudentInfo();

		String Name = request.getParameter("name");
		String DeptName = request.getParameter("DeptName");
		String StudentId = request.getParameter("Student Id");
		int id = Integer.parseInt(StudentId);
		String MailId = request.getParameter("mail_id");

		SS.setStudentName(Name);
		SS.setDeptName(DeptName);
		SS.setStudentId(id);
		SS.setMailId(MailId);

		try {
			int a = S.addStudents(SS);
			if (a == 1) {
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n <h1>Student Added </h1>");
			} else {

				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n <h1>Student id already exists</h1>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
