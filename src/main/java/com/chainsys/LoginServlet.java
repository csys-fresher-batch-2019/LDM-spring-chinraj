package com.chainsys;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.ldm.logIn.LogIn;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("Email ID");
		String password = request.getParameter("Password");
		System.out.println(email);
		System.out.println(password);
		LogIn ur = new LogIn();
		boolean s = ur.adminlogin(email, password);
		System.out.println(s);
		//boolean returned = false;
		try {
			if (s==true) {

				HttpSession session = request.getSession();
				session.setAttribute("value", email);
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("AdminLogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
