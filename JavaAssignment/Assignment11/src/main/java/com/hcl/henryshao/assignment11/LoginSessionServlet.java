package com.hcl.henryshao.assignment11;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginhelper")
public class LoginSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String user = request.getParameter("username");
		System.out.println("Login Session: " + user);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", user);
		
		System.out.println("Redirect to Password");
		response.sendRedirect("./html/login2.html");
	}

}
